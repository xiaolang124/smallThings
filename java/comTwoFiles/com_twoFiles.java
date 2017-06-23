package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class com_twoFiles {

	public static void main(String[] args) throws IOException{
		
		int same_num=0;
		int dif_num=0;
		
		FileInputStream file_1=new FileInputStream("D:/logs/1.txt");
		FileInputStream file_2=new FileInputStream("D:/logs/2.txt");
		
		HashSet<String> origin=new HashSet<String>();
		HashSet<String> dif_set=new HashSet<String>();
		
		InputStreamReader is=new InputStreamReader(file_1,"UTF-8");
		BufferedReader br=new BufferedReader(is);
		String str=null;
		
		while((str=br.readLine())!=null){
			origin.add(str);
		}
		
		is=new InputStreamReader(file_2,"UTF-8");
		br=new BufferedReader(is);
		str=null;
		
		while((str=br.readLine())!=null){
			if(origin.contains(str)){
				++same_num;
			}else{
				++dif_num;
				dif_set.add(str);
			}
		}
		
		System.out.println("same num : "+same_num);
		
		
		System.out.println("dif num : "+dif_num);
		for(String dif_str:dif_set){
			System.out.println(dif_str);
		}
		
	}
}
