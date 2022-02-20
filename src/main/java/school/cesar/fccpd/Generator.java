package school.cesar.fccpd;

import java.util.Random;

public class Generator {

	int number;
	private static Random getRandom = new Random();

	public Generator() {
		number = getNumber();
	}

	public int getNumber() {
		number = getRandom.nextInt();
		return number;
	}
}
