

public class Main {

    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        System.out.println(qpow(a, b));
        System.out.println("ok");
    }

    static int qpow(int a, int b) {
        int ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a;
            }
            a *= a;
            b >>= 1;
        }
        return ans;
    }

}
