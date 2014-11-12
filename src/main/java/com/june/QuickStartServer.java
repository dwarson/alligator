/*******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.june;

import org.eclipse.jetty.server.Server;

public class QuickStartServer {

    public static final int PORT = 8081;
    public static final String CONTEXT = "/";

    public static void main(String[] args) throws Exception {
        Server server = JettyFactory.createServerInSource(PORT, CONTEXT);
        try {
            server.start();

            System.out.println("[INFO] Server running at http://localhost:" + PORT + CONTEXT);
            System.out.println("[HINT] Hit Enter to reload the application quickly");

            while (true) {
                char c = (char) System.in.read();
                if (c == '\n') {
                    JettyFactory.reloadContext(server);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
