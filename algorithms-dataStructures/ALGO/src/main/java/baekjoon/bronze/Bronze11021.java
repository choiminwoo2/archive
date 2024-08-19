package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze11021 {

		public static void main(String[] args) throws IOException {
				BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
				int listSize = Integer.parseInt(bf.readLine());

				for (int i = 0; i < listSize; i++) {
						String[] input = bf.readLine().split(" ");

						bufferedWriter.write("Case #" + (i + 1) + ": " + (Integer.parseInt(input[0]) + Integer.parseInt(input[1])) + "\n");
				}
				bufferedWriter.flush();
				bf.close();
				bufferedWriter.close();
		}
}
