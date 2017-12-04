package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		System.out.println("Podaj swoje liczby: ");
		// Scanner scan = new Scanner(System.in);
		// boolean e = true;
		int[] arrUser = getNumbersFromUser();
//		System.out.println(Arrays.toString(arrUser));
		Integer[] arrRandom = getRandomNumbers();
//		System.out.println(Arrays.toString(arrRandom));
		Integer result = checkResult(arrUser, arrRandom);
		if (result >= 3) {
			System.out.println("Trafiłeś co najmniej trójkę !");
		} else {
			System.out.println("Nie trafiłeś nawet trójki");
		}

	}

	public static Integer[] getRandomNumbers() {
		Integer[] arrRand = new Integer[49];
		for (int i = 0; i < arrRand.length; i++) {
			arrRand[i] = i+1;
		}
//		System.out.println(Arrays.toString(arrRand));
		Collections.shuffle(Arrays.asList(arrRand));
//		System.out.println(Arrays.toString(arrRand));
		Integer[] newArrRandom = new Integer[6];
		for (int i = 0; i < newArrRandom.length; i++) {
			newArrRandom[i] = arrRand[i + 3];
		}
		return newArrRandom;
	}

	public static Integer checkResult(int[] arrU, Integer[] arrR) {
		int count = 0;
		for (int i = 0; i < arrU.length; i++) {
			if (Arrays.asList(arrR).contains(arrU[i])) {
				count++;
			}
		}
		return count;
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
