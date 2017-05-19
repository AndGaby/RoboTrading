import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static String input;
	static Integer ponteiro = 0;
	static Boolean fim = false;
	static String tempS;
	static Character tempC;
	static Integer tempN;

	static Integer contadorPalavraReservada = 0;
	static Integer contadorVariavel = 0;

	static List<String> saida = new ArrayList<>();
	static List<String> palavrasReservas = new ArrayList<>();
	static List<String> variaveis = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine().toLowerCase();

		palavrasReservas.add("if");
		palavrasReservas.add("then");
		palavrasReservas.add("print");
		palavrasReservas.add("else");

		e0();

		for (String string : saida) {
			System.out.print(string + " ");
		}
		sc.close();
	}

	public static Character getChar() {
		if (ponteiro >= input.length()) {
			fim = true;
			return ' ';
		} else {
			return input.charAt(ponteiro);
		}
	}

	public static void e0() {
		Character c = getChar();

		if (c >= 'a' && c <= 'z') {
			System.out.println("Aplica Regra 1");
			tempS = c.toString();
			ponteiro++;
			e1();
		} else if (c >= '0' && c <= '9') {
			System.out.println("Aplica Regra 4");
			tempN = c - '0';
			ponteiro++;
			e2();
		} else if (c == ':') {
			System.out.println("Nao aplica regra");
			ponteiro++;
			e3();
		} else if (c == '%') {
			System.out.println("Nao aplica regra");
			ponteiro++;
			e6();
		} else if (fim == true) {
			System.out.println("Fim do reconhecimento!");
			return;
		} else if (c == ' ') {
			System.out.println("Nao aplica regra");
			ponteiro++;
			e0();
		} else {
			System.out.println("Aplica Regra 9");
			tempC = c;
			ponteiro++;
			e5();
		}
	}

	public static void e1() {
		Character c = getChar();

		if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
			System.out.println("Aplica Regra 2");
			tempS += c.toString();
			ponteiro++;
			e1();
		} else {
			System.out.println("Aplica Regra 3");
			aplicarRegra3();
			e0();
		}
	}

	public static void e2() {
		Character c = getChar();

		if (c >= '0' && c <= '9') {
			System.out.println("Aplica Regra 5");
			tempN = tempN * 10 + (c - '0');
			ponteiro++;
			e2();
		} else {
			System.out.println("Aplica Regra 6");
			saida.add("N(" + tempN + ")");
			e0();
		}
	}

	public static void e3() {
		Character c = getChar();

		if (c == '=') {
			System.out.println("Nao aplica regra");
			ponteiro++;
			e4();
		} else {
			System.out.println("Aplica Regra 7");
			saida.add(":");
			e0();
		}
	}

	public static void e4() {
		System.out.println("Aplica Regra 8");
		saida.add(":=");
		e0();
	}

	public static void e5() {
		System.out.println("Aplica Regra 10");
		saida.add(tempC.toString());
		e0();
	}

	public static void e6() {
		System.out.println("Muda Linha");
		saida.add("\n");
		e0();
	}

	public static void aplicarRegra3() {
		if (palavrasReservas.contains(tempS)) {
			saida.add("P(" + palavrasReservas.indexOf(tempS) + ")");
		} else {
			if (variaveis.contains(tempS)) {
				saida.add("V(" + variaveis.indexOf(tempS) + ")");
			} else {
				variaveis.add(tempS);
				saida.add("V(" + variaveis.indexOf(tempS) + ")");
			}
		}
	}
}