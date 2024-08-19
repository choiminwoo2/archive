package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze10813 {

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
						int temp = basket[first - 1];
						basket[first - 1] = basket[second - 1];
						basket[second - 1] = temp;
				}
				for (int result : basket) {
						System.out.printf("%d ", result);
				}
				bufferedReader.close();
		}
}
