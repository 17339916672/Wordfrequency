package words;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Scanner;

public class TongJiGaoPinCi 
{
	static Map<String, Integer> Map=MainWindows.hashMap;
	public static void tongjigaopinci()
	{
		String[] wuguanci = {"I", "me", "my","My", "mine", "myself", "we", "We", "us", 
				"our", "ours", "ourselves", "You", "you", "your", "yours", "yourself", "Yourselves",
				"He", "he", "him", "his", "himself", "she", "She", "her", "hers", "herself", 
				"It", "it", "its", "itself", "They",  "they", "them", "their", "theirs", "themselves",
				"a", "an", "the", "in", "on", "with", "by", "for", "at", "about", "under", "of",
				"into", "within", "throughout", "inside", "outside", "without", "from", "among", 
				"behind", "until","after", "according", "because", "front", "addition", "spite", "above",
				"considering", "regarding", "respecting", "including", "around", "across"};
		
		 Set<Entry<String,Integer>> mapEntries = Map.entrySet();   
		 boolean bz;
	     LinkedList<Entry<String, Integer>> List = new LinkedList<Entry<String,Integer>>(mapEntries); 
	     
	     // 根据映射的键对列表排序
	        Collections.sort(List, new Comparator<Entry<String,Integer>>() {  
	            @Override  
	            public int compare(Entry<String, Integer> ele1,  Entry<String, Integer> ele2) {  
	  
	                return ele2.getValue().compareTo(ele1.getValue());  
	            }  
	        });  
	  
	     
	     Map<String,Integer> Map2 = new LinkedHashMap<String, Integer>();  
	     for(Entry<String,Integer> entry: List) {  
	    	 Map2.put(entry.getKey(), entry.getValue());  
	     }    
	
	        File file = new File("result1.txt");
	        try {
	        	if(file.exists()) {
	        		file.createNewFile();
	        	}
	        	FileWriter fop = new FileWriter(file.getAbsoluteFile());
	        	for(Entry<String,Integer> entry : Map2.entrySet()) {
	        		bz=true;
	        		for(String s : wuguanci)
	        		{
	        			if(entry.getKey().equals(s))
	        			{
		        				bz=false;
		        				break;
	        			}
	        		}
	        		if(bz)fop.write(entry.getKey()+":\t"+entry.getValue()+"\n");
	        	}
	        	fop.close();
	        }catch(IOException e) {
	        	e.printStackTrace();
	        }
	  
	}
}
