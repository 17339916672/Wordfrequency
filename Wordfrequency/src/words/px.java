package words;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class px extends JPanel{
	static Map<String, Integer> Map=MainWindows.hashMap;
	public px()
	{
		this.setLayout(new BorderLayout());
		TextArea st =new TextArea();
		JTextField kt =new JTextField(10);
		JScrollPane js=new JScrollPane(st);
		js.setHorizontalScrollBarPolicy( 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		js.setVerticalScrollBarPolicy( 
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
		JButton en=new JButton("确认");
		JPanel j1=new JPanel();
		j1.add(kt);
		j1.add(en);
		this.add(j1,BorderLayout.NORTH);
		this.add(st,BorderLayout.CENTER);
		en.addActionListener(event ->{
			this.setVisible(true);
			String k=kt.getText();
	    	int n=Integer.parseInt(k);
	    	long date1=System.currentTimeMillis();
	        Set<Entry<String,Integer>> mapEntries = Map.entrySet();   
	        LinkedList<Entry<String, Integer>> List = new LinkedList<Entry<String,Integer>>(mapEntries);  
	  
	     // 根据映射的值对列表排序
	        Collections.sort(List, new Comparator<Entry<String,Integer>>() {  
	            @Override  
	            public int compare(Entry<String, Integer> ele1,  Entry<String, Integer> ele2) {  
	  
	                return ele2.getValue().compareTo(ele1.getValue());  
	            }  
	        });  
	  
	        // Storing the list into Linked HashMap to preserve the order of insertion.   
	        Map<String,Integer> Map2 = new LinkedHashMap<String, Integer>();  
	        for(Entry<String,Integer> entry: List) {  
	            Map2.put(entry.getKey(), entry.getValue());  
	        }  
	  
	        // 输入需要查看的词频最高的前K个单词
	        for(Entry<String,Integer> entry : Map2.entrySet()) {  
	            st.append(entry.getKey() + " - " + entry.getValue()+"\n");  
	            n--;
	            if(n<=0)	break;
	        } 
	        long date2=System.currentTimeMillis();
            long time1=date2-date1;
	       st.append("耗时:"+time1+"ms\n\n\n\n");
		});
		
	}

}
