/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.june;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyFactory {

    private static final String DEFAULT_WEBAPP_PATH = "src/main/webapp";

    /**
	 */
    public static Server createServerInSource(int port, String contextPath) {
        Server server = new Server();
        server.setStopAtShutdown(true);

        SelectChannelConnector connector = new SelectChannelConnector();
        connector.setPort(port);
        connector.setReuseAddress(false);
        server.setConnectors(new Connector[] { connector });

        WebAppContext webContext = new WebAppContext(DEFAULT_WEBAPP_PATH, contextPath);
        server.setHandler(webContext);

        return server;
    }

    public static void reloadContext(Server server) throws Exception {
        WebAppContext context = (WebAppContext) server.getHandler();

        System.out.println("[INFO] Application reloading");
        context.stop();

        WebAppClassLoader classLoader = new WebAppClassLoader(context);
        classLoader.addClassPath("target/classes");
        classLoader.addClassPath("target/test-classes");
        context.setClassLoader(classLoader);

        context.start();

        System.out.println("[INFO] Application reloaded");
    }
}
