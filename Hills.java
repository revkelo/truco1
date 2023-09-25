import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Hills {
	static char[] ABECEDARIO = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static void main(String[] args) {
		Scanner lec = new Scanner(System.in);
		ArrayList<Integer> listClave = new ArrayList<>();
		ArrayList<Integer> listPalabra = new ArrayList<>();
		System.out.println("Ingrese el tamaño de la matriz");
		int tamanoMatriz = lec.nextInt();

		int[][] matriz = new int[tamanoMatriz][tamanoMatriz];

		lec.nextLine();
		System.out.println("Ingrese la clave (4 caracteres maximo)");
		String clave = lec.nextLine();
		clave = clave.toUpperCase();
		clave01(clave, listClave);
		matriz = agregarmatriz(listClave, matriz, tamanoMatriz);

		System.out.println("MATRIZ CLAVE");
		for (int i = 0; i < tamanoMatriz; i++) {
			for (int j = 0; j < tamanoMatriz; j++) {
				System.out.print(matriz[j][i] + " ");
			}

			System.out.println();
		}

		System.out.println("Ingrese la palabra a cifrar");
		String palabra = lec.nextLine();
		palabra = palabra.toUpperCase();
		clave01(palabra, listPalabra);

		for (int i = 0; i < listPalabra.size(); i++) {
			System.out.println(listPalabra.get(i));
		}

		int bloques = bloques01(listPalabra, 2);
		int ubi = 0;
		for (int i = 0; i < bloques; i++) {
			int a1 = listPalabra.get(ubi);
			ubi++;
			int a2 = listPalabra.get(ubi);
			ubi++;

			int multiplicar = a1;
			for (int t = 0; t < tamanoMatriz; t++) {
				for (int j = 0; j < tamanoMatriz; j++) {
					System.out.print(matriz[t][j] + " (ayuda dios = " + multiplicar + ")");

					matriz[t][j] = matriz[t][j] * multiplicar;

				}

				multiplicar = a2;
			}

			int a = 0, b = 0;
			for (int k = 0; k < tamanoMatriz; k++) {
				int sumaFila = 0;
				for (int j = 0; j < tamanoMatriz; j++) {
					sumaFila += matriz[k][j];
				}

				if (k == 0) {
					a = sumaFila;
				} else if (k == 1) {
					b = sumaFila;
				}
			}
			System.out.println("FILA 0  " + a);
			System.out.println("FILA 1  " + b);
			reiniciar(listClave, matriz, tamanoMatriz);

		}

	}

	public static void reiniciar(ArrayList<Integer> list, int[][] matriz, int tamanoMatriz) {
		for (int i = 0; i < tamanoMatriz; i++) {

			for (int j = 0; j < tamanoMatriz; j++) {

				matriz[i][j] = 0;
			}
		}
		matriz = agregarmatriz(list, matriz, tamanoMatriz);
	}

	public static int[][] agregarmatriz(ArrayList<Integer> list, int[][] matriz, int tamanoMatriz) {

		int avanza = 0;
		for (int r = 0; r < tamanoMatriz; r++) {
			for (int j = 0; j < tamanoMatriz; j++) {
				matriz[r][j] = list.get(avanza);
				avanza++;
			}
		}
		return matriz;
	}

	public static int bloques01(ArrayList<Integer> list, int bloques) {
		int aux = list.size() / bloques;
		if (list.size() % bloques != 0) {
			aux++;
		}
		return aux;
	}

	public static void clave01(String aux, ArrayList<Integer> list) {
		for (int i = 0; i < aux.length(); i++) {
			char caracter = aux.charAt(i);

			for (int j = 0; j < ABECEDARIO.length; j++) {
				if (caracter == ABECEDARIO[j]) {
					list.add(j);
				}
			}

		}
	}
}
