package words;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Scanner;


//显示用户需要查询的若干个单词的词频
public class WordQuery extends JPanel{
	static String[] word;
	static int[] num;
	static int max=0;
	static String s;
	static Map<String, Integer> Map=MainWindows.hashMap;
	
	public WordQuery(){
		Map<String, Integer> map2 = new HashMap<String, Integer>();
        word = s.split(" ");
        int length = word.length;
        num = new int[length];
        int i;
        for(i=0; i<word.length; i++) {
        	for(Entry<String,Integer> entry : Map.entrySet()) { 
        		if(entry.getValue()>max)
        		{
        			max = entry.getValue();
        		}
        		if(word[i].equals(entry.getKey()))
        		{
        			num[i] = entry.getValue();
        			System.out.println(entry.getKey() + ":\t " + entry.getValue()+ num[i]); 
        			map2.put(entry.getKey(), entry.getValue());
        			break;
        		}
             } 
        }
	//	setBounds(400, 200, 450, 450);
		this.setVisible(true);
	}
	public void paint(Graphics g){
		int Width = getWidth();
		int Height = getHeight();
		int leftMargin = 50;//柱形图左边界
		int topMargin = 50;//柱形图上边界
		Graphics2D g2 = (Graphics2D) g;
		int ruler = Height-topMargin;
		int rulerStep = ruler/20;//将当前的高度评分为20个单位
		g2.setColor(Color.gray);//绘制灰色背景
		g2.fillRect(0, 0, Width, Height);//绘制矩形图
		g2.setColor(Color.BLACK);
		for(int i=0;i<rulerStep;i++){
			g2.drawString((max-max/20*i)+"", 8, topMargin+rulerStep*i);//绘制Y轴上的数据
		}
		g2.setColor(Color.green);
		int m=0;
		for(int i = 0;i<word.length;i++){
			int value = num[i]/20;
			int step = (m+1)*40;//设置每隔柱形图的水平间隔为40
			g2.fillRoundRect(leftMargin+step*2,Height-value, 40, value, 0, 0);//绘制每个柱状条
			
			m++;
		}
		
		m=0;
		for(int i = 0;i<word.length;i++){
			int step = (m+1)*40;//设置每隔柱形图的水平间隔为40
			int value = num[i]/10;
			g2.setColor(Color.BLACK);
			g2.drawString(word[i], leftMargin+step*2, Height-topMargin+40);
			g2.drawString(num[i]+"", leftMargin+step*2, Height-value-5);	//标识每个柱状条	
			m++;
		}
	}
}
