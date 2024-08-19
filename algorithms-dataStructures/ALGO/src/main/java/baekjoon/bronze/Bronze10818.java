package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bronze10818 {

		public static void main(String[] args) throws IOException {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				int size = Integer.parseInt(bufferedReader.readLine());
				String[] inputNumbers = bufferedReader.readLine().split(" ");
				if (inputNumbers.length != size) {
						return;
				}
				int max = Arrays.stream(inputNumbers)
				.mapToInt(Integer::parseInt).max().getAsInt();
				int min = Arrays.stream(inputNumbers)
				.mapToInt(Integer::parseInt).min().getAsInt();
				System.out.printf("%d %d", min, max);
				bufferedReader.close();
		}
}
