package baekjoon.bronze.oper;

import java.util.Scanner;

public class multiplications {

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int c = a * (b % 10);
				int d = a * ((b % 100) / 10);
				int e = a * (b / 100);
				System.out.println(c);
				System.out.println(d);
				System.out.println(e);
				System.out.println(a + (b * 10) + (c * 100));

		}
}
