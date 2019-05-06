package m2i.formation.java.jeux;

import java.awt.Color;

public class Principale {

	public static void main(String[] args) 
	{
		MaFrame frame =new MaFrame();
		frame.setVisible(true);
		
		
		Brique brique = new Brique(0, 1, Color.black);
		System.out.println(brique);
	
	}

}
