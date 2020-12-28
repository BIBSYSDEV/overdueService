package no.bibsys.overdueNotices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/report")
public class ReportServlet extends HttpServlet {

	private static final long serialVersionUID = -371064655335611126L;
	private static final String HTML_HEADER = "<!DOCTYPE html>\n"
			+ "<html>\n"
			+ "<head>\n"
			//			+ "<meta charset=\"utf-8\">\n"
			+ "<script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js\"></script>\n"
			+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\n"
			+ "<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\n"
			+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js\"></script>"
			+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
			+ "<script src=\"lib/overdue.js\"></script>\n"
			+ "<link rel=\"stylesheet\" href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css\">"
			+ "<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">"
			+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/report.css\">\n"
			+ "</head>\n"
			+ "<body>\n";
	private static final String HTML_FOOTER = "</body>\n</html>\n";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StringBuilder htmlString = new StringBuilder();
		htmlString.append(HTML_HEADER);

		String libraryString = request.getParameter("library");
		if(libraryString == null||libraryString.isEmpty()){
			libraryString ="NB";
		}

		htmlString.append("<div class=\"container-fluid\">\n");
		htmlString.append("<ul class=\"nav navbar-nav\">\n");
		htmlString.append("<li class=\"active\"><a data-toggle=\"tab\" href=\"#report\">Purringer</a></li>\n");
		htmlString.append("<li><a data-toggle=\"tab\" href=\"#scheduler\">Oppsett</a></li>\n");
		htmlString.append("</ul>\n");
		htmlString.append("</div>\n");

		htmlString.append("<div class=\"tab-content\">\n");
		htmlString = createReportHtml(htmlString);
		htmlString = createLocationForm(htmlString);
		htmlString.append("</div>\n");

		response.getWriter().append(htmlString.toString());
	}

	private StringBuilder createLocationForm(StringBuilder htmlString) {

		htmlString.append("<div id=\"scheduler\" class=\"tab-pane fade\">\n");
		htmlString.append("<div class=\"panel panel-default\">\n");
		htmlString.append("<div class=\"panel-body\">\n");
		htmlString.append("<table class=\"table\">\n");
		htmlString.append("<thead><tr><th>Avdeling</th></tr></thead>\n");
		htmlString.append("<tr><td>Depotbiblioteket</td></th>\n");
		htmlString.append("<tr><td>Finsetvn. 2</td></th>\n");
		htmlString.append("<tr><td>8624 Mo i Rana</td></th>\n");
		htmlString.append("<tr><td>Tlf.: 75121282 </td></th>\n");
		htmlString.append("<tr><td>Epost: depot-fjernlaan@nb.no</td></th>\n");
		htmlString.append("</table>\n");
		htmlString.append("<table class=\"table\">\n");
		htmlString.append("<thead><tr><th>Avdeling</th></tr></thead>\n");
		htmlString.append("<tr><td>Besøkstjenesten</td></th>\n");
		htmlString.append("<tr><td>Finsetvn. 2</td></th>\n");
		htmlString.append("<tr><td>8624 Mo i Rana</td></th>\n");
		htmlString.append("<tr><td>Tlf.: 75121282 </td></th>\n");
		htmlString.append("<tr><td>Epost: depot-fjernlaan@nb.no</td></th>\n");
		htmlString.append("</table>\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");

		htmlString.append("<div class=\"panel panel-default\">\n");
		htmlString.append("<div class=\"panel-body\">\n");
		htmlString.append("<form class=\"form-horizontal\" role=\"form\">\n");
		htmlString.append("<div class=\"form-group\">\n");
		htmlString.append("<label for=\"location\" class=\"col-sm-2 control-label\">Avdeling:</label>\n");
		htmlString.append("<div class=\"col-sm-10\">\n");
		htmlString.append("<input type='text' class=\"form-control\" id='location'/>\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");
		htmlString.append("<div class=\"form-group\">\n");
		htmlString.append("<label for=\"address\" class=\"col-sm-2 control-label\">Adresse:</label>\n");
		htmlString.append("<div class=\"col-sm-10\">\n");
		htmlString.append("<input type='text' class=\"form-control\" id='address'/>\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");
		htmlString.append("<div class=\"form-group\">\n");
		htmlString.append("<label for=\"postalnr\" class=\"col-sm-2 control-label\">Postnr:</label>\n");
		htmlString.append("<div class=\"col-sm-10\">\n");
		htmlString.append("<input type='text' class=\"form-control\" id='postalnr'/>\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");
		htmlString.append("<div class=\"form-group\">\n");
		htmlString.append("<label for=\"city\" class=\"col-sm-2 control-label\">Poststed:</label>\n");
		htmlString.append("<div class=\"col-sm-10\">\n");
		htmlString.append("<input type='text' class=\"form-control\" id='city'/>\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");
		htmlString.append("<div class=\"form-group\">\n");
		htmlString.append("<label for=\"email\" class=\"col-sm-2 control-label\">Email:</label>\n");
		htmlString.append("<div class=\"col-sm-10\">\n");
		htmlString.append("<input type=\"email\" class=\"form-control\" id=\"email\">\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");
		htmlString.append("<div class=\"form-group\">\n");
		htmlString.append("<label for=\"phone\" class=\"col-sm-2 control-label\">Telefon:</label>\n");
		htmlString.append("<div class=\"col-sm-10\">\n");
		htmlString.append("<input type=\"text\" class=\"form-control\" id=\"phone\">\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");
		htmlString.append("<button type=\"submit\" class=\"btn btn-default\">Lagre</button>\n");
		htmlString.append("</form>\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");

		return htmlString;
	}

	private StringBuilder createReportHtml(StringBuilder htmlString) {
		htmlString.append("<div id=\"report\" class=\"tab-pane fade in active\">");
		htmlString.append("<div class=\"panel panel-default\">\n");
		htmlString.append("<div class=\"panel-body\">\n");

		htmlString.append("<table style=\"border-spacing: 0;\">\n");

		htmlString.append("<tr><td class=\"first_notice\" style=\"width: 1em;\"></td><td>- 1. gangs purring</td></tr>\n");
		htmlString.append("<tr><td class=\"second_notice\" style=\"width: 1em;\"></td><td>- 2. gangs purring</td></tr>\n");
		htmlString.append("<tr><td class=\"third_notice\" style=\"width: 1em;\"></td><td>- 3. gangs purring</td></tr>\n");
		htmlString.append("<tr><td class=\"claims\" style=\"width: 1em;\"></td><td>- erstatningskrav</td></tr>\n");
		htmlString.append("</table>\n");

		htmlString.append("<table id=\"overdue_table\" class=\"table\">\n<tbody id=\"overdue_table_body\">\n");
		htmlString.append("<tr id=\"overdue_table_header\"><th class=\"col-sm-7\">Tittel</th><th class=\"col-sm-1\">dato</th class=\"col-sm-1\"></th><th><th class=\"col-sm-2\">barcode</th><th class=\"col-sm-8\">email</th></tr>");

		htmlString.append("</tbody>\n</table>\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");
		htmlString.append("</div>\n");

		htmlString.append(HTML_FOOTER);

		return htmlString;
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
