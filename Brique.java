package m2i.formation.java.jeux;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class Brique 
{
	//dimention des briques
	public static final int HAUTEUR = 10;
	public static final int LARGEUR = 30;
	
	//espace entre les briques
	public static final int BRIQUE_H_ESPACE = 2;
	public static final int BRIQUE_V_ESPACE = 2;
	
	//Attributs
	private int x, y;
	private Color couleur;
	
	//Constructeur
	public Brique(int x, int y, Color couleur) {
		super();
		this.x = ((x+1) * BRIQUE_V_ESPACE) + (x * LARGEUR);
		this.y = ((y+1) * BRIQUE_H_ESPACE) + (y * HAUTEUR);
		this.couleur = couleur;
	} 
	
	//toString pour vérification
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Brique [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", couleur=");
		builder.append(couleur);
		builder.append("]");
		return builder.toString();
	}
	
	//Méthode
	public void draw(Graphics g)
	{
		g.setColor(couleur);
		g.fillRect(this.x, this.y, LARGEUR, HAUTEUR);
	}
	
	//interaction avec la balle
	public boolean interaction(Balle b)
	{
		Rectangle2D.Double rectangleVirtuel = new Rectangle2D.Double(x, y, LARGEUR, HAUTEUR);
		return rectangleVirtuel.contains(b.getX(), b.getY());
	}
	
	public boolean interactionRight(Balle b)
	{
		Rectangle2D.Double rectangleVirtuel = new Rectangle2D.Double(x, y+LARGEUR-1, LARGEUR, HAUTEUR);
		return rectangleVirtuel.contains(b.getX(), b.getY());
	}
	
	public boolean interactionLeft(Balle b)
	{
		Rectangle2D.Double rectangleVirtuel = new Rectangle2D.Double(x, y, 1, HAUTEUR);
		return rectangleVirtuel.contains(b.getX(), b.getY());
	}

	//Setteur et getteur
	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

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
	
	
	
}
