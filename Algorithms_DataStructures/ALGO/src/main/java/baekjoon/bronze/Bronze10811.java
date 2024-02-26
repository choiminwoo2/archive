package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bronze10811 {

		public static void main(String[] args) throws IOException {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer inputTokens = new StringTokenizer(bufferedReader.readLine());
				int basketSize = Integer.parseInt(inputTokens.nextToken());
				int pushBallCount = Integer.parseInt(inputTokens.nextToken());
				int[] basket = new int[basketSize];
				for (int i = 0; i < basketSize; i++) {
						basket[i] = i + 1;
				}
				for (int i = 0; i < pushBallCount; i++) {
						StringTokenizer inputConditions = new StringTokenizer(bufferedReader.readLine());
						int first = Integer.parseInt(inputConditions.nextToken());
						int second = Integer.parseInt(inputConditions.nextToken());
						reverseArr(basket, first, second);
				}
				for (int result : basket) {
						System.out.printf("%d ", result);
				}
				bufferedReader.close();
		}

		public static void reverseArr(int[] arr, int startLine, int endLine) {
				int[] tempArr = Arrays.copyOf(arr, arr.length);
				int idx = startLine - 1;
				for (int i = endLine - 1; i >= startLine - 1; i--) {
						arr[idx] = tempArr[i];
						idx++;
				}
		}
}
