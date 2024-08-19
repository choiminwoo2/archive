package baekjoon.bronze.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy5585 {

		public static void main(String[] args) throws IOException {
				int[] countType = {500, 100, 50, 10, 5, 1};
				int send = 1000;
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int payment = Integer.parseInt(br.readLine());
				int n = send - payment;
				int coin = 0;
				for (int count : countType) {
						coin += n / count;
						n %= count;
				}
				System.out.println(coin);
				br.close();
		}
}
