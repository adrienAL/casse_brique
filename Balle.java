package m2i.formation.java.jeux;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Balle 
{
	//Caracteristique de la balle
	public static final int TAILLE = 10;
	public static final int START_X = 200;
	public static final int START_Y = 400;
	
	//Attributs
	private int x, y;
	private Color couleur;
	private int dx = 1, dy = -1;
	
	//Constructeur
	public Balle(Color couleur) {
		super();
		this.couleur = couleur;
		this.x = START_X;
		this.y = START_Y;
	}
	
	//Getteur et Setteur
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
		g.fillOval(this.x, this.y, TAILLE, TAILLE);
	}

	public void move()
	{
		this.x += dx;
		this.y += dy;
		
		if(this.y == 0 || this.dy == 300)
		{
			dy=-dy;
		}
		else if(this.x == 315 || this.x == 0)
		{
			dx=-dx;
		}
	}
	
	public void goUp()
	{
		this.dy = -dy;
	}
	
	public void goDown()
	{
		this.dy = -dy;
	}
	
	public void goRight()
	{
		this.dx = Math.abs(dx);
	}
	
	public void goLeft()
	{
		this.dx = -Math.abs(dx);
	}
	
	public boolean interaction(Raquette r)
	{
		Rectangle2D.Double rectangleVirtuel = new Rectangle2D.Double(r.getX(), r.getY(), r.LARGEUR, r.HAUTEUR);
		return rectangleVirtuel.contains(x, y+7);
	}
	
	public boolean interactionRight(Raquette r)
	{
		Rectangle2D.Double rectangleVirtuel = new Rectangle2D.Double(r.getX()+r.LARGEUR/2, r.getY(), r.LARGEUR, r.HAUTEUR);
		return rectangleVirtuel.contains(x, y+7);
	}
	
	//A suprimer
	public boolean interactionLeft(Raquette r)
	{
		Rectangle2D.Double rectangleVirtuel = new Rectangle2D.Double(r.getX(), r.getY(), r.LARGEUR/2, r.HAUTEUR);
		return rectangleVirtuel.contains(x, y+7);
	}
	
	
}
