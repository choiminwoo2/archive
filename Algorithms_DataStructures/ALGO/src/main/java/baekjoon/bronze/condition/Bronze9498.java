package baekjoon.bronze.condition;

import java.util.Scanner;

public class Bronze9498 {

		enum Scores {
				A, B, C, D, F

		}

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				int a = scanner.nextInt();
				if (a > 90) {
						System.out.println(Scores.A.name());
				} else if (a > 80) {
						System.out.println(Scores.B.name());
				} else if (a > 70) {
						System.out.println(Scores.C.name());
				} else if (a > 60) {
						System.out.println(Scores.D.name());
				} else {
						System.out.println(Scores.F.name());
				}
		}
}


