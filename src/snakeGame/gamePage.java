package snakeGame;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;

import snakeGame.Snake.Direction;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePage extends JFrame {

	private JPanel contentPane;
	Graphics bufferGraphics;
	Image bufferImage;
	public Game gameOn;
	public Timer timer;
	private boolean isInitialPainted = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePage frame = new GamePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void paint(Graphics g){
		bufferImage = createImage(this.getWidth(),this.getHeight());
		bufferGraphics = bufferImage.getGraphics();
		gameOn.init(bufferGraphics);
		if(!isInitialPainted){
			gameOn.init(bufferGraphics);
			isInitialPainted = true;
		}else{
			gameOn.paint(bufferGraphics);
		}	
		g.drawImage(bufferImage,0,0,this);
	}
	
	/**
	 * Create the frame.
	 */
	public GamePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650,330);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(100, 100, 650, 330));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		
		gameOn = new Game();
		timer = new Timer(30, new myListener2());
        timer.start();
        addKeyListener(new myListener());
        //repaint();
	}

	class myListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			gameOn.keyPressed(e);
		}
	}
	
	 class myListener2 implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	repaint();
	        }
	  }
	
}
