import java.util.*;

public class maze {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer for the number of rows and columns in the maze:");
        int n = in.nextInt();
        in.close();
        for (int i = 0; i < n; i++) System.out.print(" _");
        //Prim or Kruskal
        for (int i = 0; i < n; i++) System.out.print(" _");
    }
}