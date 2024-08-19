package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loopSize = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < loopSize; i++) {
            if (checker(br.readLine())) {
                result++;
            }
        }
        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static boolean checker(String input) {
        int prev = -1;
        boolean[] checkList = new boolean[26];
        for (int i = 0; i < input.length(); i++) {
            int current = input.charAt(i);
            // 이전 문자와 현재 문자가 반복되지 않고 다르다면.
            if (prev != current) {
                // 첫등장하는 문자라면?
                if (!checkList[current - 'a']) {
                    checkList[current - 'a'] = true;
                    prev = current;

                }
                // true라면 해당하는 문자가 그룹 단어가 아니라는 것을 뜻함.
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
