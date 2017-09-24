public class Test
{
    public static void main (String[] args)
    {
        int[] digits;
        digits = new int[9];
        System.out.println(java.util.Arrays.toString(digits));
        for (int i=0; i<9; i++)
        {
            digits[i]++;
        }
        System.out.println(java.util.Arrays.toString(digits));
    }
}
