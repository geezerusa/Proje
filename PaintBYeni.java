import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JPanel;
public class PaintB extends JPanel implements ActionListener,MouseListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double size=40;
	double bx=2,by=2;
	double kx=0,ky=0;
	double sx=0,sy=0;
	double velocity=10;
	int score = 0;
	boolean isscored,c1,c2,c3 = false;
	int counter = 0;
	boolean stick = false;
	boolean mouse = false;
	Ellipse2D.Double beyaz= new Ellipse2D.Double(300,250,size,size);
	Ellipse2D.Double kýrmýzý = new Ellipse2D.Double(500,150,size,size);
	Ellipse2D.Double sarý = new Ellipse2D.Double(500,350,size,size);
	double mx;
	double my;
	javax.swing.Timer tmr = new javax.swing.Timer(10, this);
	PaintB(){
		addMouseListener(this);
	}
	public void positionUpdater() {
		double difx = beyaz.x - kýrmýzý.x;
		double dify = beyaz.y - kýrmýzý.y;

		double difx2 = kýrmýzý.x - beyaz.x;
		double dify2 = kýrmýzý.y - beyaz.y;
		
		double difx3 = beyaz.x - sarý.x;
		double dify3 = beyaz.y - sarý.y;
		
		double difx4 = sarý.x - beyaz.x;
		double dify4 = sarý.y - beyaz.y;
		
		double difx5 = kýrmýzý.x - sarý.x;
		double dify5 = kýrmýzý.y - sarý.y;
		
		double difx6 = sarý.x - kýrmýzý.x;
		double dify6 = sarý.y - kýrmýzý.y;
		
		double Emagnitude = Math.hypot(difx, dify);
		double Emagnitude2 = Math.hypot(difx2, dify2);
		double Emagnitude3 = Math.hypot(difx3, dify3);
		double Emagnitude4 = Math.hypot(difx4, dify4);
		double Emagnitude5 = Math.hypot(difx5, dify5);
		double Emagnitude6 = Math.hypot(difx6, dify6);
		
		if(beyaz.x<30 || beyaz.x>690) {
			bx = -bx;
			counter++;
		}
		if(beyaz.y<70 ||beyaz.y>470) {
			by = -by;
			counter++;
		}
		if(kýrmýzý.x<30 ||kýrmýzý.x>690) {
			kx = -kx;
		}
		if(kýrmýzý.y<70 ||kýrmýzý.y>470) {
			ky = -ky;
		}
		if(sarý.x<30 ||sarý.x>690) {
			sx = -sx;
		}
		if(sarý.y<70 ||sarý.y>470) {
			sy = -sy;
		}
		
		bx = bx*0.99;
		by = by*0.99;
		
		kx = kx*0.99;
		ky = ky*0.99;
		
		sx = sx*0.99;
		sy = sy*0.99;
		
		if(Math.pow(bx, 2) + Math.pow(by, 2) < 0.1 && Math.pow(kx, 2) + Math.pow(ky, 2) < 0.1 && Math.pow(sx, 2) + Math.pow(sy, 2) < 0.1) {
			bx = 0;
			by = 0;
			tmr.stop();
		}
		
		if(Math.hypot(bx, by)> Math.hypot(kx, ky)) {
			if(Emagnitude <= beyaz.width)
			{
			
				double VrMag = (bx*difx + by*dify )/ Emagnitude;
				double Vrx = VrMag * difx / Emagnitude;
				double Vry = VrMag * dify / Emagnitude;
			
				double Vtx = bx - Vrx;
				double Vty = by - Vry;
			
			
				bx = Vtx;
				by = Vty;
				kx = kx + Vrx;
				ky = ky + Vry;
				c1=true;
			}
		}
		
		else {
			if(Emagnitude2 <= kýrmýzý.width)
			{
			
				double VrMag2 = (kx*difx2 + ky*dify2 )/ Emagnitude2;
				double Vrx2 = VrMag2 * difx2 / Emagnitude2;
				double Vry2 = VrMag2 * dify2 / Emagnitude2;
			
				double Vtx2 = kx - Vrx2;
				double Vty2 = ky - Vry2;
			
			
				kx = Vtx2;
				ky = Vty2;
				bx = bx + Vrx2;
				by = by + Vry2;
				c1=true;
			}
		}
		if(Math.hypot(bx , by) > Math.hypot(sx, sy)) {
			if(Emagnitude3 <= beyaz.width)
			{
			
				double VrMag2 = (bx*difx3 + by*dify3 )/ Emagnitude3;
				double Vrx3 = VrMag2 * difx3 / Emagnitude3;
				double Vry3 = VrMag2 * dify3 / Emagnitude3;
			
				double Vtx3 = bx - Vrx3;
				double Vty3 = by - Vry3;
			
			
				bx = Vtx3;
				by = Vty3;
				sx = sx + Vrx3;
				sy = sy + Vry3;
				c2=true;
			}
		}
		
		else {
			if(Emagnitude4 <= sarý.width)
			{
			
				double VrMag4 = (sx*difx4 + sx*dify4 )/ Emagnitude4;
				double Vrx4 = VrMag4 * difx4 / Emagnitude4;
				double Vry4 = VrMag4 * dify4 / Emagnitude4;
			
				double Vtx4 = sx - Vrx4;
				double Vty4 = sy - Vry4;
			
			
				sx = Vtx4;
				sy = Vty4;
				bx = bx + Vrx4;
				by = by + Vry4;
				c2=true;
			}
		}
		
		if(Math.hypot(sx, sy) > Math.hypot(kx, ky)) {
			if(Emagnitude5 <= sarý.width)
			{
			
				double VrMag5 = (sx*difx5 + sy*dify5 )/ Emagnitude5;
				double Vrx5 = VrMag5 * difx5 / Emagnitude5;
				double Vry5 = VrMag5 * dify5 / Emagnitude5;
			
				double Vtx5 = sx - Vrx5;
				double Vty5 = sy - Vry5;
			
			
				sx = Vtx5;
				sy = Vty5;
				kx = kx + Vrx5;
				ky = ky + Vry5;
				c3=true;
			}
		}
		
		else {
			if(Emagnitude6 <= kýrmýzý.width)
			{
			
				double VrMag6 = (kx*difx6 + ky*dify6 )/ Emagnitude6;
				double Vrx6 = VrMag6 * difx6 / Emagnitude6;
				double Vry6 = VrMag6 * dify6 / Emagnitude6;
			
				double Vtx6 = kx - Vrx6;
				double Vty6 = ky - Vry6;
			
			
				kx = Vtx6;
				ky = Vty6;
				sx = sx + Vrx6;
				sy = sy + Vry6;
				c3=true;
			}
		}
		beyaz.x+=bx;
		beyaz.y+=by;
		
		kýrmýzý.x+=kx;
		kýrmýzý.y+=ky;
		
		sarý.x+=sx;
		sarý.y+=sy;
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
	gr2d.fill(beyaz);
	gr2d.setColor(Color.RED);
	gr2d.fill(kýrmýzý);
	gr2d.setColor(Color.YELLOW);
	gr2d.fill(sarý);
	gr2d.setColor(Color.BLACK);
	gr2d.drawString( Menu.name + "'s score :  " + score + "", 10, 10);
	/*	if(stick) {
		Line2D.Double Cue = new Line2D.Double(beyaz.getCenterX(),beyaz.getCenterY(),mx,my);
		gr2d.setColor(Color.black);
		gr2d.setStroke(new BasicStroke(5));
		gr2d.draw(Cue);
	}*/
	
}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!tmr.isRunning()) {
			double x1 = e.getX();
			double y1 = e.getY();
			double x2 = beyaz.x+beyaz.width/2;
			double y2 = beyaz.y+beyaz.height/2;
			double difx = x2-x1;
			double dify = y2-y1;
			bx = velocity*difx/Math.sqrt(Math.pow(difx, 2)+Math.pow(dify, 2));
			by = velocity*dify/Math.sqrt(Math.pow(difx, 2)+Math.pow(dify, 2));
			//bx = velocity*dx/Math.sqrt(dx*dx+dy*dy);
			//by = velocity*dy/Math.sqrt(dx*dx+dy*dy);
			
			tmr.start();
		}	
		//stick = true;
	}

	@Override
	public void mousePressed(MouseEvent e) {		
	}
	@Override
	public void mouseReleased(MouseEvent e) {	
		/*stick = false;
		mouse = false;
		bx =(mx-beyaz.getCenterX())*0.10;
		by=(my-beyaz.getCenterY())*0.10;*/
	}
	@Override
	public void mouseEntered(MouseEvent e) {	
		
	}
	@Override
	public void mouseExited(MouseEvent e) {	
	}
	@Override
	public void mouseDragged(MouseEvent e) {
/*	stick = true;
	mouse = true;
	mx = e.getX();
	my = e.getY();
	
	repaint();*/
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void scoreboard() {
		if(counter >=3 && c1&&c2 == true) {
			isscored = true;
			score+=10;
		}
		else {isscored = false;}
	}
}
