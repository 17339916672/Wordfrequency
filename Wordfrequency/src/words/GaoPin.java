package words;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GaoPin extends JPanel{
	JButton en=new JButton("х╥хо");
	public GaoPin()
	{
		JPanel j=new JPanel();
		JTextField gaoping =new JTextField(15);
		this.setLayout(new BorderLayout());
		j.add(gaoping);
		j.add(en);
		this.add(j,BorderLayout.NORTH);
		en.addActionListener(event ->{
			WordQuery.s=gaoping.getText();
			WordQuery d=new WordQuery();
			this.add(d,BorderLayout.CENTER);
			d.setVisible(true); 
			this.repaint();
		});
	}
}
