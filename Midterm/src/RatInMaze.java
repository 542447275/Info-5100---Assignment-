import java.util.ArrayList;

class Cell{
    int x, y;
    Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
}

public class RatInMaze {
    public ArrayList<Cell> findPath(int[][] maze){
        ArrayList<Cell> res = new ArrayList<>();
        if(!solveMaze(maze, 0, 0, res)){
            System.out.print("Solution doesn't exist");
            return null;
        }
        return res;
    }

    private boolean solveMaze(int[][] maze, int x, int y, ArrayList<Cell> res){
        if(x == maze.length - 1 && y == maze[0].length - 1){
            res.add(new Cell(x,y));
            return true;
        }
        if(isSafe(maze, x, y)){
            res.add(new Cell(x,y));
            if(solveMaze(maze, x + 1, y, res))
                return true;
            if(solveMaze(maze, x, y + 1, res))
                return true;
        }
        return false;
    }

    private boolean isSafe(int[][] maze, int x, int y){
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1);
    }

    public static void main(String args[])
    {
        RatInMaze rat = new RatInMaze();
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        ArrayList<Cell> res = rat.findPath(maze);
        System.out.print(res);
    }
}
