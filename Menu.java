import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Menu extends JFrame implements ActionListener {
	GridLayout g;
	JLabel plbl;
	protected JTextArea ptxt;
	JButton pbutton;
	JButton cbutton;
	JButton clrbutton;
	static String name;
	public void Form() {
		g = new GridLayout(5, 2);
		setLayout(g);
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
			
		plbl = new JLabel(" Player Name : ");
		ptxt = new JTextArea();
		pbutton = new JButton("Let's Play");
		pbutton.addActionListener(this);
		clrbutton = new JButton("Clear");
		clrbutton.addActionListener(this);
		cbutton = new JButton("Cancel");
		cbutton.addActionListener(this);
		
		
		
		add(plbl);
		add(ptxt);
		add(pbutton);
		add(clrbutton);
		add(cbutton);
		
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == clrbutton) {
			ptxt.setText("");
		}
		if(a.getSource() == cbutton) {
			setVisible(false);
		}
		if(a.getSource() == pbutton) {
			name = ptxt.getText();
		setVisible(false);
		JFrame jf = new JFrame("Game Screen");
		PaintB ball = new PaintB();
		jf.add(ball);
		jf.setSize(800,800);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
		}