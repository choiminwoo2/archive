package baekjoon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baekjoon.bronze.SumOfString;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


public class SumOfStringTest {

		@Test
		void ex1Test() {
				SumOfString sumOfString = new SumOfString();

				String givenData1 = "25";
				String givenData2 = "54321";
				assertEquals(7, sumOfString.sumOfStrings(givenData1));
				assertEquals(15, sumOfString.sumOfStrings(givenData2));
		}

		@Test
		void ex2Test() {
				String a = "55 77 7512";
				String[] strings = a.split(" ");
				System.out.println(strings[0]);
				System.out.println(strings[1]);
				System.out.println(strings[2]);
				int result = Arrays.stream(strings).mapToInt(Integer::parseInt).sum();
				System.out.println(result);
		}
}
