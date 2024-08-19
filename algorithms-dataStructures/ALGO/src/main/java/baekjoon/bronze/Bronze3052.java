package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze3052 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				int loopCount = 10;
				int[] arr = new int[42];
				// 0 1 2 3 4 0 2 3 4
				for (int i = 0; i < loopCount; i++) {
						int input = Integer.parseInt(br.readLine());
						arr[input % 42] = 1;
				}
				int resultCount = 0;
				for (int i = 0; i < loopCount; i++) {
						if (arr[i] == 1) {
								resultCount++;
						}
				}
				bw.write(resultCount + "");
				bw.flush();
				br.close();
				bw.close();
		}
}
