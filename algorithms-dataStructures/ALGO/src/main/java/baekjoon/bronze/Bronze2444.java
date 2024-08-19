package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze2444 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				int loopSize = Integer.parseInt(br.readLine());
				// 공백 4개 1개
				// 공백 3개 3개
				// 공백 2개 5개
				// 공백 1개 7개
				// 공백 0개 9개
				int num = 1;
				for (int i = 0; i < loopSize; i++) {
						for (int j = loopSize - 1; j > i; j--) {
								bw.write(" ");
						}
						for (int j = 0; j < num; j++) {
								bw.write("★");
						}
						bw.write("\n");
						num += 2;
				}
				num -= 2;
				// 5, 6, 7 , 8 , 9
				for (int i = 0; i < loopSize - 1; i++) {
						num -= 2;
						for (int j = 0; j < i + 1; j++) {
								bw.write(" ");
						}
						for (int j = num; j > 0; j--) {
								bw.write("★");
						}
						bw.write("\n");

				}
				bw.flush();
				br.close();
				bw.close();
		}
}
