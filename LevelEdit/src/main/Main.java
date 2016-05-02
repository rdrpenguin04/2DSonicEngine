package main;

import java.awt.FlowLayout;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import buttons.SelectorImageButton;

public class Main extends JFrame {
	public Main() throws MalformedURLException {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setLayout(new FlowLayout());
		add(new SelectorImageButton("00.png"));
		setTitle("Level Editor");
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        try {
					new Main();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		});
	}
}
