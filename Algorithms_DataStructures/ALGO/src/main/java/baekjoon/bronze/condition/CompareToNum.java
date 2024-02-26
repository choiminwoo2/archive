package baekjoon.bronze.condition;

import java.util.Scanner;

public class CompareToNum {

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				boolean biggerA = a > b;
				boolean biggerB = a < b;
				boolean equalsTwo = a == b;
				if (biggerA) {
						System.out.println(">");
				} else if (biggerB) {
						System.out.println("<");
				} else if (equalsTwo) {
						System.out.println("==");
				}
		}
}
