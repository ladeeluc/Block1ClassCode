package org.example;

public class BankAccount {
    private double balance;

    public BankAccount(double init){
        balance = init;
        System.out.println("Constructor #1");
    }

    //overload the constructor
    //overload = same method/constructor, different parameters
    //override = same method header, different insides (implementation)
    public BankAccount(){
        this(0);
        System.out.println("Constructor #2");
    }

    public void deposit(double amount){
        balance += amount;
    }

    public double checkBalance(){
        return balance;
    }

    //withdraw method
    //if not enough money-> don't withdraw (return false)
    //if enough money-> update the balance (return true)
    public boolean withdraw(double amount){
        if (amount > balance){
            return false;
        }

        balance -= amount;
        return true;
    }

    @Override
    public String toString(){
        return "Balance: $" + String.format("%.2f", balance);
    }

    //GOAL: transfer an amount of money from ME to the other account
    //return a boolean if the transfer was successful
    public boolean transfer(BankAccount other, double amt){
        boolean attempt = this.withdraw(amt);
        if (attempt){
            other.deposit(amt);
        }
        return attempt;
    }

}
