package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze15552 {

		public static void main(String[] args) throws IOException {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
				int loopSize = Integer.parseInt(bufferedReader.readLine());
				for (int i = 0; i < loopSize; i++) {
						String[] a = bufferedReader.readLine().split(" ");
						bufferedWriter.write(Integer.parseInt(a[0]) + Integer.parseInt(a[1]) + "\n");

				}
				bufferedWriter.flush();
				bufferedReader.close();
				bufferedWriter.close();
		}
}
