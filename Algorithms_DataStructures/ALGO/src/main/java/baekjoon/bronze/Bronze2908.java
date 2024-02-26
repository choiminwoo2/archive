package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bronze2908 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				String inputData = br.readLine();
				StringTokenizer st = new StringTokenizer(inputData);
				String f = st.nextToken();
				String s = st.nextToken();
				char[] fl = f.toCharArray();
				char[] sl = s.toCharArray();
				String reverseFl = "";
				String reverseSl = "";
				for (int i = 0; i < fl.length; i++) {
						reverseFl += fl[fl.length - 1 - i] + "";
				}
				for (int i = 0; i < sl.length; i++) {
						reverseSl += sl[sl.length - 1 - i] + "";
				}
				int fi = Integer.parseInt(reverseFl);
				int si = Integer.parseInt(reverseSl);
				int result = 0;
				if (fi > si) {
						result = fi;
				} else {
						result = si;
				}
				bw.write(result + "");
				bw.flush();
				br.close();
				bw.close();
		}
}
