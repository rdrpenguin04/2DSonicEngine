package buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SelectorImageButton extends JButton {
	private static final long serialVersionUID = 1L;
	public boolean pressed = false;
	
	public SelectorImageButton(String id) throws MalformedURLException {
		super("",new ImageIcon(new File(new File(SelectorImageButton.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getParentFile().getPath()+File.separatorChar+"assets"+File.separatorChar+id).toURL()));
		init();
	}
	
	public SelectorImageButton(String id, ActionListener a) throws MalformedURLException {
		super("",new ImageIcon(new File(new File(SelectorImageButton.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getParentFile().getPath()+File.separatorChar+"assets"+File.separatorChar+id).toURL()));
		addActionListener(a);
		init();
	}
	
	private void init() {
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pressed = true;
			}
		});
	}
	
	public void disable() {
		pressed = false;
	}
}
