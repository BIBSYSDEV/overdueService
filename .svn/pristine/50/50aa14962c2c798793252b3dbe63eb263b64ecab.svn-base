<%-- 
    Document   : monitor
    Created on : Oct 6, 2014, 1:09:41 PM
    Author     : tl


<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="no.bibsys.authority.datalayer.AuthorityConnectionManagerSQL"%>
<%@page import="no.bibsys.authority.datalayer.AppConfig"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.solr.client.solrj.SolrServerException"%>
<%@page import="org.apache.solr.client.solrj.impl.HttpSolrServer"%>
<%@page import="org.apache.solr.client.solrj.response.SolrPingResponse"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="no.bibsys.authority.rest.exception.RestException"%>
<%@page import="no.bibsys.authority.monitor.MonitorUtil"%>
<%@page import="no.bibsys.authority.rest.AuthorityFunctionsRest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
    String contextPath = request.getContextPath();
    AuthorityFunctionsRest authorityRest = new AuthorityFunctionsRest();
    
    SolrPingResponse solrPong = null;
    Throwable solrPingThrowable = null;
    boolean solrPingSuccess = false;
    
    long mysqlPingMillis = -1;
    Throwable mysqlPingThrowable = null;
    boolean mysqlPingSuccess = false;
    
    String identifiersJson = null;
    Throwable identifiersThrowable = null;
    boolean identifiersSuccess = false;
    
    String fieldsJson = null;
    Throwable fieldsThrowable = null;//new RuntimeException("test");
    boolean fieldsSuccess = false;
    
    String queryJson = null;
    Throwable queryThrowable = null;
    boolean querySuccess = false;
    
    String okBgColor = "B6ffB6";
    String failBgColor = "ff9999";
    
    try {
        solrPong = new HttpSolrServer(AppConfig.SOLR_URL).ping();
        if(solrPong.getStatus() == 0) {
            solrPingSuccess = true;
        }
    } catch(SolrServerException e) {
        solrPingThrowable = e;
    } catch(IOException e) { 
        solrPingThrowable = e;
    } catch(RuntimeException e) {
        solrPingThrowable = e;
    }
    
    try {
        Connection conn = AuthorityConnectionManagerSQL.getConnection();
        long start = System.currentTimeMillis();
        mysqlPingSuccess = AuthorityConnectionManagerSQL.checkConnection(conn);
        mysqlPingMillis = System.currentTimeMillis() - start;
    } catch(SQLException e) {
        mysqlPingThrowable = e;
    } catch(RuntimeException e) {
        mysqlPingThrowable = e;
    }
    
    try {
        identifiersJson = authorityRest.identifiers();
        if(identifiersJson.contains("Orcid")) {
            identifiersSuccess = true;
        }
    } catch(RestException e) {
        identifiersThrowable = e;
    } catch(RuntimeException e) {
        identifiersThrowable = e;
    }
    
    try {
        fieldsJson = authorityRest.fields();
        if(fieldsJson.contains("authoritytype")) {
            fieldsSuccess = true;
        }
    } catch(RestException e) {
        fieldsThrowable = e;
    } catch(RuntimeException e) {
        fieldsThrowable = e;
    }
    
    try {
        queryJson = (String)authorityRest.queryAuthority("name:ibsen", "1", "1", null).getEntity();
        if(queryJson.contains("Ibsen")) {
            querySuccess = true;
        }
    } catch(RestException e) {
        queryThrowable = e;
    } catch(RuntimeException e) {
        queryThrowable = e;
    }
    
    if(!solrPingSuccess || !mysqlPingSuccess || !identifiersSuccess || !fieldsSuccess || !querySuccess) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
    
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Monitor Page</title>

        <link href='<%=contextPath+"/"%>css/monitor-reset.css' media='screen' rel='stylesheet' type='text/css'/>
        <link href='<%=contextPath+"/"%>css/monitor-screen.css' media='screen' rel='stylesheet' type='text/css'/>
    </head>
    <body class="swagger-section">
        <div id="message-bar" class="swagger-ui-wrap message-success"><h2>Status for <%=contextPath%></h2></div>
        <div id="swagger-ui-container" class="swagger-ui-wrap">
            <div id="resources_container" class="container">
                <ul id="resources">
                    <li id="resource_authority" class="resource">
                        <ul class="endpoints" id="authority_endpoint_list" style="">

                            <li class="endpoint">
                              <ul class="operations">
                                <li class="get operation" id="authority_fields">

                                    <div class="heading" style="background-color: #<%= (solrPingSuccess?okBgColor:failBgColor) %>">
                                        <h3>
                                            <span class="path">
                                                SOLR Connection
                                            </span>
                                        </h3>
                                        <ul class="options">
                                            <li>
                                                <%= (solrPingSuccess?"OK":"FAIL") %>
                                            </li>
                                        </ul>
                                    
                                    </div>
                                    <div class="content">

<% if(solrPingThrowable==null) { %>
<pre>Solr URL: <%= AppConfig.SOLR_URL %>
Status: <%= solrPong.getStatus() + " ("+(solrPong.getStatus()==0?"OK":"ERROR")+")" %>
ElapsedTime: <%= solrPong.getElapsedTime() + " ms" %>
QTime: <%= solrPong.getQTime() + " ms" %>
</pre>
<% } else { 
    out.println("<pre>");
    solrPingThrowable.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
} %>

                                    </div>
                                </li>
                                <li class="get operation" id="mysql_connection">

                                    <div class="heading" style="background-color: #<%= (mysqlPingSuccess?okBgColor:failBgColor) %>">
                                        <h3>
                                            <span class="path">
                                                MySQL Connection
                                            </span>
                                        </h3>
                                        <ul class="options">
                                            <li>
                                                <%= (mysqlPingSuccess?"OK":"FAIL") %>
                                            </li>
                                        </ul>
                                    
                                    </div>
                                    <div class="content">

<% if(mysqlPingThrowable==null) { %>
<pre>
Ping latency: <%= mysqlPingMillis + " ms" %>
</pre>
<% } else { 
    out.println("<pre>");
    mysqlPingThrowable.printStackTrace(new PrintWriter(out));
    out.println("</pre>");
} %>

                                    </div>
                                </li>
                                <li class="get operation" id="aut2">
                                    <div class="heading" style="background-color: #<%= (identifiersSuccess?okBgColor:failBgColor) %>">
                                        <h3>
                                            <span class="path">
                                                identifiers()
                                            </span>
                                        </h3>
                                        <ul class="options">
                                            <li>
                                                <%= (identifiersSuccess?"OK":"FAIL") %>
                                            </li>
                                        </ul>
                                    
                                    </div>
                                    <div class="content">
                                        <h4>Identifiers</h4>
                                        <div class="block response_code">
                                            <% if(identifiersThrowable==null) { %>
                                            <%= MonitorUtil.formatJsonForHtml(identifiersJson) %>
                                            <% } else { 
                                                out.println("<pre>");
                                                identifiersThrowable.printStackTrace(new PrintWriter(out));
                                                out.println("</pre>");
                                            } %>
                                        </div>
                                    </div>
                                </li>
                                <li class="get operation" id="aut2">
                                    <div class="heading" style="background-color: #<%= (fieldsSuccess?okBgColor:failBgColor) %>">
                                        <h3>
                                            <span class="path">
                                                fields()
                                            </span>
                                        </h3>
                                        <ul class="options">
                                            <li>
                                                <%= (fieldsSuccess?"OK":"FAIL") %>
                                            </li>
                                        </ul>
                                    
                                    </div>
                                    <div class="content">
                                        <h4>Fields</h4>
                                        <div class="block response_code">
                                            <% if(fieldsThrowable==null) { %>
                                            <%= MonitorUtil.formatJsonForHtml(fieldsJson) %>
                                            <% } else { 
                                                out.println("<pre>");
                                                fieldsThrowable.printStackTrace(new PrintWriter(out));
                                                out.println("</pre>");
                                            } %>
                                        </div>
                                    </div>
                                </li>
                                <li class="get operation" id="aut2">
                                    <div class="heading" style="background-color: #<%= (querySuccess?okBgColor:failBgColor) %>">
                                        <h3>
                                            <span class="path">
                                                query()
                                            </span>
                                        </h3>
                                        <ul class="options">
                                            <li>
                                                <%= (querySuccess?"OK":"FAIL") %>
                                            </li>
                                        </ul>
                                    
                                    </div>
                                    <div class="content">
                                        <h4>Query</h4>
                                        <div class="block response_code">
                                            <% if(queryThrowable==null) { %>
                                            <%= MonitorUtil.formatJsonForHtml(queryJson) %>
                                            <% } else {
                                                out.println("<pre>");
                                                queryThrowable.printStackTrace(new PrintWriter(out));
                                                out.println("</pre>");
                                            } %>
                                        </div>
                                    </div>
                                </li>
                              </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
      </div>
    </body>
</html>

--%>
