public class Date {
	private int year;
	private int month;
	private int day;

	public Date () 
	{
		// Default blank constructor which sets the date to 01/01/1000
		year = 1000;
		month = 1;
		day = 1;
	}

	public Date (int year, int month, int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public int getYear()
	{
		return year;
	}
	public int getMonth()
	{
		return month;
	}
	public int getDay()
	{
		return day;
	}

	public void setYear (int year)
	{
		// Limits the year digits from 1000 to 9999
		if (year < 1000 || year > 9999)
		{
			throw new IllegalArgumentException ("Error: Invalid year format");
		}
		this.year = year;
	}

	public void setMonth (int month)
	{
		// Limits the month from 1 to 12
		if (month < 1 || month > 12)
		{
			throw new IllegalArgumentException ("Error: Invalid month format");
		}
		this.month = month;
	}

	public void setDay (int day)
	{
		// 31 is the max valid value of day
		if (day < 1 || day > 31)
		{
			throw new IllegalArgumentException ("Error: Invalid day format");
		}
		// February has two conditions: If leap year it accepts 29 as valid input, 28 otherwise.
		if (this.month == 2)
		{
			if (this.year % 4 == 0)
			{
				if (day > 29)
				{
					throw new IllegalArgumentException ("Error: Invalid day format");
				}
			}
			else 
			{
				if (day > 28)
				{
					throw new IllegalArgumentException ("Error: Invalid day format");
				}
			}
		}
		// April, June, September and November has 30 days only
		if (getMonth() == 4 || getMonth() == 6 || getMonth() == 9 || getMonth() == 11)
		{
			if (day > 30)
			{
				throw new IllegalArgumentException ("Error: Invalid day format");
			}
		}
		this.day = day;
	}

	public String toString ()
	{
		// returns mm/dd/yyyy format with leading zeros if necessary
		return String.format ("%02d/%02d/%d",this.day ,this.month ,this.year);
	}
	
	public void setDate (int year, int month, int day)
	{
		setYear (year);
		setMonth (month);
		setDay (day);
	}


}