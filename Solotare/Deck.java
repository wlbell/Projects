package edu.ycp.cs201.cards;
import java.util.ArrayList;
import java.util.Collections;
public class Deck 
{
	private ArrayList<Card> dk = new ArrayList<Card>();
	public Deck()
	{
		Suit[] allSuits = Suit.values();
		Rank[] allRanks = Rank.values();
		for(int x = 0; x< allSuits.length; x++)
		{
			for(int y = 0; y < allRanks.length;y++)
			{
				dk.add(new Card(allRanks[y], allSuits[x]));
			}
		}
	}
	public int getNumCards()
	{
		return dk.size();
	}
	public Card getCard(int i)
	{
		return dk.get(i);
	}
	public Card drawCard()
	{
		Card temp = dk.get(0);
		dk.remove(0);
		return temp;
	}
	public void suffle()
	{
		Collections.shuffle(this.dk);
	}
	public String toSting()
	{
		return "\n" + getCard(5).toString();
	}
	public static void main(String args[])
	{
		Deck d = new Deck();
		System.out.printf("%d" + d.toSting(), d.getNumCards());
		d.suffle();
		d.drawCard();
		System.out.printf("\n%d" + d.toSting(), d.getNumCards());
	}
}
