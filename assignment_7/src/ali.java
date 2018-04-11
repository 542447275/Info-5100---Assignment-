import java.util.Scanner;

public class ali {
    static String calculate(int a, double i, int n) {

        double lixi = a*i/100*n;

        double total = a+lixi;

        double everyMonth = total/(n*12);

        String result = String.format("%.2f",everyMonth);

        return result;

    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        //请出入贷款金额(正整数):;
        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        //请输入年利率(如:4.35)%:;
        double _i;
        _i = Double.parseDouble(in.nextLine().trim());

        //请输入贷款期限多少年:;
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        res = calculate(_a, _i, _n);
        System.out.println(res);
    }

}
