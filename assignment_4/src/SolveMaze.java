import java.util.*;

public class SolveMaze {
//    private static char[][] maze = {
//            {'S','@','@','@'},
//            {'+','+','+','+'},
//            {'@','@','@','F'}
//    };
//    private static char[][] maze = {
//            {'@','S','@','@','@','@','@'},
//            {'@','+','+','+','+','+','@'},
//            {'@','@','+','@','+','@','@'},
//            {'@','+','+','@','+','+','@'},
//            {'@','@','@','@','+','@','@'},
//            {'@','+','+','+','+','+','@'},
//            {'@','F','@','@','@','@','@'}
//    };

    private static char[][] maze = {
            {'@','S','@','@','@','@','@'},
            {'@','+','+','+','+','+','@'},
            {'@','@','+','@','+','@','@'},
            {'@','@','@','@','+','+','@'},
            {'@','+','+','@','+','@','@'},
            {'@','+','+','+','+','+','@'},
            {'@','F','@','@','@','@','@'}
    };
    private static int[][] res = new int[maze.length][maze[0].length];

    private static ArrayList<Character> direction = new ArrayList<>();

    private static boolean findSolution(int r, int c) {
        if(maze[r][c] == 'F')
        {
            res[r][c] = 1;
            return true;
        }

        if ((r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && res[r][c] == 0 && (maze[r][c] == '+') || maze[r][c] == 'S')) {
            res[r][c] = 1;
            if (findSolution(r + 1, c)) {
                direction.add(0, 'D');
                return true;
            }
            if (findSolution(r, c + 1)) {
                direction.add(0, 'R');
                return true;
            }
            if (findSolution(r - 1, c)) {
                direction.add(0, 'U');
                return true;
            }
            if (findSolution(r, c - 1)) {
                direction.add(0, 'L');
                return true;
            }
            res[r][c] = 0;
            return false;
        } else {
            return false;
        }
    }

//    private static void printSolution() {
//        for(int i = 0; i < maze.length; i++) {
//            for(int j = 0; j < maze[0].length; j++) {
//                System.out.print(res[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("\n");
//    }

    private void solveMaze(char[][] maze){
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'S') {
                    if (findSolution(i, j)) {
                        for(char ch : direction){
                            System.out.print(ch);
                        }
                    }
                    else
                        System.out.println("No solution\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        SolveMaze sm = new SolveMaze();
        sm.solveMaze(maze);

    }
}
