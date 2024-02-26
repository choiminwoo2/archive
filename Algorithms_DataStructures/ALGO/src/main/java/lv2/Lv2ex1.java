package lv2;

public class Lv2ex1 {
    public String onetwothreeContry(int n){
        StringBuilder inputNum = new StringBuilder();

        while(n > 0){
            int num = n % 3;
            if(num == 0){
                inputNum.append('4');
                n = (n - 1) / 3;
            }else{
                inputNum.append(Integer.toString(num));
                n = n / 3;
            }
        }
        return inputNum.reverse().toString();
    }

    public String onetwothreeContry2(int n){
        // 0, 1, 2 순서이므로
        String[] arr = {"4","1","2"};
        String answer = "";
        while(n > 0){
            int remains = n % 3;
            answer = arr[remains] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}
