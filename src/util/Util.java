package util;

public class Util {

	public static boolean isInteger(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
