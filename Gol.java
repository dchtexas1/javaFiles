import java.io.*;

class Gol
{
    public static void main(String[] args)
    {
        boolean [][] thefile = readFile();
        printArray(thefile, 0);
        thefile = compute(thefile);
        printArray(thefile, 1);
    }

    public  static boolean [][] readFile()
    {
        boolean [][] file = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int i = 0;

        try
        {
            while((line = br.readLine()) != null)
            {
                if (i == 0)
                {
                    file = new boolean[line.length()][line.length()];
                }
                for (int j = 0; j < line.length(); j++)
                {
                    file[i][j] = (line.charAt(j) == '*');
                }

                i++;
            }
            br.close();
        } catch (Exception e) {}
        return file;
    }

    public static boolean [][] compute(boolean [][] board)
    {
        boolean [][] newboard = new boolean [board.length][board.length];

        int neighbors;

        for (int r = 1; r < board.length - 1; r++)
        {
            for (int c = 1; c < board.length - 1; c++)
            {
                neighbors = 0;
                for (int i = r - 1; i <= r + 1; i++)
                {
                    for (int j = c - 1; j <= c + 1; j++)
                    {
                        if (board[i][j] && !(r==i && j==c))
                        {
                            neighbors++;
                        }
                    }
                }
            if (board[r][c])
            {
                newboard[r][c] = (neighbors == 2 || neighbors == 3);
            }
            else
            {
                newboard[r][c] = (neighbors == 3);
            }
            }
        }
        return newboard;
    }

    public static void printArray(boolean [][] arr, int gen)
    {
        System.out.println("Gen = " + gen);
        for(int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j< arr[i].length; j++)
            {
                System.out.print((arr[i][j]) ? "* " : "  ");
            }
            System.out.println();
        }
    }
}
