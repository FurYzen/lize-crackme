package eu.timebreaker.lize.crackme;

import eu.timebreaker.lize.crackme.check.Check;
import eu.timebreaker.lize.crackme.check.CheckManager;
import eu.timebreaker.lize.crackme.configuration.Configuration;
import eu.timebreaker.lize.crackme.util.Constants;
import eu.timebreaker.lize.crackme.util.Logger;
import lombok.Getter;

import java.util.Scanner;

@Getter
public class Crackme {

    private static Crackme instance;

    private final Logger logger;
    private final Configuration configuration;

    private CheckManager checkManager;

    private long startTime;

    public Crackme(Logger logger, Configuration configuration, long startTime) {
        this.logger = logger.setProgram("Crackme");
        this.configuration = configuration;

        this.startTime = startTime;

        this.checkManager = new CheckManager();
    }

    void run() {
        instance = this;
        logger.log(Logger.LogType.INFORMATION, "Welcome to the %s, an overly complicated crackme to test my obfuscator !", Constants.NAME.toString());

        logger.setDebugMode(configuration.isDebugMode());

        Check check = checkManager.getCheck(configuration.getCheckType());

        if(check == null) {
            logger.log(Logger.LogType.ERROR, "Check not found, stopping.");
            System.exit(69);
        }

        logger.log(Logger.LogType.INFORMATION, "Current check: %s", check.getType().name());

        logger.log(Logger.LogType.INFORMATION, "Please enter the key:");
        Scanner scanner = new Scanner(System.in);

        String attemptedKey = scanner.nextLine();
        logger.log(Logger.LogType.DEBUG, "Key entered: %s", attemptedKey);

        if(check.execute(attemptedKey, logger)) {
            logger.log(Logger.LogType.INFORMATION, "Good job, you successfully found the %s check key !", check.getType().name());
        } else {
            logger.log(Logger.LogType.INFORMATION, "Incorrect key.");
        }

        logger.log(Logger.LogType.DEBUG, "Program executed in %dms.", (System.currentTimeMillis() - startTime));
    }

    public static Crackme getInstance() {
        return instance;
    }
}
