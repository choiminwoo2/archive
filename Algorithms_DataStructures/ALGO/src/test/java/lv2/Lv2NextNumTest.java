package lv2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lv2NextNumTest {

    @Test
    public void NextNumTest(){
        // 10 ... 2 ...  0
        // 5  ... 2 ...  1
        // 2 ... 0 ... 0
        // 1
        Lv2NextNum num = new Lv2NextNum();
        int result = num.nextNum(50);
        assertEquals(result, 52);
    }
}
