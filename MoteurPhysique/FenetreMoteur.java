package MoteurPhysique;

import java.awt.*;
import javax.swing.*;

public class FenetreMoteur extends JFrame {

	private static final long serialVersionUID = -2363514637681530964L;

	public class Panel extends JPanel {

		private static final long serialVersionUID = -8382277905282094694L;

		public void paintComponent(Graphics g) {

			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());

			for (int i = 0; i < t.f.size(); i++) {
				System.out.println(t.f.get(i));
				g.setColor(t.f.get(i).c);
				if (t.f.get(i) instanceof Cercle) {
					Cercle c = (Cercle) t.f.get(i);
					g.fillOval((int) (c.getX() - c.getRayon()), (int) (c.getY() - c.getRayon()),
							(int) (c.getRayon() * 2), (int) (c.getRayon() * 2));
				} else if (t.f.get(i) instanceof Polygone) {
					Polygone p = (Polygone) t.f.get(i);
					int[] xPoints = new int[p.getPoints().length];
					int[] yPoints = new int[p.getPoints().length];
					for (int k = 0; k < xPoints.length; k++) {
						xPoints[k] = (int) p.getPoints()[k].getX();
						yPoints[k] = (int) p.getPoints()[k].getY();
					}
					g.fillPolygon(xPoints, yPoints, xPoints.length);
				}
			}
		}

	}

	TestMoteur t;
	Panel p;

	public FenetreMoteur() {

		t = new TestMoteur();
		p = new Panel();

		this.setTitle("Animation");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(p);
		this.setVisible(true);

		play();

	}

	public void play() {
		int p = 0;
		while (true) {
			t.maj();
			repaint();
			if (p % 100 == 0 && p < 1000)
				t.add();
			p += 1;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
