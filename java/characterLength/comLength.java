package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class comLength {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		zifu wzLength=new zifu();
		FileInputStream test=new FileInputStream("D:/logs/comfo.txt");
		
		InputStreamReader is=new InputStreamReader(test,"UTF-8");
		BufferedReader br=new BufferedReader(is);
		
		String str=null;
		
		while((str=br.readLine())!=null){
			System.out.println(str+"            "+wzLength.num(str));
		}
		
	}

}
