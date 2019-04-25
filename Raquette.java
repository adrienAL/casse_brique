package m2i.formation.java.jeux;

import java.awt.Color;
import java.awt.Graphics;

public class Raquette 
{
	//Caracteristique de la raquette
	public static final int LARGEUR = 50 ;
	public static final int HAUTEUR = 10 ;
	public static final int START_X = 200 ;
	public static final int START_Y = 430 ;
	
	//Attributs
	private int x, y;
	private Color couleur;
	private int vitesse = 10;
	
	//Constructeur
	public Raquette(Color couleur)
	{
		this.couleur = couleur;
		this.x = START_X;
		this.y = START_Y;
	}
	
	//Getteur et setteur
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	//Méthode
	public void draw(Graphics g)
	{
		g.setColor(couleur);
		g.fillRect(x, y, LARGEUR, HAUTEUR);
	}
	
	public void right()
	{
		this.x += vitesse;
		
	}
	
	public void left()
	{
		this.x -= vitesse;
	}
}
