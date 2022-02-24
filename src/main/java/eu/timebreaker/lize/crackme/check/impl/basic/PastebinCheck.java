package eu.timebreaker.lize.crackme.check.impl.basic;

import eu.timebreaker.lize.crackme.check.Check;
import eu.timebreaker.lize.crackme.check.CheckType;
import eu.timebreaker.lize.crackme.check.ICheck;
import eu.timebreaker.lize.crackme.util.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;


/*
	Check is the key is corresponding to a string from a pastebin link

	Check key: opensoftwater425<>
 */
@ICheck(type = CheckType.PASTEBIN)
public class PastebinCheck extends Check {

	@Override
	public boolean execute(String attemptedKey, Logger logger) {
		String key = null;
		
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL("https://pastebin.com/raw/fhnb18bt").openConnection();

			key = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
		} catch (Exception exception) {
			logger.log(Logger.LogType.ERROR, "An error occurred trying to check the key (%s)", getType().name());
			exception.printStackTrace();
		}
		return attemptedKey.equals(key);
	}
}
