package eu.timebreaker.lize.crackme.check;

import eu.timebreaker.lize.crackme.check.impl.basic.PastebinCheck;
import eu.timebreaker.lize.crackme.check.impl.basic.PlainStringCheck;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class CheckManager {
	
	private final List<Check> checkList;
	
	public CheckManager() {
		checkList = new ArrayList<>();

		addCheck(
				new PlainStringCheck(),
				new PastebinCheck()
		);
	}

	void addCheck(Check... checks) {
		checkList.addAll(Arrays.asList(checks));
	}
	
	public Check getCheck(CheckType checkType) {
		return checkList.stream().filter(module -> module.getType().equals(checkType)).findFirst().orElse(null);
	}
}
