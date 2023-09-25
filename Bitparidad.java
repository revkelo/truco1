import java.util.Scanner;

public class Bitparidad {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("bit de paridad Par");
		System.out.println("Digite binario");
		String bit = scanner.nextLine();
		int verifi = 0;
		for (int i = 0; i < bit.length(); i++) {
			char caracter = bit.charAt(i);

			if (caracter == '1') {
				verifi++;
			}
		}
		System.out.println(verifi);
		if (verifi % 2 == 0) {
			System.out.println("par");
			bit += "0";
		} else {

			System.out.println("impar");
			bit += "1";
		}
		System.out.println(bit);

		System.out.println("bit de paridad Impar");
		System.out.println("Digite binario");
		String bit1 = scanner.nextLine();
		int verifi1 = 0;
		for (int i = 0; i < bit1.length(); i++) {
			char caracter = bit1.charAt(i);

			if (caracter == '1') {
				verifi1++;
			}
		}
		System.out.println(verifi1);
		if (verifi1 % 2 == 0) {
			System.out.println("par");
			bit1 += "1";
		} else {

			System.out.println("impar");
			bit1 += "0";
		}
		System.out.println(bit1);

	}

}
