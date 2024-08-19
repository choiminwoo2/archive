package lv2;

import lv2.Lv2ex1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lv2Test {

    @Test
    public void ex1Test(){
        Lv2ex1 ex1 = new Lv2ex1();
        String result = ex1.onetwothreeContry(7);
        String result2 = ex1.onetwothreeContry(1000);
        assertEquals("21", result);
        assertEquals("424241", result2);

    }

    @Test
    public void ex1Test2(){
        Lv2ex1 ex1 = new Lv2ex1();
        String result = ex1.onetwothreeContry2(7);
        String result2 = ex1.onetwothreeContry2(1000);
        assertEquals("21", result);
        assertEquals("424241", result2);

    }

}
