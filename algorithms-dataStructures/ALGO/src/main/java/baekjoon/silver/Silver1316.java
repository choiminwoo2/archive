package baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Silver1316 {
    //단어 체크
    // aaaaaaaaa bb cc
    // i n k e
    // 상태 3가지 중복된다.
    //          중복하지 않는다.
    // 중복하지만 반복되지 않는다.
    // for 문으로 반복 -> 다른 단어가 나온다면 -> 그 다음 단어부터 다시 체크.
    /// aaa bbb c d
    /// aaa 같다 -> b
    // 변수 x 에 a 엿다가 b로 변경
    // 혹시 반복문을 쭉 돌다가 x와 같은 문자가 나오면 false

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
            // 처음으로 등장하는 문자.
            if (prev != current) {
                if (!checkList[current - 'a']) {
                    checkList[current - 'a'] = true;
                    prev = current;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}
