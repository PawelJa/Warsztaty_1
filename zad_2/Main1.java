package zad_2;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		System.out.println("Podaj swoje liczby: ");
		Scanner scan = new Scanner(System.in);
		boolean e = true;
		int[] tabUser = getNumbersFromUser();
		System.out.println(Arrays.toString(tabUser));
		int[] tabRandom = getRandomNumbers();

	}
	public static int[] getRandomNumbers() {
		Random rand = new Random
	}

	public static int[] getNumbersFromUser() {
		int[] tabUser = new int[6];
		for (int k = 0; k < 6; k++) {
			int number = getUniqueNumberInRange(tabUser);
			tabUser[k] = number;
		}
		return tabUser;
	}

	public static boolean isNumeric(String str) {
		try {
			int d = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static int getUniqueNumberInRange(int[] tabUser) {
		int number = readNumber();
		if ((number > 0) && (number < 50) && !contains(tabUser, number)) {
			return number;
		} else {
			System.out.println("Zła liczba");
			return getUniqueNumberInRange(tabUser);
		}
	}

	private static boolean contains(int[] tabUser, int number) {
		for (int i : tabUser) {
			if (i == number) {
				return true;
			}
		}
		return false;
	}

	public static int readNumber() {
		Scanner scan = new Scanner(System.in);
		String number = scan.next();
		while (!isNumeric(number)) {
			System.out.println("To nie jest liczba, wprowadz ponownie");
			number = scan.next();
		}
		return Integer.parseInt(number);
	}
}
