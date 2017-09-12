class BankAccount
{
    private double amount;

    public BankAccount()
    {
        amount = 0;
    }

    public void increaseAmount(double a)
    {
        if (a >= 0)
        {
            amount += a;
        }
        else
        {
            System.out.println("Cannot increase by a negative amount.");
        }
    }

    public void decreaseAmount(double a)
    {
        if (a >= 0 && a <= amount)
        {
            amount -= a;
        }
        else if (a > amount)
        {
            amount = 0;
            System.out.println("Empty.");
        }
        else
        {
            increaseAmount(-a);
        }
    }

    public String toString()
    {
        return "Amount = $" + amount;
    }
}

class Bank
{
    public static void main(String[] args)
    {
        int x = 9;
        BankAccount john = new BankAccount();
        john.increaseAmount(45);
        john.decreaseAmount(12);
        System.out.println(john);
    }

}
