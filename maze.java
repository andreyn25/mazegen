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
                maze[i][j].above = Math.random();
                maze[i][j].below = Math.random();
                maze[i][j].left = Math.random();
                maze[i][j].right = Math.random();
            }
        }

        for (int i = 0; i < n; i++) System.out.print(" _");
    }
}