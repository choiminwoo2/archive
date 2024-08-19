package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bronze10871 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
				String firstInput = br.readLine();
				String secondInput = br.readLine();
				StringTokenizer stk1 = new StringTokenizer(firstInput);
				String[] arr = secondInput.split(" ");
				int listSize = Integer.parseInt(stk1.nextToken());

				int compareNum = Integer.parseInt(stk1.nextToken());
				if (listSize != arr.length) {
						br.close();
						wr.close();
						return;
				}
				for (int i = 0; i < arr.length; i++) {
						int resultNum = Integer.parseInt(arr[i]);
						if (compareNum > resultNum) {
								wr.write(resultNum + " ");
						}
				}
				wr.flush();
				br.close();
				wr.close();
		}
}
