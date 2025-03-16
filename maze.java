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

        //Initialize corners
        maze[0][0].below = Math.random();
        maze[0][0].right = Math.random();
        maze[0][n-1].below = Math.random();
        maze[0][n-1].left = Math.random();
        maze[n-1][0].above = Math.random();
        maze[n-1][0].right = Math.random();
        maze[n-1][n-1].above = Math.random();
        maze[n-1][n-1].left = Math.random();

        //Initialize sides of maze
        for (int i = 1; i < n-1; i++) {
            maze[0][i].left = Math.random();
            maze[0][i].below = Math.random();
            maze[0][i].right = Math.random();
            maze[n-1][i].left = Math.random();
            maze[n-1][i].above = Math.random();
            maze[n-1][i].below = Math.random();
            maze[i][0].above = Math.random();
            maze[i][0].right = Math.random();
            maze[i][0].below = Math.random();
            maze[i][n-1].above = Math.random();
            maze[i][n-1].left = Math.random();
            maze[i][n-1].below = Math.random();
        }

        //Initialize n-2 square
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                maze[i][j].above = Math.random();
                maze[i][j].below = Math.random();
                maze[i][j].left = Math.random();
                maze[i][j].right = Math.random();
            }
        }

        //Now to initialize connections by choosing cheapest

        //Prim or kruskal

        for (int i = 0; i < n; i++) System.out.print(" _");
    }
}