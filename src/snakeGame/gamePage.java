package snakeGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;

import snakeGame.Snake.Direction;
import snakeGame.humanClass.myListener;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gamePage extends JFrame {

	private JPanel contentPane;
	public gameClass gameOn;
	public Timer timer;
	public boolean haha;
	private boolean isInitialPainted = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gamePage frame = new gamePage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void paint(Graphics g){
		if(!isInitialPainted){
			gameOn.paint(g);
		}else{
			gameOn.finalPaint(g);
		}
	}
	
	/**
	 * Create the frame.
	 */
	public gamePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650,330);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(100, 100, 650, 330));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true);
		gameOn = new gameClass(this);
		timer = new Timer(80, new myListener2());
        //timer.start();
	}

	 class myListener2 implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	repaint();
	        }
	  }
	
}
