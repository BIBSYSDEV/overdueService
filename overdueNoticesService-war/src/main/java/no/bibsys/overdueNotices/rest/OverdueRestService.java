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
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import no.bibsys.overdueNotices.AnalyticsService;
import no.bibsys.overdueNotices.Location;
import no.bibsys.overdueNotices.OverdueNotice;
import no.bibsys.overdueNotices.OverdueNotice.OverdueStatus;
import no.bibsys.overdueNotices.OverdueService;




@Path("/data")
@Api(value = "/data", description = "Overdue data service")
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
	@ApiOperation(
			position=0, 
			value = "Retrieve presentation of an overdue notice")
	@ApiResponses( {
		@ApiResponse( code = 200, message = "Success" ),
	} )
	@Produces("application/json; charset=UTF-8")
	public Response getOverdueNoticePresentation(@ApiParam(value = "library", required = true) @PathParam("library") String library, @ApiParam(value = "barcode", required = true) @PathParam("barcode") String barcode){


		OverdueNotice overdueNotice = AnalyticsService.Factory.instance(institutionServiceHost).getOverdueNotice(barcode, library);

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
	@ApiOperation(
			position=0, 
			value = "Retrieve overdue notices from location")
	@ApiResponses( {
		@ApiResponse( code = 200, message = "Success" ),
	} )
	@Produces("application/json; charset=UTF-8")
	public Response getReport(@ApiParam(value = "library", required = true) @PathParam("library") String library, @ApiParam(value = "location", required = true) @PathParam("location") String location){

		ObjectMapper mapper = new ObjectMapper();
		
		List<OverdueNotice> analyticsReport = AnalyticsService.Factory.instance(institutionServiceHost).getAnalyticsReport(library);
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
	@ApiOperation(
			position=0, 
			value = "Returned items with claims")
	@ApiResponses( {
		@ApiResponse( code = 200, message = "Success" ),
	} )
	@Produces("application/json; charset=UTF-8")
	public Response getReturnedClaimsReport(@ApiParam(value = "library", required = true) @PathParam("library") String library,
			@ApiParam(value = "type", required = true) @PathParam("type") String type){

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
	@ApiOperation(
			position=0, 
			value = "Retrieve locations from library")
	@ApiResponses( {
		@ApiResponse( code = 200, message = "Success" ),
	} )
	@Produces("application/json; charset=UTF-8")
	public Response getLocations(@ApiParam(value = "library", required = true) @PathParam("library") String library){

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
	@ApiOperation(
			position=0, 
			value = "Send notice by email")
	@ApiResponses( {
		@ApiResponse( code = 200, message = "Success" ),
	})
	@Produces("application/json; charset=UTF-8")
	public Response sendEmail(@ApiParam(value = "library", required = true) @PathParam("library") String library,
			@ApiParam(value = "location", required = true) @PathParam("location") String location,
			@ApiParam(value = "type", required = true, allowableValues = "NOT_OVERDUE,FIRST_NOTICE,SECOND_NOTICE,THIRD_NOTICE,CLAIMS") @PathParam("type") String type,
			@ApiParam(value = "email", required = true) @QueryParam("email") String email){

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
	@ApiOperation(
			position=0, 
			value = "Retrieve status from library")
	@ApiResponses( {
		@ApiResponse( code = 200, message = "Success" ),
	})
	@Produces("text/plain; charset=UTF-8")
	public Response status(@ApiParam(value = "library", required = true) @PathParam("library") String library){
		
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
	@ApiOperation(
			position=0, 
			value = "Retrieve report as csv from library")
	@ApiResponses( {
		@ApiResponse( code = 200, message = "Success" ),
	})
	@Produces("text/plain; charset=UTF-8")
	public Response csvReport(@ApiParam(value = "library", required = true) @PathParam("library") String library, 
			@ApiParam(value = "location", required = true) @PathParam("location") String location){
		
		String csvReport = OverdueService.Factory.instance().csvReport(library, location);
		
		return Response.status(Response.Status.OK).entity(csvReport).type(MediaType.TEXT_PLAIN_TYPE).build();
	}
	
	@GET
	@Path("/reset/{library}/{location}")
	@ApiOperation(
			position=0, 
			value = "Reset fulfilment notes on items from location")
	@ApiResponses( {
		@ApiResponse( code = 200, message = "Success" ),
	})
	@Produces("text/plain; charset=UTF-8")
	public Response resetNotes(@ApiParam(value = "library", required = true) @PathParam("library") String library, 
			@ApiParam(value = "location", required = true) @PathParam("location") String location){

				OverdueService.Factory.instance().resetNotes(library, location);
				String reset = "Fulfilmentnotes reset"; 
		
		return Response.status(Response.Status.OK).entity(reset).type(MediaType.TEXT_PLAIN_TYPE).build();
		
	}
	
	@GET
	@Path("/pdf/{library}/{lendingLocation}/{barcode}")
	@ApiOperation(
	        position=0, 
	        value = "Reset fulfilment notes on items from location")
	@ApiResponses( {
	    @ApiResponse( code = 200, message = "Success" ),
	})
	@Produces("application/pdf; charset=UTF-8")
	public Response createPdf(@ApiParam(value = "library", required = true) @PathParam("library") String library,
	        @ApiParam(value = "lendingLocation", required = true) @PathParam("lendingLocation") String lendingLocation,
	        @ApiParam(value = "barcode", required = true) @PathParam("barcode") String barcode){
	    
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
