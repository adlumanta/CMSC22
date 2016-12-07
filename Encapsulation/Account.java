
public class Account {
	private int accountNumber;
	private double balance;
	
	public Account (int accountNumber, double balance)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public Account (int accountNumber)
	{
		this.accountNumber = accountNumber;
		this.balance = 0.0;
	}
	
	public int getAccountNumber ()
	{
		return this.accountNumber;
	}
	// Setter for account number not needed since account numbers doesn't change
	
	public double getBalance ()
	{
		return this.balance;
	}
	
	public void setBalance (double balance)
	{
		this.balance = balance;
	}
	
	public void credit (double amount)
	{
		this.balance += amount;	// deposit
	}
	
	public void debit (double amount)
	{
		if (amount > this.balance)
		{
			throw new IllegalArgumentException ("Amount withdrawn exceeds the current balance!");
		}
		this.balance -= amount;	//withdraw
	}
	
	public String toString ()
	{
		// returns a String that prints the Acct. nummber and Current balance
		return String.format ("Account Number: %03d, Current Balance = $ %.2f",this.accountNumber,this.balance);
	}
}
