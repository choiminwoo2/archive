package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze10807 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				int inputSize = Integer.parseInt(br.readLine());
				String[] arr = br.readLine().split(" ");
				String equalsNum = br.readLine();
				int equalsCount = 0;
				if (inputSize != arr.length) {
						br.close();
						bw.close();
						return;
				}
				for (int i = 0; i < arr.length; i++) {
						if (arr[i].equals(equalsNum)) {
								equalsCount++;
						}
				}
				bw.write(equalsCount + "");
				bw.flush();
				br.close();
				bw.close();
		}
}
