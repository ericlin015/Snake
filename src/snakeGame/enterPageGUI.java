package snakeGame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class enterPageGUI extends JFrame {

	private JLayeredPane contentPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enterPageGUI frame = new enterPageGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public enterPageGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 190);
		contentPanel = new JLayeredPane();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		//content panel
	
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDifficulty.setBounds(10, 13, 102, 19);
		contentPanel.add(lblDifficulty);
		
		JRadioButton d1 = new JRadioButton("Slow");
		d1.setBounds(10, 39, 109, 23);
		contentPanel.add(d1);
		
		JRadioButton d2 = new JRadioButton("Medium");
		d2.setSelected(true);
		d2.setBounds(121, 39, 109, 23);
		contentPanel.add(d2);
		
		JRadioButton d3 = new JRadioButton("Crazy");
		d3.setBounds(232, 39, 109, 23);
		contentPanel.add(d3);
		
		JLabel lblCustomizedPlayer = new JLabel("Customization:");
		lblCustomizedPlayer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCustomizedPlayer.setBounds(10, 63, 165, 25);
		contentPanel.add(lblCustomizedPlayer);
		
		JLabel lblPlayer = new JLabel("Player1:");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayer.setBounds(10, 99, 65, 19);
		contentPanel.add(lblPlayer);
		
		JLabel lblPlayer_1 = new JLabel("Player2:");
		lblPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayer_1.setBounds(10, 124, 65, 19);
		contentPanel.add(lblPlayer_1);
		
		JButton btnHuman = new JButton("Human");
		btnHuman.setBounds(85, 99, 118, 23);
		contentPanel.add(btnHuman);
		
		JButton btnNewButton = new JButton("AI");
		btnNewButton.setBounds(85, 124, 117, 23);
		contentPanel.add(btnNewButton);
		
		JLabel lblDefaultBlack = new JLabel("Color: Black");
		lblDefaultBlack.setBounds(213, 103, 76, 14);
		contentPanel.add(lblDefaultBlack);
		
		JLabel lblDefaultRed = new JLabel("Color: Red");
		lblDefaultRed.setBounds(212, 128, 76, 14);
		contentPanel.add(lblDefaultRed);
	}
}
