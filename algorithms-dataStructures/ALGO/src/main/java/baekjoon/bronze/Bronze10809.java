package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bronze10809 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				char[] arr = new char[26];
				int[] resultArr = new int[26];
				for (int i = 0; i < resultArr.length; i++) {
						resultArr[i] = -1;
				}
				char alphabet = 'a';
				for (int i = 0; i < arr.length; i++) {
						arr[i] = (char) (alphabet + i);
				}
				String inputData = br.readLine();
				for (int i = 0; i < inputData.length(); i++) {
						char iData = inputData.charAt(i);
						resultArr[iData % 97] = inputData.indexOf(iData);
				}

				for (int i : resultArr
				) {
						bw.write(i + " ");

				}
				bw.flush();
				br.close();
				bw.close();
		}
}
