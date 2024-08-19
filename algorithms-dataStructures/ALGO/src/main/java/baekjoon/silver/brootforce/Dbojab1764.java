package baekjoon.silver.brootforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dbojab1764 {

    // 접근
    // 듣보잡 n
    // 보못사 m
    // 첫째줄 입력 . 둘째줄부터
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> a = new HashSet();

        String[] inputNum = br.readLine().split(" ");
        List<String> result = new ArrayList<>();
        int firstLen = Integer.parseInt(inputNum[0]);
        int secondLen = Integer.parseInt(inputNum[1]);
        int dataLen = firstLen + secondLen;

        for (int i = 0; i < dataLen; i++) {
            if (i < firstLen) {
                a.add(br.readLine());
            } else if (i < dataLen) {
                String str = br.readLine();
                if (a.contains(str)) {
                    result.add(str);
                }
            }
        }
        bw.write(result.size() + "\n");
        for (Object s : result.stream().sorted().toArray()) {
            bw.write(s + "\n");
        }
        inputNum = null;
        bw.flush();
        bw.close();
    }

}
