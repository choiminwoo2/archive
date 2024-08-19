package baekjoon.bronze;

import java.util.Scanner;

public class Bronze25304 {

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				int sumOfPrice = scanner.nextInt();
				int listSize = scanner.nextInt();
				int resultSum = 0;
				for (int i = 0; i < listSize; i++) {
						int price = scanner.nextInt();
						int amount = scanner.nextInt();
						resultSum += (price * amount);
				}
				if (resultSum == sumOfPrice) {
						System.out.printf("%s", "Yes");
				}
				if (resultSum != sumOfPrice) {
						System.out.printf("%s", "No");
				}
		}
}
