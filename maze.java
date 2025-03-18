import java.util.*;

class space {
    public double above, below, left, right;
    public boolean ca, cb, cl, cr = false;
    public int x, y;
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

        maze[0][0].right = Math.random();
        maze[0][0].below = Math.random();
        for (int i = 1; i < n; i++) {
            maze[0][i].left = maze[0][i-1].right;
            maze[0][i].right = Math.random();
            maze[0][i].below = Math.random();
            maze[i][0].above = maze[i-1][0].below;
            maze[0][i].right = Math.random();
            maze[0][i].below = Math.random();
        }

        //Initialize n-2 square
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                maze[i][j].above = maze[i][j-1].below;
                maze[i][j].below = Math.random();
                maze[i][j].left = maze[i-1][j].right;
                maze[i][j].right = Math.random();
            }
        }

        for (int i = 0; i < n; i++) {
            maze[0][i].above = Double.MAX_VALUE;
            maze[n-1][i].below = Double.MAX_VALUE;
            maze[i][0].left = Double.MAX_VALUE;
            maze[i][n-1].right = Double.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j].x = i;
                maze[i][j].y = i;
            }
        }

        //Now to initialize connections by choosing cheapest
        //Prim
        ArrayList<space> Vt = new ArrayList<>();
        Vt.add(maze[0][0]);

        while (Vt.size() < n*n) {
            double min = Double.MAX_VALUE;
            int sx = 0;
            int sy=0;
            for (int i = 0; i < Vt.size(); i++) {
                space s = Vt.get(i);
                if (s.y > 0) {
                    if (!maze[sx][sy].ca && s.above<min && !Vt.contains(maze[s.x][s.y-1])) {
                        min = s.above;
                        sx = s.x;
                        sy = s.y;
                    }
                } if (s.y < n-1) {
                    if (!maze[sx][sy].cb && s.below<min && !Vt.contains(maze[s.x][s.y+1])) {
                        min = s.below;
                        sx = s.x;
                        sy = s.y;
                    }
                } if (s.x > 0) {
                    if (!maze[sx][sy].cl && s.left<min && !Vt.contains(maze[s.x-1][s.y])) {
                        min = s.left;
                        sx = s.x;
                        sy = s.y;
                    }
                } if (s.x < n-1) {
                    if (!maze[sx][sy].cr && s.right<min && !Vt.contains(maze[s.x][s.y+1])) {
                        min = s.right;
                        sx = s.x;
                        sy = s.y;
                    }
                }
            }

            if (maze[sx][sy].above == min) {
                Vt.add(maze[sx][sy-1]);
                maze[sx][sy].ca = true;
                maze[sx][sy-1].cb = true;
            } else if (maze[sx][sy].below == min) {
                Vt.add(maze[sx][sy+1]);
                maze[sx][sy].cb = true;
                maze[sx][sy+1].ca = true;
            } else if (maze[sx][sy].left == min) {
                Vt.add(maze[sx-1][sy]);
                maze[sx][sy].cl = true;
                maze[sx-1][sy].cr = true;
            } else {
                Vt.add(maze[sx+1][sy]);
                maze[sx][sy].cr = true;
                maze[sx+1][sy].cl = true;
            }
        }

        for (int i = 0; i < n; i++) System.out.print(" _");
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print("|");
            for (int j = 0; j < n; j++) {
                if(!maze[i][j].cb) System.out.print("_");
                else System.out.print(" ");
                if(!maze[i][j].cr) System.out.print("|");
                else System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) System.out.print(" _");
    }

    public String[][] mazify (space[][] maze) {
        String[][] m = new String[maze.length][maze.length];
        space s = maze[0][0];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                s = maze[i][j];
                if (!s.cb) {
                    System.out.print("_");
                }
                if (!s.cr) {
                    System.out.print("|");
                }
            }
            System.out.println("");
        }
        return m;
    }
}