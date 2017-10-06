package edu.ycp.cs201.cards;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
public class Board extends JPanel
{
	private static final long serialVersionUID = 1L;
	public Board()
	{
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				handleMouseClick(e);
			}
		});
		
		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) 
			{
				handleMouseMove(e);
			}
		});
	}
	public Deck getMainDeck()
	{
		Deck temp = new Deck();
		temp.suffle();
		return temp;
	}
	protected void handleMouseMove(MouseEvent e) 
	{
		
	}
	protected void handleMouseClick(MouseEvent e) 
	{	
		repaint();
	}
	public void paint(Graphics g)
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image back = kit.getImage("Cards//back.GIF");
		Image img = kit.getImage(getMainDeck().drawCard().cardImg());
		//deck
		g.drawImage(img,100,0,100,150,this);
		g.drawImage(img,100,30,100,150,this);//30 on the y for overlap
		//top piles implement if's for when a card needs to be drawn here 
		g.drawImage(back,375,0,100,150,this);
		g.drawImage(back,500,0,100,150,this);
		g.drawImage(back,625,0,100,150,this);
		g.drawImage(back,750,0,100,150,this);
		//bottem plies implement for loop for this and overlap
		g.drawImage(back,0,200,100,150,this);
		for(int x = 0; x< 2; x++)
		{
			int y = 200;
			g.drawImage(img,125,y,100,150,this);
			y += 30;
		}
		g.drawImage(back,250,200,100,150,this);
		g.drawImage(back,375,200,100,150,this);
		g.drawImage(back,500,200,100,150,this);
		g.drawImage(back,625,200,100,150,this);
		g.drawImage(back,750,200,100,150,this);
		if(getMainDeck().getNumCards() > 0)
		{
			g.drawImage(back,0,0,100,150,this);
		}
		
	}
}

