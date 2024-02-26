package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Bronze3003 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				int[] chessUnits = {1, 1, 2, 2, 2, 8};

				int[] arr = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
				for (int i = 0; i < chessUnits.length; i++) {
						chessUnits[i] -= arr[i];
						bw.write(chessUnits[i] + " ");
				}

				bw.flush();
				br.close();
				bw.close();
		}
}
