package m2i.formation.java.jeux;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MaFrame extends JFrame 
{
	public static final int HAUTEUR = 500;
	public static final int LARGEUR = 336;
	public static final int POSITION_X = 50;
	public static final int POSITION_Y = 100;

	public MaFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(POSITION_X, POSITION_Y);
		setSize(LARGEUR, HAUTEUR);
		setResizable(false);
		setName(getName());
		setBackground(Color.white);
		
		MonCasseBrique casseBrique = new MonCasseBrique();
		add(casseBrique);
		
	}
	 
	
}
