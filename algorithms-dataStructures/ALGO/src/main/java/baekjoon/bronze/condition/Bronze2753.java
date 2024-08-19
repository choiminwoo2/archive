package baekjoon.bronze.condition;

import java.util.Scanner;

public class Bronze2753 {

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				int yun_year = scanner.nextInt();
				Bronze2753 bronze2753 = new Bronze2753();
				int result = bronze2753.checkYunyear(yun_year);
				System.out.println(result);

		}

		public int checkYunyear(int year) {

				boolean compare_years = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
				if (compare_years) {
						return 1;
				} else {
						return 0;
				}
		}
}
