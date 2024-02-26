package baekjoon.bronze;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumOfString {

		// 스트림 작성 테스트용
		public int sumOfStrings(String inputData) {
				List<Integer> streamOfInputArr = new String(inputData)
				.chars()
				.mapToObj(c -> Character.getNumericValue((char) c))
				.collect(Collectors.toList());
				return streamOfInputArr.stream().mapToInt(i -> i).sum();
		}

		//백준 제출용
		//백준에서 스트림 사용하기 힘든듯..
		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				int inputSizeData = scanner.nextInt();
				String inputData = scanner.next();
				int sum = 0;
				for (int i = 0; i < inputSizeData; i++) {
						sum += inputData.charAt(i) - '0';
				}
				System.out.println(sum);
				scanner.close();
		}
}
