package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze5597 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int[] arr = new int[30];
				for (int i = 0; i < 28; i++) {
						int idx = Integer.parseInt(br.readLine());
						if (arr[idx - 1] == 0) {
								arr[idx - 1] = idx;
						}
				}
				for (int i = 0; i < arr.length; i++) {
						if (arr[i] == 0) {
								System.out.println((i + 1));
						}
				}
				br.close();
		}
}
