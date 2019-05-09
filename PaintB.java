import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JPanel;
public class PaintB extends JPanel implements ActionListener,MouseListener{
	double size = 40;
	double ax =5,ay=5;
	double ax2 =0,ay2=0;
	double ax3 =0,ay3=0;
	double velocity = 15;
	int counter = 0;
	Ellipse2D.Double b = new Ellipse2D.Double(300,250,size,size);
	Ellipse2D.Double b2 = new Ellipse2D.Double(500,150,size,size);
	Ellipse2D.Double b3 = new Ellipse2D.Double(500,350,size,size);
	javax.swing.Timer tmr = new javax.swing.Timer(5, this);
	PaintB(){
		addMouseListener(this);
	}
	public void positionUpdater() {
		double difx = b2.x-b.x;
		double dify = b2.y-b.y;
		double Umagnitude = Math.hypot(difx, dify);
		b.x+= ax;
		b.y+=ay;
		b2.x+= ax2;
		b2.y+=ay2;
		b3.x+= ax3;
		b3.y+=ay3;
		/*if(b.x<30 ||b.x>getWidth()-size) {
			ax = -ax;
		}
		if(b.y<70 ||b.y>getHeight()-size) {
			ay = -ay;
		}
		if(b2.x<30 ||b2.x>getWidth()-size) {
			ax2 = -ax2;
		}
		if(b2.y<70 ||b2.y>getHeight()-size) {
			ay2 = -ay2;
		}
		if(b3.x<30 ||b3.x>getWidth()-size) {
			ax3 = -ax3;
		}
		if(b3.y<70 ||b3.y>getHeight()-size) {
			ay3 = -ay3;
		}*/
		if(b.x<30 ||b.x>690) {
			ax = -ax;
			counter++;
		}
		if(b.y<70 ||b.y>470) {
			ay = -ay;
			counter++;
		}
		if(b2.x<30 ||b2.x>690) {
			ax2 = -ax2;
		}
		if(b2.y<70 ||b2.y>470) {
			ay2 = -ay2;
		}
		if(b3.x<30 ||b3.x>690) {
			ax3 = -ax3;
		}
		if(b3.y<70 ||b3.y>470) {
			ay3 = -ay3;
		}
		if(Umagnitude <= b.width) {
			double Vrmagnitude = (ax*difx + ay*dify)/Umagnitude;
			double Vrx = Vrmagnitude * difx/Umagnitude;
			double Vry = Vrmagnitude * dify/Umagnitude;
			double Vtx = ax - Vrx;
			double Vty = ay - Vry;
			ax=Vtx;
			ay=Vty;
			ax2=Vrx;
			ay2=Vry;
		}
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		positionUpdater();
	}
	
@Override
public void paint(Graphics g) {
	super.paint(g);
	Graphics2D gr2d = (Graphics2D)g;
	gr2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	gr2d.setColor(Color.BLACK);
	gr2d.fillRect(10,50,20,480);
	gr2d.fillRect(20,50,730,60);
	gr2d.fillRect(730,50,20,480);
	gr2d.fillRect(30,470,700,60);
	gr2d.setColor(Color.GREEN);
	gr2d.fillRect(30,70, 700, 440);
	gr2d.setColor(Color.WHITE);
	gr2d.fill(b);
	gr2d.setColor(Color.RED);
	gr2d.fill(b2);
	gr2d.fill(b3);
	gr2d.setColor(Color.BLACK);
	gr2d.drawString( Menu.name + "'s score :  " + counter + "", 10, 10);
}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!tmr.isRunning()) {
			double x1 = e.getX();
			double y1 = e.getY();
			double x2 = b.x+b.width/2;
			double y2 = b.y+b.height/2;
			double dx = x2-x1;
			double dy = y2-y1;
			ax = velocity*dx/Math.sqrt(dx*dx+dy*dy);
			ay = velocity*dy/Math.sqrt(dx*dx+dy*dy);
			ax = -2;
			ay = -2;
			tmr.start();
		}	
	}

	@Override
	public void mousePressed(MouseEvent e) {		
	}
	@Override
	public void mouseReleased(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {	
	}
	@Override
	public void mouseExited(MouseEvent e) {	
	}
}
