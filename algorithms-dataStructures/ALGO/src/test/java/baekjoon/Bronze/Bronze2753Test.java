package baekjoon.Bronze;


import baekjoon.bronze.condition.Bronze2753;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Bronze2753Test {


		@Test
		void yunYearTest() {
				//given
				int year1 = 2012;
				int year2 = 2000;
				int year3 = 1900;
				//when
				Bronze2753 bronze2753 = new Bronze2753();
				int result1 = bronze2753.checkYunyear(year1);
				int result2 = bronze2753.checkYunyear(year2);
				int result3 = bronze2753.checkYunyear(year3);
				//then
				Assertions.assertEquals(result1, 1);
				Assertions.assertEquals(result2, 1);
				Assertions.assertEquals(result3, 0);
		}
}
