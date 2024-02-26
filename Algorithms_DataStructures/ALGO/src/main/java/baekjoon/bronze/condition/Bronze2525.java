package baekjoon.bronze.condition;

import java.util.Scanner;

public class Bronze2525 {

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				String timeAlarm = scanner.nextLine();
				String inputMinute = scanner.nextLine();
				String[] HourMinite = timeAlarm.split(" ");
				int minute = Integer.parseInt(HourMinite[0]) * 60 + Integer.parseInt(HourMinite[1]);
				int resultMinute = minute + Integer.parseInt(inputMinute);
				if (resultMinute > 1440) {
						System.out.printf("%d %d", outOfHour(resultMinute) / 60, outOfHour(resultMinute) % 60);
				} else {
						System.out.printf("%d %d", resultMinute / 60, resultMinute % 60);
				}
		}

		public static int outOfHour(int Minute) {
				return -(1440 - Minute);
		}
}
