package baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class YourAvgs25206 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map avgGrade = new HashMap<String, Double>();
        avgGrade.put("A+", 4.5);
        avgGrade.put("A0", 4.0);
        avgGrade.put("B+", 3.5);
        avgGrade.put("B0", 3.0);
        avgGrade.put("C+", 2.5);
        avgGrade.put("C0", 2.0);
        avgGrade.put("D+", 1.5);
        avgGrade.put("D0", 1.0);
        avgGrade.put("F", 0.0);
        String str;
        double totalScore = 0.0;
        double totalCredit = 0.0;
        while ((str = br.readLine()) != null) {
            String[] gradeRecord = str.split(" ");
            if (gradeRecord[2].equals("P")) {
                continue;
            }
            double credit = Double.parseDouble(gradeRecord[1]);
            double gradePoint = (double) avgGrade.get(gradeRecord[2]);
            totalScore += (gradePoint * credit);
            totalCredit += credit;
        }
        double result = totalScore / totalCredit;
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
