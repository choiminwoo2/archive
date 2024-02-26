package baekjoon.bronze;

import java.util.Scanner;

public class Bronze25314 {

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				int bytes = scanner.nextInt();
				int bytesToLong = bytes / 4;
				for (int i = 0; i < bytesToLong - 1; i++) {
						System.out.printf("%s ", "long");
				}
				if (bytes % 4 == 0) {
						System.out.printf("long int");
				} else {
						System.out.printf("int");
				}
		}
}
