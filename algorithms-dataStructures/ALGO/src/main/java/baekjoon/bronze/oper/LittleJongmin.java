package baekjoon.bronze.oper;

import java.util.Arrays;
import java.util.Scanner;

public class LittleJongmin {

		public void invalStreams() {
				//스트림 이용

				String a = "55 77 1234";
				String[] strings = a.split(" ");
				int sum = Arrays.stream(strings).mapToInt(Integer::parseInt).sum();
				System.out.println(sum);
		}

		//스트림 이용
		public static void main(String[] args) {

				Scanner scanner = new Scanner(System.in);
				String a = scanner.nextLine();
				String[] strings = a.split(" ");
				int result = 0;
				for (int i = 0; i < strings.length; i++) {
						result += Integer.parseInt(strings[i]);
				}
				System.out.println(result);
				scanner.close();
		}
}
