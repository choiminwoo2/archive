package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze9086 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				int loopSize = Integer.parseInt(br.readLine());
				for (int i = 0; i < loopSize; i++) {
						String inputStr = br.readLine();
						int startStr = 0;
						int endStr = inputStr.length() - 1;
						bw.write(inputStr.charAt(startStr) + inputStr.charAt(endStr) + "");
				}
				bw.flush();
				br.close();
				bw.close();
		}
}
