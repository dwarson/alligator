package com.obselete;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

    public static void main(String[] args) throws Exception {

        String webappDirLocation = "src/main/webapp";
        Server server = new Server(8081);

        WebAppContext context = new WebAppContext();
        context.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        context.setResourceBase(webappDirLocation);
        context.setContextPath("/");
        context.setParentLoaderPriority(true);

        server.setHandler(context);

        server.start();
        server.join();

    }
}
