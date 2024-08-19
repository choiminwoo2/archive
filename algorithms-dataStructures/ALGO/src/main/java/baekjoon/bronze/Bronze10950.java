package baekjoon.bronze;

import java.util.Scanner;

public class Bronze10950 {

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				int listSize = scanner.nextInt();

				for (int i = 0; i < listSize; i++) {
						int a = scanner.nextInt();
						int b = scanner.nextInt();
						System.out.printf("%d", a + b);
				}

		}

}
