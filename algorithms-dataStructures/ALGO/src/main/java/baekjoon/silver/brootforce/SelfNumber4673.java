package baekjoon.silver.brootforce;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

class D {

    public static int d(int value) {
        int i = value;
        while (value != 0) {
            i = i + (value % 10);
            value /= 10;
        }
        return i;
    }
}

public class SelfNumber4673 {


    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder builder = new StringBuilder();
        D d = new D();
        boolean[] force = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            int n = d.d(i);
            if (n <= 10000) {
                force[n] = true;
            }
        }
        for (int i = 1; i < force.length; i++) {
            if (!force[i]) {
                builder.append(i + "\n");
            }
        }
        bw.write(builder.toString());
        bw.flush();
        bw.close();
    }
}
