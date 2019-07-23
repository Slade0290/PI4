package MoteurPhysique;

import java.util.ArrayList;
import java.awt.Color;

public class TestMoteur {

	ArrayList<Figure> f;

	public TestMoteur() {
		f = new ArrayList<Figure>();
	}

	public void add() {
		int r = (int) (Math.random() * 3);
		//Deplacement coord = new Deplacement((int) (Math.random() * 500), 0, 0.5);
		Deplacement coord = new Deplacement(Math.random() * 500, 0,
				Math.random() * 2, 3, Math.random(), 0, 0.1);
		switch (r) {
		case 0:
			f.add(new Cercle(30, new Color((int)(Math.random() * 256),
					(int)(Math.random() * 256),(int)(Math.random() * 256)), coord));
			break;
		case 1:
			f.add(new PolyReg(30, 3, new Color((int)(Math.random() * 256),
					(int)(Math.random() * 256),(int)(Math.random() * 256)), coord));
			break;
		case 2:
			f.add(new PolyReg(30, 4, new Color((int)(Math.random() * 256),
					(int)(Math.random() * 256),(int)(Math.random() * 256)), coord));
		}
	}

	public void addLeger() {
		Deplacement coord = new Deplacement(Math.random() * 500, 0,
				Math.random() * 2, 3, Math.random(), 0, 0.1);
		f.add(new Cercle(50, new Color((int)(Math.random() * 256),
				(int)(Math.random() * 256),(int)(Math.random() * 256)), coord));
	}
	
	public void addLourd() {
		Deplacement coord = new Deplacement(Math.random() * 500, 0,
				Math.random() * 2, 3, Math.random(), 0, 100);
		f.add(new Cercle(50, new Color((int)(Math.random() * 256),
				(int)(Math.random() * 256),(int)(Math.random() * 256)), coord));
	}
	
	public void maj() {
		for (int i = 0; i < f.size(); i++) {
			Figure fig = f.get(i);
			for (int j = i + 1; j < f.size(); j++) {
				Figure fig2 = f.get(j);
				if (fig.enCollision(fig2))
					fig.collision(fig2);
			}
		}
		for (Figure fig : f)
			fig.move();
	}

	public static void main(String[] args) {
		//FenetreMoteur f = new FenetreMoteur();
		
		/*
		Cercle c = new Cercle (10, Color.BLUE, null);
		Cercle c2 = new Cercle (10, Color.BLUE, null);
		PolyReg pr = new PolyReg(10, 3, Color.BLUE, null);
		PolyReg pr2 = new PolyReg(10, 3, Color.BLUE, null);
		System.out.println(c.equals(c2));
		System.out.println(c.equals(pr2));
		System.out.println(pr.equals(c2));
		System.out.println(pr.equals(pr2));
		*/
		
		Point a = new Point(0, 0);
		Point b = new Point(0, 5);
		Point c = new Point(-3, 6);
		Point d = new Point(4, 6);
		Point[] pts = {a, b, c, d};
		Point e = new Point(0, 0);
		Point f = new Point(3, 7);
		Point g = new Point(5, 3);
		Point h = new Point(4, -3);
		Point[] pts2 = {e, f, g, h};
		Point i = new Point(0, 0);
		Point j = new Point(3, -3);
		Point k = new Point(5, 0);
		Point l = new Point(8, -3);
		Point m = new Point(8, 2);
		Point n = new Point(7, 1);
		Point o = new Point(2, 2);
		Point[] pts3 = {i, j, k ,l, m, n, o};
		Point[] pts4 = {new Point(0,0)};
		/*
		PolyJoueur p = new PolyJoueur(pts3, new Deplacement(0, 0, 0));
		for (Point pt : p.getPoints())
			System.out.println(pt);
		System.out.println(Polygone.estConvexe(p));
		*/
		
		PolyJoueur pj = new PolyJoueur();
		pj.miseAJour(pts);
		pj.miseAJour(pts2);
		pj.miseAJour(pts3);
		pj.miseAJour(pts4);
	}

}
