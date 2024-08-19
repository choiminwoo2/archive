package baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver2941 {

    /*
    č	c=
    ć	c-
    dž	dz=
    đ	d-
    lj	lj
    nj	nj
    š	s=
    ž	z=
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        bw.write(string.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", "A").length() + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
