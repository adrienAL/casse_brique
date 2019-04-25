package m2i.formation.java.jeux;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import java.awt.Event;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class MonCasseBrique extends JPanel 
{
	//nombre de brique par lignes et colonnes
	public static final int NUM_BRIQUE_LIGNE = 10;
	public static final int NUM_BRIQUE_COLONNES = 20;
	
	//Attributs
	private ArrayList<Brique> briques = new ArrayList<Brique>();
	private Balle balle = new Balle(Color.red);
	private Raquette raquette = new Raquette(Color.blue);
	private Timer timer;
	
	
	//constructeur
	public MonCasseBrique() 
	{
		for(int i = 0 ; i<NUM_BRIQUE_LIGNE ; i++)
		{
			for(int j = 0 ; j < NUM_BRIQUE_COLONNES ; j++)
			{
				Random a = new Random();
				Random b = new Random();
				Random c = new Random();
				this.briques.add(new Brique(i, j, new Color(a.nextInt(250), b.nextInt(250), c.nextInt(250))));
			} 
		}
		// ????
		timer = new Timer(10, new ActionListener()
				{
			public void actionPerformed(ActionEvent e) {
				balle.move() ;
				for(int i = 0 ; i < briques.size() ; i++)
				{
					if(briques.get(i).getCouleur() == Color.white)
					{
						briques.remove(i);
					}
				}
				repaint () ;
				
				if(balle.interaction(raquette) == true)
				{
					balle.goUp();
					if(balle.interactionRight(raquette) == true)
							balle.goRight();
					else
						balle.goLeft();
				}
				
				for(int i = 0 ; i < briques.size() ; i++)
				{
					if(briques.get(i).interaction(balle) == true)
					{
						briques.get(i).setCouleur(Color.white);
						balle.goDown();
						if(briques.get(i).interactionRight(balle))
						{
							balle.goRight();
//							balle.goDown();
						}
						if(briques.get(i).interactionLeft(balle))
						{
							balle.goLeft();
							balle.goDown();
						}
					}
				}
				}
			});
		timer.start();
		
		
		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) { 
				if(e.getKeyChar() == 'd')
				{
					raquette.right();
				}
				if(e.getKeyChar() == 'q')
					raquette.left();
				repaint() ;
			}
		});
		setFocusable(true);
		// ????
		
	}
	
	//Surcharge de paintComponent
	public void paintComponent(Graphics g)
	{
		g.clearRect(0, 0, 336, 500); //efface en repaint tout en blanc
		for(int i = 0 ; i<briques.size() ; i++)
		{
			briques.get(i).draw(g);
		}
		balle.draw(g);
		raquette.draw(g);
	}
	

}
