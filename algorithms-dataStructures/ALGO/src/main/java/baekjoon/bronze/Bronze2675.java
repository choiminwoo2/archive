package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bronze2675 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				int loopSize = Integer.parseInt(br.readLine());
				for (int i = 0; i < loopSize; i++) {
						StringTokenizer stk = new StringTokenizer(br.readLine());
						int continues = Integer.parseInt(stk.nextToken());
						String str = stk.nextToken();
						String result = "";
						for (int j = 0; j < str.length(); j++) {
								for (int k = 0; k < continues; k++) {
										result += str.charAt(j);
								}
						}
						bw.write(result + "\n");
						result = "";
				}
				bw.flush();
				br.close();
				bw.close();
		}
}
