package snakeGame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

public class InstructionPage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPlayerUses;
	private JTextField txtPlayerUses_1;
	private JTextField txtDontHitOther;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InstructionPage dialog = new InstructionPage();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InstructionPage() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Instruction:");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(152, 11, 133, 25);
			contentPanel.add(lblNewLabel);
		}
		{
			txtPlayerUses = new JTextField();
			txtPlayerUses.setText("Player 1 uses A,W,S,D to control");
			txtPlayerUses.setBounds(32, 41, 352, 25);
			contentPanel.add(txtPlayerUses);
			txtPlayerUses.setColumns(10);
		}
		{
			txtPlayerUses_1 = new JTextField();
			txtPlayerUses_1.setText("Player 2 uses arrow keys to control");
			txtPlayerUses_1.setColumns(10);
			txtPlayerUses_1.setBounds(32, 64, 352, 25);
			contentPanel.add(txtPlayerUses_1);
		}
		{
			txtDontHitOther = new JTextField();
			txtDontHitOther.setText("DON'T HIT OTHER PLAYER! OR YOU LOSE!");
			txtDontHitOther.setBounds(32, 130, 352, 25);
			contentPanel.add(txtDontHitOther);
			txtDontHitOther.setColumns(10);
		}
		{
			JLabel lblCaution = new JLabel("Caution:");
			lblCaution.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblCaution.setForeground(Color.RED);
			lblCaution.setBounds(152, 100, 115, 25);
			contentPanel.add(lblCaution);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Exit");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
