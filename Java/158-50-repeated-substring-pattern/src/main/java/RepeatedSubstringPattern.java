
public class RepeatedSubstringPattern {

	public static boolean repeatedSubstringPattern(String str) {
		for (int i = 1; i < str.length(); i++) {
			if (str.length() % i != 0) {
				continue;
			}
			if (checkStr(i, str)) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkStr(int length, String str) {
		String init = str.substring(0, length);
		for (int i = 0; i < str.length(); i += length) {
			String cmpString = str.substring(i, i + length);
			if (cmpString.equals(init) == false) {
				return false;
			}
		}
		return true;
	}
}