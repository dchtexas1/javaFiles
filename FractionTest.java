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

    public Fraction add(Fraction other)
    {
        int n = this.num * other.den + other.num * den;
        int d = this.den * other.den;
        return new Fraction(n, d);
    }

    public Fraction sub(Fraction other)
    {
        int n = this.num * other.den - other.num * den;
        int d = this.den * other.den;
        return new Fraction(n, d);
    }

    public Fraction mult(Fraction other)
    {
        int n = this.num * other.num;
        int d = this.den * other.den;
        return new Fraction(n, d);
    }

    public Fraction div(Fraction other)
    {
        int n = this.num * other.den;
        int d = this.den * other.num;
        return new Fraction(n, d);
    }
    public Fraction reduce()
    {
        int gcd = 1;
        int low = Math.min(Math.abs(num), Math.abs(den));
        for (int i = 2; i < low; i++)
        {
            if (this.num % i == 0 && this.den % i == 0)
            {
                gcd = i;
            }
        }

        this.num /= gcd;
        this.den /= gcd;
        if (this.num == 0)
        {
            this.den = 1;
        }
        return 
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
        Fraction f3 = new Fraction(1, 3);

        System.out.println("f1=" + f1 + " (" + f1.getReal() + ")");
        f1.setNum(5);
        f1.setDen(10);
        System.out.println("f1=" + f1 + " (" + f1.getReal() + ")");
        System.out.println("f2=" + f2 + " (" + f2.getReal() + ")");
        System.out.println("f2*f3=" + f2.mult(f3));
    }

}
