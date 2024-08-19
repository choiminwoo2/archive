package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2562 {

		public static void main(String[] args) throws IOException {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				int[] arr = new int[9];
				for (int i = 0; i < 9; i++) {
						arr[i] = Integer.parseInt(bufferedReader.readLine());
				}
				int max = 0;
				int idx = 0;
				for (int i = 0; i < arr.length; i++) {
						if (max < arr[i]) {
								max = arr[i];
								idx = i + 1;
						}
				}
				System.out.printf("%d\n%d", max, idx);
				bufferedReader.close();
		}
}
