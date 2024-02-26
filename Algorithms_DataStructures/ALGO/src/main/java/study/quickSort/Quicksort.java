package study.quickSort;

import java.util.ArrayList;
import java.util.Scanner;

public class Quicksort {

    public static ArrayList<Integer> quickSort(ArrayList<Integer> myInput) {
        // 이곳에 여러분의 알고리즘을 구현해주세요!
        // 퀵정렬을 통해 오름차순으로 정렬된 array를반환하는 함수를 작성하세요.
        // 첫번째 인덱스를 뽑는다.
        // 트리를 깊게 들어가면서 없거나 나 자신이 root 일 때 리턴.
        if (myInput.size() <= 1) {
            return myInput;
        }
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();
        int pivot = myInput.get(0);

        for (int i = 1; i < myInput.size(); i++) {
            int value = myInput.get(i);
            if (value <= pivot) {
                small.add(value);
            } else {
                large.add(value);
            }
        }
        // 왼쪽부터 정렬 시작
        // 스택에 쌓임 처음 동작
        // 10 ... small = [2,3,4,5,6,9,7,8,1], large = []
        // 2 ... small = [2,1] large = [3,4,5,6,9,7,8]
        // 2 ... small = [1] large = [3,4,5,6,9,7,8]
        // 1 ... small = [] large = [3,4,5,6,9,7,8]
        small = quickSort(small);
        // 왼쪽 정렬 끝 우측 정렬시작
        large = quickSort(large);
        // 정렬 끝.

        small.add(pivot);
        small.addAll(large);

        return small;


    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            arr.add(t);
        }

        ArrayList<Integer> result = quickSort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(result.get(i));
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
    }
}
