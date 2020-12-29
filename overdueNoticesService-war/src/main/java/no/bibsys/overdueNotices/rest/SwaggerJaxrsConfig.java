package no.bibsys.overdueNotices.rest;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.FilterFactory;
import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.config.SwaggerConfig;
import com.wordnik.swagger.jaxrs.config.DefaultJaxrsScanner;
import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
import com.wordnik.swagger.model.ApiKey;
import com.wordnik.swagger.reader.ClassReaders;

import no.bibsys.http.HttpUtil;
import no.bibsys.overdueNotices.HiddenParamFilter;

/**
 * 
 * A Filter that initializes Swagger on the first request, in
 * order to set the base path automatically
 * 
 * @author tl
 */
public class SwaggerJaxrsConfig implements Filter {
    
    private static final String https = "https://";
    private static final String http = "http://";

    private final AtomicBoolean initialized = new AtomicBoolean(false);

    private static final long serialVersionUID = -4172507378920810604L;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        
        
        //enable cross-origin resource sharing
        String hostAndPort = httpRequest.getServerName() + ":" + httpRequest.getServerPort();

//        Yes, you need to have the header Access-Control-Allow-Origin: http://domain.com:3000 or Access-Control-Allow-Origin: * on both the OPTIONS response and the POST response. You should include the header Access-Control-Allow-Credentials: true on the POST response as well.
//
//Your OPTIONS response should also include the header Access-Control-Allow-Headers: origin, content-type, accept to match the requested header.
        
        String origin = https+hostAndPort + " " + http + hostAndPort + " " + https+httpRequest.getServerName()+":443" + " " + http+httpRequest.getServerName()+":80";
//        httpResponse.addHeader("Access-Control-Allow-Origin", https+hostAndPort);
//        httpResponse.addHeader("Access-Control-Allow-Origin", http + hostAndPort);
//        httpResponse.addHeader("Access-Control-Allow-Origin", https+httpRequest.getServerName()+":443");
//        httpResponse.addHeader("Access-Control-Allow-Origin", http+httpRequest.getServerName()+":80");
//        httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:8080");
//        if("OPTIONS".equalsIgnoreCase(httpRequest.getMethod()) {
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpResponse.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        httpResponse.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//        httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
        //Access-Control-Max-Age: 1728000
        if (initialized.compareAndSet(false, true)) { //if not initialized
            String basePath = HttpUtil.getBasePath(httpRequest) + httpRequest.getContextPath() + "/rest";
            System.out.println("-------------------------------\nbasePath = " + basePath + "\n-------------------------------\n");
            
            if(!basePath.contains("localhost:") && !request.getServletContext().getServerInfo().toLowerCase().contains("jetty")) {
                basePath = basePath.replace("http://", "https://");
            }
            configSwagger(basePath);
        }

        HttpSession session = ((HttpServletRequest)request).getSession();
        chain.doFilter(request, response);
        

        
//        httpResponse.addHeader("Access-Control-Allow-Origin", origin);
//        httpResponse.addHeader("Access-Control-Allow-Origin", "*");

        if(session != null) {
//            session.invalidate();
        }
    }

    @Override
    public void destroy() {

    }

    private void configSwagger(String basePath) {
        SwaggerConfig swaggerConfig = new SwaggerConfig();

        ApiKey apikey = new ApiKey("apikey", "apikey");
        swaggerConfig.addAuthorization(apikey);
        FilterFactory.setFilter(new HiddenParamFilter());
        ConfigFactory.setConfig(swaggerConfig);
        swaggerConfig.setBasePath(basePath);
        swaggerConfig.setApiVersion("1.0.0");
        ScannerFactory.setScanner(new DefaultJaxrsScanner());
        ClassReaders.setReader(new DefaultJaxrsApiReader());
    }
}
