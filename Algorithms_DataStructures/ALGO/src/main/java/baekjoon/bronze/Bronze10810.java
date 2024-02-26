package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze10810 {

		public static void main(String[] args) throws IOException {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer inputTokens = new StringTokenizer(bufferedReader.readLine());
				int basketSize = Integer.parseInt(inputTokens.nextToken());
				int pushBallCount = Integer.parseInt(inputTokens.nextToken());
				int[] basket = new int[basketSize];
				for (int i = 0; i < pushBallCount; i++) {
						StringTokenizer inputConditions = new StringTokenizer(bufferedReader.readLine());
						int first = Integer.parseInt(inputConditions.nextToken());
						int second = Integer.parseInt(inputConditions.nextToken());
						int third = Integer.parseInt(inputConditions.nextToken());
						for (int j = first; j <= second; j++) {
								basket[j - 1] = third;
						}
				}
				for (int result : basket) {
						System.out.printf("%d ", result);
				}
				bufferedReader.close();
		}
}
