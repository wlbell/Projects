package edu.ycp.cs201.cards;
import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.*;
public class Solapp extends JFrame
{
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		Solapp app = new Solapp();
		app.setSize(900, 600);
		Board panel = new Board();
		app.getContentPane().add(panel, BorderLayout.CENTER);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setTitle("Sol");
		app.setVisible(true);
	}
}
