package brickGamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Gamepanel extends JPanel implements KeyListener, ActionListener{
	private boolean play = false;
	private int score =0;
	
	private int totalBricks =21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX =300;
	
	private int ballposX =120;
	private int ballposY = 350;
	private int ballXdir =5;
	private int ballYdir =-2;
	
	public Gamepanel ()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay, this);
		timer.start();
	}
	 
public void paint(Graphics g)

{
	//background
	g.setColor(Color.black);
	g.fillRect(1, 1, 692, 592);
	
	
	//borders
	g.setColor(Color.YELLOW);
	g.fillRect(0, 0, 3, 592);
	g.fillRect(0, 0, 692, 3);
	g.fillRect(691, 0, 3, 592);

	//paddle
	g.setColor(Color.green);
	g.fillRect(playerX, 550, 100, 8);
	
	//ball
	g.setColor(Color.blue);
	g.fillOval(ballposX, ballposY, 20, 20);
	
	g.dispose();
	
}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if(playerX >=600)
			{
				playerX =600;
			}
			else
			{
				moveRight();
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(playerX <10)
			{
				playerX =10;
			}
			else
			{
				moveLeft();
			}
			
		}
		
		
	}
	
	public void moveRight()
	{
		this.play=true;
		this.playerX+=20;
	}
	
	public void moveLeft()
	{
		this.play=true;
		this.playerX-=20;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play)
		{
			ballposX+=ballXdir;
			if(ballposX > 692 )
			{
				ballposX-=ballXdir;
			}
		}
		repaint();
	}

}
