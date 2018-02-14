import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {
    public void printPerfectNumbers(int n) {
        int temp = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int div = 1; div <= i / 2; div++) {
                if (i % div == 0)
                    temp += div;
            }
            if(temp == i) {
                res.add(temp);
                temp = 0;
            }
            else
                temp = 0;
        }
        for(int a : res){
            System.out.print(a + " ");
        }
    }

    public static void main(String[] args){
        PerfectNumber pn = new PerfectNumber();
        pn.printPerfectNumbers(500);
    }
}