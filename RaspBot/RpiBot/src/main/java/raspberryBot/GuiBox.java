package raspberryBot;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class GuiBox {

	private JFrame frmVersbot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiBox window = new GuiBox();
					window.frmVersbot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuiBox() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVersbot = new JFrame();
		frmVersbot.setTitle("Vers-Bot");
		frmVersbot.setIconImage(
				Toolkit.getDefaultToolkit().getImage(GuiBox.class.getResource("/resources/icon/NewerIcon.ico")));
		frmVersbot.setBounds(100, 100, 450, 300);
		frmVersbot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVersbot.getContentPane().setLayout(new BorderLayout(0, 0));

		JButton btnExitBot = new JButton("Exit Bot");
		btnExitBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frmVersbot.getContentPane().add(btnExitBot);

		JMenuBar menuBar = new JMenuBar();
		frmVersbot.setJMenuBar(menuBar);
		
		JMenu mnFiles = new JMenu("Files");
		menuBar.add(mnFiles);
		
		JButton btnGlobalEmotes = new JButton("Emotes");
		btnGlobalEmotes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnGlobalEmotes.setPreferredSize(new Dimension(100, 35));
		btnGlobalEmotes.setSize(new Dimension(100, 30));
		mnFiles.add(btnGlobalEmotes);
		
		JButton btnNewButton = new JButton("Logs");
		btnNewButton.setSize(new Dimension(100, 30));
		btnNewButton.setMaximumSize(new Dimension(100, 35));
		btnNewButton.setMinimumSize(new Dimension(100, 35));
		btnNewButton.setPreferredSize(new Dimension(100, 35));
		mnFiles.add(btnNewButton);

	}
}
