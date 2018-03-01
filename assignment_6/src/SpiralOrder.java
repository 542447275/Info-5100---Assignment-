import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
            return res;

        int rowStart = 0, rowEnd = matrix.length, colStart = 0, colEnd = matrix[0].length;
        int i;
        while (rowStart < rowEnd && colStart < colEnd){
            for(i = colStart; i < colEnd; i++)
                res.add(matrix[rowStart][i]);
            rowStart++;

            for(i = rowStart; i < rowEnd; i++)
                res.add(matrix[i][colEnd - 1]);
            colEnd--;

            if(rowStart < rowEnd){
                for(i = colEnd - 1; i >= colStart; --i)
                    res.add(matrix[rowEnd - 1][i]);
                rowEnd--;
            }

            if(colStart < colEnd){
                for(i = rowEnd - 1; i >= rowStart; --i)
                    res.add(matrix[i][colStart]);
                colStart++;
            }
        }
        return res;
    }

    public static void main (String[] args)
    {
        SpiralOrder s = new SpiralOrder();

        int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };

        int b[][] = {{1,2,3},
                {4,5,6},
                {7,8,9}};

        List<Integer> res = s.spiralOrder(b);

        for(int i : res){
            System.out.print(i + " ");
        }
    }
}