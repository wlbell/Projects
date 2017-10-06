package edu.ycp.cs201.tictactoe;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class PaintSurface extends JComponent 
{
	private static LinkedList<Integer> XandO = new LinkedList<Integer>();
	private static LinkedList<Integer> xpos = new LinkedList<Integer>();
	private static LinkedList<Integer> ypos = new LinkedList<Integer>();
	private static int num;
	private static int ClickCount;//detriments weather x or o 
	///Linkedlist constructors
	public static LinkedList<Integer> XO()
	{
		LinkedList<Integer> temp = new LinkedList<Integer>();
		for(int x=0;x<9;x++)
		{
			temp.add(x,0);
		}
		return temp;
	}
	public static LinkedList x()
	{
		LinkedList<Integer> temp = new LinkedList<Integer>();		
		for(int x=0; x<9;x++)//sets the x positon of a piece
		{
			if(x<3)
			{
				temp.add(x,75);
			}
			else if(x<6 && x>=3)
			{
				temp.add(x,125);
			}
			else
			{
				temp.add(x,175);
			}
			
		}
		return temp;
		
	}
	public static LinkedList y()
	{
		LinkedList<Integer> temp = new LinkedList<Integer>();		
		int y = 75;
		for(int x=0; x<9;x++)//sets y position of piece 
		{
			if(y==225)
			{
				y = 75;
				x--;
			}
			else
			{
				temp.add(x,y);
				y+=50;
			}
			
		}
		return temp;
	}
	public PaintSurface(int a)
	{
		XandO = XO();
		xpos = x();
		ypos= y();
		ClickCount = 0;
		num = a;
		this.addMouseListener(new MouseListener()//mouse clicked for user input
		{
			public void mouseClicked(MouseEvent e)
			{	if(win() == 0)
				{
					if(e.getX() <100 && e.getY() <100 && e.getX()>50 && e.getY() >50)
					{
						ClickCount++;
						setPOS(0);
						repaint();
					}
					else if(e.getX() <100 && e.getY() <150 && e.getX()>50 && e.getY() >100)
					{
						ClickCount++;
						setPOS(1);
						repaint();
					}
					else if(e.getX() <100 && e.getY() <200 && e.getX()>50 && e.getY() >100)
					{
						ClickCount++;
						setPOS(2);
						repaint();
					}
					else if(e.getX() <150 && e.getY() <100 && e.getX()>50 && e.getY() >50)
					{
						ClickCount++;
						setPOS(3);
						repaint();
					}
					else if(e.getX() <150 && e.getY() <150 && e.getX()>100 && e.getY() >100)
					{
						ClickCount++;
						setPOS(4);
						repaint();
					}
					else if(e.getX() <150 && e.getY() <200 && e.getX()>100 && e.getY() >150)
					{
						ClickCount++;
						setPOS(5);
						repaint();
					}
					else if(e.getX() <200 && e.getY() <100 && e.getX()>150 && e.getY() >50)
					{
						ClickCount++;
						setPOS(6);
						repaint();
					}
				
					else if(e.getX() <200 && e.getY() <150 && e.getX()>150 && e.getY() >100)
					{
						ClickCount++;
						setPOS(7);
						repaint();
					}
					else if(e.getX() <200 && e.getY() <200 && e.getX()>150 && e.getY() >150)
					{
						ClickCount++;
						setPOS(8);
						repaint();
					}
				}
			else if(win()==3 || win() ==12)
			{
				return;
			}
		}	
			//unused
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public static int block()//not very pritty but part of AI that blocks player from win
	{
		int one = XandO.get(0) + XandO.get(1) + XandO.get(2);
		int two = XandO.get(3) + XandO.get(4) + XandO.get(5);
		int three = XandO.get(6) + XandO.get(7) + XandO.get(8);
		int four = XandO.get(0) + XandO.get(3) + XandO.get(6);
		int five = XandO.get(2) + XandO.get(5) + XandO.get(8);
		int six = XandO.get(0) + XandO.get(4) + XandO.get(8);
		int seven = XandO.get(2) + XandO.get(4) + XandO.get(6);
		int eight = XandO.get(1) + XandO.get(4) + XandO.get(7);
		
		if(one == 2)
		{
			for(int x = 0; x < 3; x++)
			{
				if(XandO.get(x) ==0)
				{
					return x;
				}
			}
		}
		else if(two == 2)
		{
			for(int x = 3; x < 6; x++)
			{
				if(XandO.get(x) ==0)
				{
					return x;
				}
			}
		}
		else if(three == 2)
		{
			for(int x = 6; x < 9; x++)
			{
				if(XandO.get(x) ==0)
				{
					return x;
				}
			}
		}
		else if(four == 2)
		{
			for(int x = 0; x < 6; x+=3)
			{
				if(XandO.get(x) ==0)
				{
					return x;
				}
			}
		}
		else if(five == 2)
		{
			for(int x = 2; x < 9; x+=3)
			{
				if(XandO.get(x) ==0)
				{
					return x;
				}
			}
		}
		else if(six == 2)
		{
			for(int x = 0; x < 9; x+=4)
			{
				if(XandO.get(x) ==0)
				{
					return x;
				}
			}
		}
		else if(seven == 2)
		{
			for(int x = 2; x < 7; x+=2)
			{
				if(XandO.get(x) ==0)
				{
					return x;
				}
			}
		}
		else if(eight == 2)
		{
			for(int x = 1; x < 8; x+=3)
			{
				if(XandO.get(x) ==0)
				{
					return x;
				}
			}
		}
		return 9;
	}
	public static void setPOS(int index)//sets the the positon of the clicked area also x and y positons
	{
		if(num == 2)//for 2 players
		{
			if(ClickCount % 2 == 1 && XandO.get(index)==0)
			{
				XandO.set(index,1);
			}
			else if (ClickCount % 2 ==0 && XandO.get(index)==0)
			{
				XandO.set(index,4);
			}
		}
		else if(num == 1)
		{
			if(ClickCount % 2 == 1 && XandO.get(index)==0)
			{
				XandO.set(index,1);
				ClickCount ++;
			}
			//AI for computer
			if(block() != 9)
			{
				XandO.set(block(),4);
			}
			else if(block() ==9)
			{
				
				if(XandO.get(4) == 0)
				{
					XandO.set(4,4);
				}
				else if(XandO.get(3) == 0)
				{
					XandO.set(3, 4);
				}
				else if(XandO.get(6)==0)
				{
					XandO.set(6,4);
				}
				else if(XandO.get(7) ==0)
				{
					XandO.set(7, 4);
				}
				else if(XandO.get(0) == 0)
				{
					XandO.set(0, 4);
				}
				else if(XandO.get(1) == 0)
				{
					XandO.set(1, 4);
				}
				else if(XandO.get(2) == 0)
				{
					XandO.set(2, 4);
				}
				else if(XandO.get(5)==0)
				{
					XandO.set(5, 4);
				}
				else if(XandO.get(8)==0)
				{
					XandO.set(8,4);
				}
			}
			
		}
	}
	public static int win()//checks the board to see if player wins or is a draw
	{
		int one = XandO.get(0) + XandO.get(1) + XandO.get(2);
		int two = XandO.get(3) + XandO.get(4) + XandO.get(5);
		int three = XandO.get(6) + XandO.get(7) + XandO.get(8);
		int four = XandO.get(0) + XandO.get(3) + XandO.get(6);
		int five = XandO.get(2) + XandO.get(5) + XandO.get(8);
		int six = XandO.get(0) + XandO.get(4) + XandO.get(8);
		int seven = XandO.get(2) + XandO.get(4) + XandO.get(6);
		int eight = XandO.get(1) + XandO.get(4) + XandO.get(7);
		if( one == 3 || one == 12 )
		{
			return one;
		}
		else if( two ==3 || two == 12 )
		{
			return two;
		}
		else if(three == 3 || three == 12 )
		{
			return three;
		}
		else if(four == 3 || four == 12 )
		{
			return four;			
		}
		else if( five == 3 || five == 12 )
		{
			return five;
		}
		else if( six == 3 || six == 12 )
		{
			return six;
		}
		else if(seven == 3 || seven == 12)
		{
			return seven;
		}
		else if (eight == 3 || eight == 12 )
		{
			return eight;
		}
		else 
		{
			int temp=0;
			for(int x = 0; x<XandO.size();x++)
			{
				temp = temp+XandO.get(x);
			}
			if(temp ==21)
			{
				return 10;
			}
			else{return 0;}
		}
		
	}
	public void paint(Graphics g)//paint the board
	{
		Graphics2D g2 = (Graphics2D)g; 
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.BLACK);
		g2.drawLine(100,50,100,200);//left
		g2.drawLine(50,100,200,100);//top
		g2.drawLine(150,50,150,200);//right
		g2.drawLine(50,150,200,150);//bottom
		for(int x = 0;x < XandO.size();x++)//draws pieces
		{
			if(XandO.get(x).equals(1) && win()==0)
			{
				g2.drawString("X",xpos.get(x),ypos.get(x));
			}
			else if(XandO.get(x).equals(4) && win() ==0)
			{
				g2.drawString("O", xpos.get(x),ypos.get(x));
			}
			else if(XandO.get(x).equals(1) && win() ==0)
			{
				g2.drawString("X",xpos.get(x),ypos.get(x));
			}
			else if(XandO.get(x).equals(4) && win() ==0)
			{
				g2.drawString("O", xpos.get(x),ypos.get(x));
			}
		}
		if(win() == 3)
		{
			TicTacToe.playAgain("You Win! Play Again?");
			
		}
		else if(win() == 12)
		{
			TicTacToe.playAgain("You Lose! Play Again?");
		}
		else if(win() == 10)
		{
			TicTacToe.playAgain("It's a Draw! Play Again?");
		}
	}
}
