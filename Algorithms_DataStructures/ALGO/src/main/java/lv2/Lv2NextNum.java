package lv2;

import java.util.stream.Stream;

public class Lv2NextNum {

    public int nextNum(int n){
        int result = 0;
        int prevCount = BinaryToCount(n);
        while(true){
            n = n + 1;
            int NextCount = BinaryToCount(n);
            if(prevCount == NextCount){
                result = n;
                break;
            }
        }
        return result;
    }

    private int BinaryToCount(int n){
        int[] arr = {0, 1};
        String binary = "";
        int result = 0;
        while(n > 0){
            int remainder = n % 2;
            binary = arr[remainder] + binary;
            n = n / 2;
        }
        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '1'){
                result++;
            }
        }
        return result;
    }
    // 답은 맞지만 효율성 문제로 재풀이 도전
    public int nextNum1(int n) {
        int result = 0;
        int prevCount = Integer.bitCount(n);
        while (true) {
            n = n + 1;
            int NextCount = Integer.bitCount(n);
            if (prevCount == NextCount) {
                result = n;
                break;
            }
        }
        return result;
    }

    // 풀이 디버그 밑 공부
    public int nextBigNumber(int n) {
        int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }
}
