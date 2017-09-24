import java.io.*;
import java.lang.*;

class Gol
{
    public static void main(String[] args)
    {
        boolean [][] thefile = readFile();
        int noGens = 0, maxGens = readArgs(args);
        try
        {
            for (; noGens < maxGens; noGens++)
            {
                printArray(thefile, noGens);
                thefile = compute(thefile);
                Thread.sleep(100);
            }
        }
        catch (Exception e) {}
    }

    public static int readArgs(String [] args)
    {
        int num = 10;
        if (args.length > 0)
        {
            try
            {
                num = Integer.parseInt(args[0]);
            }
            catch (NumberFormatException e)
            {
                System.out.println("First arg must be int value.");
            }
        }
        return num;
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
                neighbors = countNeighbors(r, c, board);
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

    public static int countNeighbors(int r, int c, boolean [][] board)
    {
        int neighbors = 0;
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
        return neighbors;
    }

    public static void printArray(boolean [][] arr, int gen)
    {
        clearScreen();
        System.out.print("Gen = " + gen + " \n  ");
        for (int i = 1; i < arr.length-1; i++)
        {
            System.out.print(i%10 + " ");
        }
        System.out.println();

        for(int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j< arr[i].length; j++)
            {
                System.out.print((arr[i][j]) ? "* " : "  ");
            }
            System.out.println();
        }
    }
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
