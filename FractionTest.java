class Fraction
{
    private int num;
    private int den;

    public Fraction()
    {
        num = 0;
        den = 1;
    }

    public Fraction(int n, int d)
    {
        num = n;
        if (d == 0)
            den = 1;
        else
            den = d;
    }

    public int getNum()
    {
        return num;
    }

    public int getDen()
    {
        return num;
    }

    public void setNum(int val)
    {
        num = val;
    }

    public void setDen(int val)
    {
        if (val != 0)
            den = val;
    }

    public double getReal()
    {
        return (double) num / den;
    }

    public String toString()
    {
        return num + "/" + den;
    }
}

class FractionTest
{
    public static void main(String[] args)
    {
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(2, 3);

        System.out.println("f1=" + f1 + " (" + f1.getReal() + ")");
        f1.setNum(5);
        f1.setDen(10);
        System.out.println("f1=" + f1 + " (" + f1.getReal() + ")");
        System.out.println("f2=" + f2 + " (" + f2.getReal() + ")");
    }

}
