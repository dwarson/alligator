package com.june;

import org.eclipse.jetty.server.Server;

public class QuickStartServer {

	public static final int PORT = 8081;
	public static final String CONTEXT = "/alligator";
	public static final String[] TLD_JAR_NAMES = new String[] { "spring-webmvc" };

	public static void main(String[] args) throws Exception {
		Profiles.setProfileAsSystemProperty(Profiles.DEVELOPMENT);

		Server server = JettyFactory.createServerInSource(PORT, CONTEXT);
		JettyFactory.setTldJarNames(server, TLD_JAR_NAMES);
		try {
			server.start();

			System.out.println("[INFO] Server running at http://localhost:"
					+ PORT + CONTEXT);
			System.out
					.println("[HINT] Hit Enter to reload the application quickly");

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
