package zad_1;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Random r = new Random();
		int a = r.nextInt(101);
		// System.out.println(a);
		System.out.println("Witaj w grze. Zgadnij liczbę z zakresu 0 - 100");
//		System.out.println("Podaj swoją liczbę: ");
		Scanner scan = new Scanner(System.in);
		boolean e = true;
		while (e == true) {
			System.out.println("Podaj liczbę: ");
			String str = scan.nextLine();
			boolean isNmb = isNumeric(str);
			// System.out.println(isNmb);
			if (isNmb == true) {
				int d = Integer.parseInt(str);
				if (d == a) {
					e = false;
				} else {
					if (d > a) {
						System.out.println("Za duża");
					} else {
						System.out.println("Za mała");
					}
					e = true;
				}
			} else {
				System.out.println("To nie jest liczba, wprowadz ponownie");
				e = true;
			}
		}
		System.out.println("Zgadłeś !");

	}

	public static boolean isNumeric(String str) {
		try {
			int d = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
