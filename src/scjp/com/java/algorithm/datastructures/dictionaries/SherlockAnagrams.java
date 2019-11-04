package scjp.com.java.algorithm.datastructures.dictionaries;

import java.util.HashSet;
import java.util.Set;

import scjp.com.java.algorithm.ConsoleReader;

public class SherlockAnagrams {
	public static void main(String[] args) {
		try (ConsoleReader reader = new ConsoleReader()) {
			final int noOfInputs = reader.readInt();
			String[] inputs = new String[noOfInputs];
			for (int i = 0; i < noOfInputs; i++) {
				inputs[i] = reader.readLine();
			}

			for (String input : inputs) {
				int result = getNoOfPossibleAnagrams(input);
				System.out.println(result);
			}
		}
	}

	private static int getNoOfPossibleAnagrams(String readLine) {
		int result = 0;
		char[] charArr = readLine.toCharArray();
		Set<String> uniqueSubStrings = new HashSet<>();
		for (int i = 0; i < charArr.length; i++) {
			if (!uniqueSubStrings.add(Character.toString(charArr[i]))) {
				result++;
			}

			for (int j = i + 1; j < charArr.length; j++) {
				char[] destArr = new char[j - i + 1];
				System.arraycopy(charArr, i, destArr, 0, j - i + 1);
				String uniqueSubString = String.copyValueOf(destArr);
				if (uniqueSubStrings.contains(new StringBuilder(uniqueSubString).reverse().toString())) {
					result++;
				} else {
					uniqueSubStrings.add(uniqueSubString);
				}
			}
		}

		return result;
	}
}
