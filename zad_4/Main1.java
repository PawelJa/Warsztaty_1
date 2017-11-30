package zad_4;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		System.out.println("Podaj kod kości w postaci xDy+z");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		str = str.replaceAll("d", "D");
		int x = getX(str);
		int y = getY(str);
		int z = getZ(str, y);

		int y2 = 0;

		for (int i = 0; i < x; i++) {
			Random rand = new Random();
			y2 = y2 + (rand.nextInt(y)+1) ;
		}
		int sum = y2 + z;
		System.out.println("Suma oczek to : " + sum);

	}

	static int getX(String str) {
		int posD = charPos(str, 'D');
		String strTmp = "";
		int x = 0;
		if (posD == 1) {
			x = 1;
		} else {
			strTmp = str.substring(0, posD - 1);
			x = Integer.parseInt(strTmp);
		}
		return x;
	}

	static int getY(String str) {
		int posD = charPos(str, 'D');
		int posP = charPos(str, '+');
		int posM = charPos(str, '-');
		String strTmp = "";
		int y = 0;
		if ((posP == 0) && (posM == 0)) {
			strTmp = str.substring(posD);
			y = Integer.parseInt(strTmp);
		} else if (posP != 0) {
			strTmp = str.substring(posD, posP - 1);
			y = Integer.parseInt(strTmp);
		} else if (posM != 0) {
			strTmp = str.substring(posD, posM - 1);
			y = Integer.parseInt(strTmp);
		}
		return y;
	}

	static int getZ(String str, int y) {
		int posZ1 = charPos(str, '+');
		int posZ2 = charPos(str, '-');
		int z = 0;
		String strTmp = "";
		if ((posZ1 == 0) && (posZ2 == 0)) {
			z = 0;
		} else if (posZ1 != 0) {
			strTmp = str.substring(posZ1);
			z = Integer.parseInt(strTmp);
		} else if (posZ2 != 0) {
			strTmp = str.substring(posZ2);
			z = Integer.parseInt(strTmp);
			z = z * (-1);
		}
		return z;

	}

	static int charPos(String str, char c) {
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			char myChar = str.charAt(i);
			if (c == myChar) {
				j = i + 1;
			}
		}
		return j;
	}

}
