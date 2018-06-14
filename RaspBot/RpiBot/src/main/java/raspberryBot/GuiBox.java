package raspberryBot;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class GuiBox {

	private JFrame frmVersbot;

	public static void main(String[] args) throws LoginException, RateLimitedException, InterruptedException, IOException {
		Bot.main(args);
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
		frmVersbot.setVisible(true);
		frmVersbot.setTitle("Vers-Bot");
		frmVersbot.setIconImage(
				Toolkit.getDefaultToolkit().getImage(GuiBox.class.getResource("/resources/icon/DoseyProfB8.png")));
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

		JMenu mnFolders = new JMenu("Folders");
		mnFolders.setActionCommand("Folders");
		menuBar.add(mnFolders);

		JButton btnLogs = new JButton("Logs");
		btnLogs.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnLogs.setHorizontalTextPosition(SwingConstants.CENTER);

		JMenuItem mntmLogs = new JMenuItem("Logs");
		mnFolders.add(mntmLogs);
		mntmLogs.addActionListener(new ActionListener() {
			File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
			String Basepath = jarDir.getAbsolutePath() + "/";
			String LogPath = Basepath + "Logs/";
			File LogDir = new File(LogPath);
			Desktop desktop = null;

			public void actionPerformed(ActionEvent e) {
				if (Desktop.isDesktopSupported()) {
					desktop = Desktop.getDesktop();
					try {
						desktop.open(LogDir);
					} catch (IOException f) {

					}
				} else {
					System.out.println("desktop is not supported");
				}
			}
		});
		mnFolders.add(mntmLogs);
		JMenuItem mntmEmotes = new JMenuItem("Emotes");
		mnFolders.add(mntmEmotes);
		mntmLogs.addActionListener(new ActionListener() {
			File jarDir = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath());
			String Basepath = jarDir.getAbsolutePath() + "/";
			String EmotePath = Basepath + "Emotes/";
			File EmoteDir = new File(EmotePath);

			public void actionPerformed(ActionEvent Emotes) {
				Desktop desktop = null;
				if (Desktop.isDesktopSupported()) {
					desktop = Desktop.getDesktop();
					try {
						desktop.open(EmoteDir);
					} catch (IOException e) {

					}
				} else {
					System.out.println("desktop is not supported");
				}
			}
		});
		mnFolders.add(mntmLogs);
	}
}
