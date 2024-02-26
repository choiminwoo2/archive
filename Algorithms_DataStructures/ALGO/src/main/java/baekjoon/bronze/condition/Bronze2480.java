package baekjoon.bronze.condition;

import java.util.Scanner;

public class Bronze2480 {

		public static void main(String[] args) {

				Scanner scanner = new Scanner(System.in);
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int c = scanner.nextInt();
				int equlasNum = equalsNumbers(a, b, c);
				switch (equlasNum) {
						case 1:
								System.out.printf("%d", maxNumber(a, b, c) * 100);
								break;
						case 2:
								System.out.printf("%d", 1000 + maxNumber(a, b, c) * 100);
								break;
						case 3:
								System.out.printf("%d", 10000 + maxNumber(a, b, c) * 1000);
								break;


				}
		}

		//return num , equlsNum
		private static int equalsNumbers(int a, int b, int c) {
				if (a == b && b == c) {
						return 3;
				}
				if (a != b && b != c && a != c) {
						return 1;
				}
				if (a == b || a == c || b == c) {
						return 2;
				}
				return 0;
		}

		private static int maxNumber(int a, int b, int c) {
				if (a == b) {
						return b;
				} else if (b == c) {
						return c;
				} else if (a == c) {
						return a;
				}
				int[] arr = new int[3];
				arr[0] = a;
				arr[1] = b;
				arr[2] = c;
				int max = 0;
				for (int i = 0; i < arr.length; i++) {
						if (arr[i] >= max) {
								max = arr[i];
						}
				}
				return max;
		}


}
