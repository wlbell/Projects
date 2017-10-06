package edu.ycp.cs201.cards;

import java.awt.Image;
import java.awt.Toolkit;

public class Card implements Comparable<Card>
{
	private Rank rnk;
	private Suit st;
	public Card(Rank r, Suit s)
	{
		st = s;
		rnk= r;
	}
	public Suit getSuit()
	{
		return st;
	}
	public Rank getRank()
	{
		return rnk;
	}
	@Override
	public int compareTo(Card c) 
	{
		// TODO Auto-generated method stub
		int comp;
		comp = this.getSuit().compareTo(c.getSuit());
		if(comp != 0)
		{
			return comp;
		}
		comp = this.getRank().compareTo(c.getRank());
		if(comp != 0)
		{
			return comp;
		}
		return 0;
	}
	public boolean equals(Card c)
	{
		if (c == null || !(c instanceof Card)) 
		{
	      return false;
	    }
	    if (this.getRank() == c.getRank() && this.getSuit() == c.getSuit()) 
	    { 
	      return true;
	    } 
	    else 
	    {
	      return false;
	    }
	}
	public String toString()
	{
		return "\n" + this.getRank() +  "\n" +this.getSuit();
	}
	public String cardImg()
	{
		//Toolkit kit = Toolkit.getDefaultToolkit();
		String s = "Cards//" +this.getRank() + " " + this.getSuit()+ ".gif";
		//Image temp = kit.getImage(s);
		return s;
	}
	public static void main(String agrs[])
	{
		Card myCard = new Card(Rank.KING,Suit.DIMONDS);
		Card myOther = new Card(Rank.TWO, Suit.SPADES);
		//System.out.printf(myCard.toString());
		//System.out.printf(myOther.toString());
		System.out.print("\n" +myCard.cardImg());
		//int temp = myCard.compareTo(myOther);
		//System.out.printf("\n%d",temp);*/
	}
}
