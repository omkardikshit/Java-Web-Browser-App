import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main extends JFrame {

	private JTextField addressBar;
	private JEditorPane display;
	
	public Main(){
		super("Best Browser");
		
		addressBar = new JTextField("TYPE URL ONLY");
		addressBar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						loadCrap(event.getActionCommand());
					}
				});
		add(addressBar, BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener(){
					public void hyperlinkUpdate(HyperlinkEvent event){
						if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
							loadCrap(event.getURL().toString());
						}
					}
				}
		);
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(1366,768);
		setVisible(true);
	}
	
	private void loadCrap(String userText){
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e){
			System.out.println("Wrong");
		}
	}
	
}
	
