package guessnumber2;

import java.util.Scanner;

public class GuessNumber2 {

	public static void main(String[] args) {
		System.out.println("Pomyśl liczbę od 1 do 1000, a ja ją zgadnę w max 10 próbach");
		int min = 1;
		int max = 1000;
		int guess = 0;
		int counter = 0;
		boolean e = false;
		while (!e && counter < 10) {
			guess = ((max - min) / 2) + min;
			System.out.println("Zgaduję " + guess);
			System.out.println("Zgadłem ?");
			System.out.println("1 - za dużo\n2 - za mało\n3 - zgadłeś");
			int i = readNumber();
			if (i == 1) {
				max = guess;
				counter++;
			} else if (i == 2) {
				min = guess;
				counter++;
			} else if (i == 3) {
				e = true;
			}

		}
		if (e) {
			System.out.println("Zgadłem w " + counter + " krokach");
		} else {
			System.out.println("Nie oszukuj !");
		}

	}


	public static int readNumber() {
		Scanner scan = new Scanner(System.in);
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.println("To nie jest liczba");
		}
		int number = scan.nextInt();
		while (!(number >= 1 && number <= 3)) {
			System.out.println("Zły nr! Wybierz 1, 2 lub 3");
			number = readNumber();
		}
		return number;
	}

}
