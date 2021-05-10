import java.util.Iterator;
import java.util.Scanner;

public class cifradoDaniAER102 {
	public static void main(String[] args) {
		boolean fin = false;
		int vocales = 0;
		char semillaCero = 'p';
		Scanner sc = new Scanner(System.in);
		while (!fin) {
			String codigo = sc.nextLine();
			if (codigo.charAt(0) == 'p') {
				vocales = 0;
				for (int i = 1; i < codigo.length(); i++) {
					char letra = codigo.charAt(i);
					if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'A'
							|| letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
						++vocales;
					}
				}
				System.out.println(vocales);
			} else if (codigo.charAt(0) != 'p') {
				vocales = 0;
				char semillaChar = codigo.charAt(0);
				int semilla = semillaChar - semillaCero;
				String descifrado = "";
				for (int i = 1; i < codigo.length(); i++) {
					char letra = codigo.charAt(i);
					if (letra != 32) {
						boolean eraMinuscula = false;
						if (Character.isLowerCase(letra)) {
							eraMinuscula = true;
							letra = Character.toUpperCase(letra);
						}
						
						letra = (char) (letra - semilla);
						if ((letra >= 65) && (letra <= 90)) {
						} else if (letra > 90) {
							letra = (char) (65 - (semilla + 1));
						} else if (letra < 65) {
							letra = (char) (90 - (semilla - 1));
						}
						
						if(eraMinuscula) {
							letra = Character.toLowerCase(letra);
						}
					} else {
					}
					descifrado += letra;
				}
				if (descifrado.equals("FIN")) {
					break;
					
				} else {
					for (int i = 0; i < descifrado.length(); i++) {
						char letraDescifrada = descifrado.charAt(i);
						if (letraDescifrada == 'a' || letraDescifrada == 'e' || letraDescifrada == 'i'
								|| letraDescifrada == 'o' || letraDescifrada == 'u' || letraDescifrada == 'A'
								|| letraDescifrada == 'E' || letraDescifrada == 'I' || letraDescifrada == 'O'
								|| letraDescifrada == 'U') {
							++vocales;
						}
					}
					System.out.println(vocales);
				}
			}
		}
	}
}
