package zad_3;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		System.out.println("Pomyśl liczbę od 1 do 1000, a ja ją zgadnę w max 10 próbach");
		int min = 1;
		int max = 1000;
		int n = 0;
		int number = readNumber();
		int guess = 0;
		boolean e = true;
		while (e == true) {
			guess = ((max - min) / 2) + min;
			n++;
			System.out.println("Zgaduję " + guess);
			if (guess == number) {
				System.out.println("Wygrałem !");
				e = false;
			} else if (guess > number) {
				System.out.println("Za dużo !");
				max = guess;
				e = true;
			} else if (guess < number) {
				System.out.println("Za mało !");
				min = guess;
				e = true;
			} else {
				System.out.println("Nie oszukuj !");
				e = true;
			}

		}
		System.out.println("Zgadłem w " + n + " krokach");

	}

	public static boolean isNumericAndInRange(String str) {
		try {
			int d = Integer.parseInt(str);
			if ((d >= 0) && (d <= 1000)) {
				return true;
			} else {
				return false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static int readNumber() {
		Scanner scan = new Scanner(System.in);
		String number = scan.next();
		while (!isNumericAndInRange(number)) {
			System.out.println("Zła wartość, prowadź ponownie");
			number = scan.next();
		}
		scan.close();
		return Integer.parseInt(number);
	}

}
