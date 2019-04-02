package words;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class OneWindows extends JFrame{
	public OneWindows()
	{
		this.setLayout(new BorderLayout());
		JPanel noth=new JPanel();
		noth.setLayout(new GridLayout(1,4));
		JButton b1=new JButton("功能信息");
		JButton b2=new JButton("降序排序");
		JButton b3=new JButton("查询单词");
		JButton b4=new JButton("保存退出");
		noth.add(b1);
		noth.add(b2);
		noth.add(b3);
		noth.add(b4);
		noth.setVisible(true);
		this.add(noth,BorderLayout.NORTH);
		
		
		
		ChuLi c=new ChuLi();
		this.add(c,BorderLayout.CENTER);
		c.setVisible(true);
		GaoPin g=new GaoPin();
		px p=new px();
		
		
		b1.addActionListener(event ->{
			this.add(c,BorderLayout.CENTER);
			c.setVisible(true);
			g.setVisible(false);
			p.setVisible(false);
		});
		b2.addActionListener(event ->{
			this.add(p,BorderLayout.CENTER);
			p.setVisible(true);
			g.setVisible(false);
			c.setVisible(false);
		});
		b3.addActionListener(event ->{
			this.add(g,BorderLayout.CENTER);
			g.setVisible(true);
			c.setVisible(false);
			p.setVisible(false);
		});
		b4.addActionListener(event ->{
			g.setVisible(false);
			c.setVisible(false);
			p.setVisible(false);
			TongJiGaoPinCi.tongjigaopinci();
			SortMapByKeys.sortMapByKeys();
			JOptionPane.showMessageDialog(null, "已经将全部单词按字典顺序保存reuslt.txt中\n"
					+ "将除了介词、代词、冠词以外的其他词按照词频高低存放到result.txt中\n"
					, "保存", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		});
	}
	      
}
