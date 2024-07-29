package Test;

public class RandomString {
	static String getAlphaNumericString(int n) {
		String AlphaNumericString = "0123456789";
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		int n = 6;
		System.out.println(RandomString.getAlphaNumericString(n));
	}

}
