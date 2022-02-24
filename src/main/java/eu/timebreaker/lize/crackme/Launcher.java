package eu.timebreaker.lize.crackme;

import eu.timebreaker.lize.crackme.configuration.Configuration;
import eu.timebreaker.lize.crackme.util.Constants;
import eu.timebreaker.lize.crackme.util.Logger;

import java.io.File;
import java.io.IOException;

public class Launcher {

	private static Logger logger = new Logger("Main");

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		logger.log(Logger.LogType.INFORMATION, "Starting %s %s...", Constants.NAME.toString(), Constants.VERSION.toString());

		Configuration configuration = null;
		try {
			configuration = Configuration.parseConfiguration(new File("crackme-config.yaml"));
			logger.log(Logger.LogType.DEBUG, "Configuration file found.");
		} catch (IOException exception) {
			logger.log(Logger.LogType.ERROR, "Configuration file 'crackme-config.yaml' not found or corrupted, exiting.", Constants.NAME.toString());
			System.exit(-69);
		}
		new Crackme(logger, configuration, startTime).run();
	}
}
