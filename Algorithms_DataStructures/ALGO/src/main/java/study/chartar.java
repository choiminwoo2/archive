package study;

public class chartar {

    public static void main(String[] args) {

        int result = gcd(20114, 5000);

    }

    public static int gcd(int target, int mod) {

        if (mod == 0) {
            return target;
        }
        return gcd(mod, target % mod);
    }
}
