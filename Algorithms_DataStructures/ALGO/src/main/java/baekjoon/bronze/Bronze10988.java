package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze10988 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				StringBuilder sb = new StringBuilder(br.readLine());
				String input = sb.toString();
				String reverseInput = sb.reverse().toString();
				int count = 0;
				for (int i = 0; i < input.length(); i++) {
						if (reverseInput.charAt(i) == input.charAt(i)) {
								count++;
						}
				}
				if (count == input.length()) {
						bw.write("1");
				} else {
						bw.write("0");
				}
				bw.flush();
				br.close();
				bw.close();
		}
}
