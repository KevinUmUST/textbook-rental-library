
/**
 * 
 * Starting class for TP-1
 * 
 * Feel free to add, modify, or delete any of the following code: it's just a
 * possible starting implementation
 *
 * @author eric
 *
 */

import java.util.ArrayList;

public class Patron
{
	private String name;
	private String patronID;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronID() {
		return patronID;
	}

	public void setPatronID(String patronID) {
		this.patronID = patronID;
	}

	public ArrayList<Copy> getCopiesOut() {
		return copiesOut;
	}

	public void setCopiesOut(ArrayList<Copy> copiesOut) {
		this.copiesOut = copiesOut;
	}

	private ArrayList<Copy> copiesOut;

	public Patron(String id, String name)
	{
		this.patronID = id;
		this.name = name;
		this.copiesOut = new ArrayList<Copy>();
	}

	public boolean checkCopyOut(Copy c)
	{
		if (!c.checkedOut())
		{
			c.setOutTo(this);
			copiesOut.add(c);
			return true;
		}
		else return false;
	}

	public boolean checkCopyIn(Copy c)
	{
		if(c.getOutTo().equals(this))
		{
			c.setOutTo(null);
			copiesOut.remove(c);
			return true;
		}
		else return false;
	}

	@Override
	public boolean equals(Object o)
	{
		return ((o instanceof Patron) && (((Patron) o).getPatronID() == this.patronID));
	}

	public String toString()
	{
		return "Patron ID: " + this.patronID + "\nName: " + this.name + 
				   "\nBooks Borrowing: " + copiesOut.toString();
	}

	// put test code in your main(), but realize it's not unit testing!

	public static void main(String[] args)
	{
		Patron p1 = new Patron("P47", "Eric");

		System.out.println(p1);

		Patron p2 = FakeDB.getPatron("P47");
		Copy c1 = FakeDB.getCopy("C1");
	}

}
