package no.bibsys.overdueNotices.rest;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import no.bibsys.overdueNotices.OverdueAnalyticsService;
import no.bibsys.overdueNotices.Location;
import no.bibsys.overdueNotices.OverdueNotice;
import no.bibsys.overdueNotices.OverdueNotice.OverdueStatus;
import no.bibsys.overdueNotices.OverdueService;




@Path("/data")
public class OverdueRestService {

	private static final transient Logger log = LoggerFactory.getLogger(OverdueRestService.class);
    private Properties overdueProperties;
    private String institutionServiceHost;

	public OverdueRestService(){
	    
	    String overduePropertiesFile = "/fasehome/applikasjoner/overdue/overdue.properties";
        try {
            overdueProperties = new Properties();
            overdueProperties.load(new FileReader(overduePropertiesFile));
            
            institutionServiceHost = overdueProperties.getProperty("institutionhost", "ada.bibsys.no:8082");
        } catch (IOException e) {
            log.error("Unable to load properties: {}", overduePropertiesFile);
        }

	    
	}
	
	@GET
	@Path("/presentation/{library}/{barcode}")
	@Produces("application/json; charset=UTF-8")
	public Response getOverdueNoticePresentation(@PathParam("library") String library, @PathParam("barcode") String barcode){


		OverdueNotice overdueNotice =OverdueAnalyticsService.Factory.instance(institutionServiceHost).getOverdueNotice(barcode, library);

		String presentation = overdueNotice.reportPresentation();
		List<String> presentationValues = Arrays.asList(presentation.split("\\|"));

		ObjectMapper mapper = new ObjectMapper();
		try {
			return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(presentationValues)).type(MediaType.APPLICATION_JSON_TYPE).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity("Failed to parse input").type(MediaType.TEXT_HTML_TYPE).build();
		}
	}


	@GET
	@Path("/report/{library}/{location}")
	@Produces("application/json; charset=UTF-8")
	public Response getReport(@PathParam("library") String library, @PathParam("location") String location){

		ObjectMapper mapper = new ObjectMapper();
		
		List<OverdueNotice> analyticsReport = OverdueAnalyticsService.Factory.instance(institutionServiceHost).getAnalyticsReport(library);
		Collections.sort(analyticsReport);


		List<String> barcodeList = new ArrayList<>();
		for (OverdueNotice overdueNotice : analyticsReport) {
			if(!overdueNotice.location().equals("Depotbiblioteket")){
				log.debug("location = " + location + " -> " + overdueNotice.location());
			}
			if(overdueNotice.location().equals(location)&&!"".equals(overdueNotice.barcode())){
				barcodeList.add(overdueNotice.barcode());
			}
		}
		try {
			return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(barcodeList)).type(MediaType.APPLICATION_JSON_TYPE).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity("Failed to parse input").type(MediaType.TEXT_HTML_TYPE).build();
		}
	}

	@GET
	@Path("/claimsreport/{library}/{type}")
	@Produces("application/json; charset=UTF-8")
	public Response getReturnedClaimsReport(@PathParam("library") String library,
			@PathParam("type") String type){

		ObjectMapper mapper = new ObjectMapper();

		List<String> claimsReport = OverdueService.Factory.instance().createClaimsReport(library);

		log.debug("type = " + type);
		
		List<Object> claimsReportElementList = new ArrayList<>();
		String claimString = "";
		for (String claim : claimsReport) {
			if(type.equals("text")){
				String[] elements = claim.split("\\|");
				claimsReportElementList.add(new ArrayList<>(Arrays.asList(elements)));
			}else if(type.equals("csv")){
				claim = "\"" + claim.replaceAll("\\|", "\",\"") + "\"\n";
				claimString += claim;
			}
		}

		try {
			MediaType mediaType = MediaType.APPLICATION_JSON_TYPE;
			String valueAsString = "";
			if(type.equals("text")){
				valueAsString = mapper.writeValueAsString(claimsReportElementList);
			}else if(type.equals("csv")){
				valueAsString = claimString;
				mediaType = MediaType.TEXT_PLAIN_TYPE;
			}
			
			return Response.status(Response.Status.OK).entity(valueAsString).type(mediaType).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity("Failed to parse input").type(MediaType.TEXT_HTML_TYPE).build();
		}
	}

	@GET
	@Path("/locations/{library}")
	@Produces("application/json; charset=UTF-8")
	public Response getLocations(@PathParam("library") String library){

		ObjectMapper mapper = new ObjectMapper();

		List<Location> locationList = OverdueService.Factory.instance().retrieveLocations(library);

		try {
			return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(locationList)).type(MediaType.APPLICATION_JSON_TYPE).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity("Failed to parse input").type(MediaType.TEXT_HTML_TYPE).build();
		}
	}

	@GET
	@Path("/send/{type}/{library}/{location}")
	@Produces("application/json; charset=UTF-8")
	public Response sendEmail(@PathParam("library") String library,
			@PathParam("location") String location,
			@PathParam("type") String type,
			@QueryParam("email") String email){

		OverdueStatus statusType = OverdueStatus.findStatusByText(type); 

		log.debug("Send email:");
		log.debug("email = " + email);
		log.debug("library = " + library + ", location = " + location + ", type = " + type);

		List<String> barcodeList = new ArrayList<>();
		log.debug(statusType.name());
		switch(statusType){
		case FIRST_NOTICE:
			barcodeList = OverdueService.Factory.instance().sendFirstNotice(library, location, email);
			break;
		case SECOND_NOTICE:
			barcodeList = OverdueService.Factory.instance().sendSecondNotice(library, location, email);
			break;
		case THIRD_NOTICE:
			barcodeList = OverdueService.Factory.instance().sendThirdNotice(library, location, email);
			break;
		case CLAIMS:
			barcodeList = OverdueService.Factory.instance().sendClaims(library, location, email);
			break;
		case NOT_OVERDUE:
			break;
		default:
			break;
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(barcodeList)).type(MediaType.APPLICATION_JSON_TYPE).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity("Failed to parse input").type(MediaType.TEXT_HTML_TYPE).build();
		}
	}

	@GET
	@Path("/status/{library}")
	@Produces("text/plain; charset=UTF-8")
	public Response status(@PathParam("library") String library){
		
		StringBuilder status = new StringBuilder("Status for " + library + "\n");
		status.append("Items in buffer: " + OverdueService.Factory.instance().allItems(library).size()+ "\n");
		status.append("Partners in buffer: " + OverdueService.Factory.instance().allPartners(library).size() + "\n");
		status.append("\n\n");
		status.append(OverdueService.Factory.instance().emailTexts());
		status.append("\n\n");
		status.append(OverdueService.Factory.instance().pdfTexts());
		
		return Response.status(Response.Status.OK).entity(status.toString()).type(MediaType.TEXT_PLAIN_TYPE).build();
		
	}

	@GET
	@Path("/csvreport/{library}/{location}")
	@Produces("text/plain; charset=UTF-8")
	public Response csvReport(@PathParam("library") String library, 
			@PathParam("location") String location){
		
		String csvReport = OverdueService.Factory.instance().csvReport(library, location);
		
		return Response.status(Response.Status.OK).entity(csvReport).type(MediaType.TEXT_PLAIN_TYPE).build();
	}
	
	@GET
	@Path("/reset/{library}/{location}")
	@Produces("text/plain; charset=UTF-8")
	public Response resetNotes(@PathParam("library") String library, 
			@PathParam("location") String location){

				OverdueService.Factory.instance().resetNotes(library, location);
				String reset = "Fulfilmentnotes reset"; 
		
		return Response.status(Response.Status.OK).entity(reset).type(MediaType.TEXT_PLAIN_TYPE).build();
		
	}
	
	@GET
	@Path("/pdf/{library}/{lendingLocation}/{barcode}")
	@Produces("application/pdf; charset=UTF-8")
	public Response createPdf(@PathParam("library") String library,
	        @PathParam("lendingLocation") String lendingLocation,
	        @PathParam("barcode") String barcode){
	    
	    java.nio.file.Path pdfFile = OverdueService.Factory.instance().createPdf(library, lendingLocation, barcode);
	    
	    if(pdfFile == null){
	        return Response.status(Response.Status.NOT_FOUND).entity("Could not fint overdue request for barcode = " + barcode).type(MediaType.TEXT_HTML_TYPE).build();
	    }
	    try {
            return Response.status(Response.Status.OK)
                    .entity(Files.newInputStream(pdfFile)).type("application/pdf")
                    .header("Content-Disposition", "filename=" + pdfFile.getFileName())
                    .build();
        } catch (IOException e) {
            log.error("");
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity("Error creating pdf").type(MediaType.TEXT_HTML_TYPE).build();
        }
	}
}
