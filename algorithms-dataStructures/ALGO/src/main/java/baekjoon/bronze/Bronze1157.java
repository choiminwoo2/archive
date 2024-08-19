package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Bronze1157 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				String input = br.readLine().toUpperCase();
				int[] arr = new int[28];
				for (int i = 0; i < input.length(); i++) {
						int idx = input.charAt(i) % 65;
						arr[idx] += 1;
				}
				int max = Arrays.stream(arr)
				.max()
				.getAsInt();
				int count = 1;
				char result = 'A';
				for (int i = 0; i < arr.length; i++) {
						if (input.length() == 1) {
								result = input.charAt(0);
								break;
						}
						if (max == arr[i]) {
								count++;
								result += i;
						}
				}
				String results = count > 2 ? "?" : result + "";
				bw.write(results);
				bw.flush();
				br.close();
				bw.close();
		}
}
