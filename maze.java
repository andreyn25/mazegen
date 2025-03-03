import java.util.*;

class space {
    public int above;
    public int below;
    public int left;
    public int right;
}
public class maze {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer for the number of rows and columns in the maze:");
        int n = in.nextInt();
        in.close();
        for (int i = 0; i < n; i++) System.out.print(" _");
        //Prim or Kruskal
        space[][] maze = new space[n][n];
        for (int i = 0; i < n; i++) System.out.print(" _");
    }
}