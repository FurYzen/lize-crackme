package eu.timebreaker.lize.crackme.check;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ICheck {

	CheckType type();

	String description() default "default description, if you see this please report to FurYzen#0001.";
}
