package eu.timebreaker.lize.crackme.check.impl.basic;

import eu.timebreaker.lize.crackme.check.Check;
import eu.timebreaker.lize.crackme.check.CheckType;
import eu.timebreaker.lize.crackme.check.ICheck;
import eu.timebreaker.lize.crackme.util.Logger;


/*
	Check if the key is corresponding to a string

	Check key: yeswowgame1743??1
 */
@ICheck(type = CheckType.PLAIN_STRING)
public class PlainStringCheck extends Check {

	private final String key = "yeswowgame1743??1";

	@Override
	public boolean execute(String attemptedKey, Logger logger) {
		return attemptedKey.equals(key);
	}
}
