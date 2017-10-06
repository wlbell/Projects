package edu.ycp.cs201.tictactoe;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class TicTacToe extends JFrame implements ActionListener
{
	private static JFrame frame = new JFrame();
	private static JButton yes= new JButton("Yes");
	private static JButton first = new JButton("1-Player");
	private	static JButton second = new JButton("2-Player");
	private static JButton no = new JButton("No");
	private static JPanel temp = new JPanel();
	private static JPanel panel1 = new JPanel();
	private static JLabel win = new JLabel();
	public TicTacToe()
	{	
		this.setSize(250,275);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("TicTacToe");
		temp.setVisible(true);
		first.setVisible(true);
		second.setVisible(true);
		first.addActionListener(this);
		second.addActionListener(this);
		temp.add(first);
		temp.add(second);
		//sets buttons to false on new instance
		yes.setVisible(false);
		no.setVisible(false);
		yes.addActionListener(this);
		no.addActionListener(this);
		this.add(temp);
		this.setVisible(true);
		
	}
	public static void playAgain(String s)//new jframe after win "yes or no"
	{
		frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		frame.setTitle("Continue?");
		win.setVisible(true);
		win.setLocation(25, 25);
		win.setText(s);
		panel1.add(win);
		no.setVisible(true);
		yes.setVisible(true);
		panel1.add(yes);
		panel1.add(no);
		frame.add(panel1);
		frame.setSize(150 ,125);
		frame.setLocation(50, 100);
		frame.setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == yes)//delete old jframes make new instance 
		{
			this.dispose();
			frame.dispose();
			new TicTacToe();
		}
		else if(e.getSource() == no)//delete jframes and close
		{
			this.dispose();
			frame.dispose();
		}
		else if(e.getSource() == first)
		{
			this.remove(temp);
			this.add(new PaintSurface(1), BorderLayout.CENTER);//calls paitsurface()
			this.setVisible(true);
		}
		else if(e.getSource() == second)
		{
			this.remove(temp);
			this.add(new PaintSurface(2), BorderLayout.CENTER);//calls paitsurface()
			this.setVisible(true);
		}
	}
	public static void main(String[] args) 
	{
		new TicTacToe();
	}
	
}
