import java.io.*;

class Echo
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line;

            while ((line = br.readLine()) != null)
            {
                System.out.println(line);
            }
            br.close();
        }
        catch(Exception e) {}
    }

}
