package test;

public class zifu {
	
	public int num(String str){
		
		int tsCount = 0;  
	    int szCount = 0;  
	    int zmCount = 0;
	    int wzCount = 0;
	    for (int i = 0; i < str.length(); i++) {  
	        char c = str.charAt(i);  
	        if (c >= '0' && c <= '9') {  
	            szCount++;  
	        }else if((c >= 'a' && c<='z') || (c >= 'A' && c<='Z')){  
	            zmCount++;  
	        }else if(c==' '||c=='-'||c=='.'||c=='_'){  
	            tsCount++;  
	        }else{
	        	wzCount++;
	        }
	    }  

		return szCount+zmCount+tsCount+3*wzCount;
	}  
}
