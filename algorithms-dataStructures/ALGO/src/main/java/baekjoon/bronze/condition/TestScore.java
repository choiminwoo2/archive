package baekjoon.bronze.condition;

import java.util.Scanner;

public class TestScore {

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				boolean x = a > 0;
				boolean y = b > 0;
				if (x && y) {
						System.out.println("1");
				}
				if (!x && y) {
						System.out.println("2");
				}
				if (!x && !y) {
						System.out.println("3");
				}
				if (x && !y) {
						System.out.println("4");
				}
		}

}
