import java.util.*;

class space {
    public double above, below, left, right;
    public boolean ca, cb, cl, cr;
}
public class maze {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer for the number of rows and columns in the maze:");
        int n = in.nextInt();
        in.close();
        for (int i = 0; i < n; i++) System.out.print(" _");

        //Initialize maze
        space[][] maze = new space[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = new space();
            }
        }

        //Initialize n-2 square
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                maze[i][j].above = Math.random();
                maze[i][j].below = Math.random();
                maze[i][j].left = Math.random();
                maze[i][j].right = Math.random();
            }
        }

        for (int i = 0; i < n; i++) {
            maze[0][i].above = Double.MAX_VALUE;
            maze[n-1][i].below = Double.MAX_VALUE;
            maze[i][0].left = Double.MAX_VALUE;
            maze[i][n-1].right = Double.MAX_VALUE;
        }

        //Now to initialize connections by choosing cheapest
        //Prim or kruskal
        

        for (int i = 0; i < n; i++) System.out.print(" _");
    }

    public int cheapestEdge(space[][] maze, int x, int y) {
        int cheapest = 0;
        if (maze[x][y].cl) {
            cheapest = maze[x][y].left
        }

        maze[x+1][y]
        maze[x][y-1]
        maze[x-1][y+1]
        return 0;   
    }
}