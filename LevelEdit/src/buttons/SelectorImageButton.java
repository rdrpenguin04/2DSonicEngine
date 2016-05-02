package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import sun.util.logging.resources.logging_es;

public class SelectorImageButton extends JButton {
	String id;
	private static final long serialVersionUID = 1L;
	public boolean pressed = false;
	
	public SelectorImageButton(String id) throws MalformedURLException {
		super("",new ImageIcon(new File(new File(SelectorImageButton.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getParentFile().getPath()+File.separatorChar+"assets"+File.separatorChar+id).toURL()));
		this.id = id;
		init();
	}
	
	public SelectorImageButton(String id, ActionListener a) throws MalformedURLException {
		super("",new ImageIcon(new File(new File(SelectorImageButton.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getParentFile().getPath()+File.separatorChar+"assets"+File.separatorChar+id).toURL()));
		this.id = id;
		addActionListener(a);
		init();
	}
	
	private void init() {
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				final SelectorImageButton me = (SelectorImageButton) e.getSource();
				me.pressed=true;
				me.setBorder(BorderFactory.createLoweredBevelBorder());
			}
		});
		setActionCommand(id);
		setBorder(BorderFactory.createRaisedBevelBorder());
	}
	
	public void disable() {
		pressed = false;
		setEnabled(true);
		setBorder(BorderFactory.createRaisedBevelBorder());
	}
}
