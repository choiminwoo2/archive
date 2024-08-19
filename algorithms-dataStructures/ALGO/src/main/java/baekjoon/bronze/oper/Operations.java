package baekjoon.bronze.oper;

import java.util.Scanner;

public class Operations {

		public static void main(String[] args) {

				Scanner scanner = new Scanner(System.in);
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				double result = (double) a / b;
				System.out.println(result);
				scanner.close();
		}
}
