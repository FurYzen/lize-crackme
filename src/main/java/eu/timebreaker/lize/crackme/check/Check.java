package eu.timebreaker.lize.crackme.check;

import eu.timebreaker.lize.crackme.util.Logger;
import lombok.Getter;

@Getter
public abstract class Check {

	private final String description = getClass().getAnnotation(ICheck.class).description();
	private final CheckType type = getClass().getAnnotation(ICheck.class).type();

	public abstract boolean execute(String attemptedKey, Logger logger);
}
