package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Bronze1546 {

		public static void main(String[] args) throws IOException {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				int size = Integer.parseInt(br.readLine());
				String inputData = br.readLine();
				String[] str = inputData.split(" ");
				if (size != str.length) {
						return;
				}
				int max = Arrays.stream(str)
				.mapToInt(Integer::new).max().getAsInt();
				double[] arr = Arrays.stream(str)
				.mapToDouble(Double::new)
				.map(i -> (i / max) * 100)
				.toArray();
				OptionalDouble avg = Arrays.stream(arr).average();
				bw.write(avg.getAsDouble() + "");
				bw.flush();
				br.close();
				bw.close();
		}
}
