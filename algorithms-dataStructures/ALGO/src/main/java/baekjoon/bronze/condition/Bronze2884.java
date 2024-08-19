package baekjoon.bronze.condition;

import java.util.Scanner;

public class Bronze2884 {

		public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				String timeAlarm = scanner.nextLine();
				String[] HourMinite = timeAlarm.split(" ");
				int alarmSecond = Integer.parseInt(HourMinite[0]) * 60 + Integer.parseInt(HourMinite[1]);
				int resultSecond = alarmSecond - 45;
				int[] resultArr = {resultSecond / 60, resultSecond % 60};
				System.out.printf("%d %d", resultArr[0], resultArr[1]);
		}
}
