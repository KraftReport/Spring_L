package com.kraft.zymal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZymalApplication {

	public static List<Integer> getRow(int rowIndex) {

		
		var result = new ArrayList<List<Integer>>();
		
		for(int i = 0 ; i <= rowIndex; i++) {
			
			var list = new ArrayList<Integer>();
			
			list.add(1);
			
			if(i > 0) {
				
				var prevList = result.get(i-1);
				
				for(int j = 1 ; j < prevList.size(); j++) {
					list.add(prevList.get(j-1)+prevList.get(j));
				}
				
				list.add(1);
			}
			
			result.add(list);
		}
		
		return result.get(rowIndex);
 
	}
	
    public static String mergeAlternately(String word1, String word2) {
    	var result = "";
        var firstWordSize = word1.length();
        var secondWordSize = word2.length();
        
        var commonLength = firstWordSize >= secondWordSize ? firstWordSize : secondWordSize;
        
        for(int i = 0 ; i < commonLength ; i++) {
        	
        	var boxOne = "";
        	var boxTwo = "";
        	
        	try {
        		boxOne = ""+word1.charAt(i);
        	}catch(Exception ex) {
        		boxOne = "";
        	}
        	
        	try {
        		boxTwo = ""+word2.charAt(i);
        	}catch(Exception ex) {
        		boxTwo = "";
        	} 
        	
        	result += boxOne+boxTwo;
        }
        
        return result;
        
    }

	public static void main(String[] args) {
//		SpringApplication.run(ZymalApplication.class, args);

		var list =  getRow(5);
		
		for (var lis : list) {
			System.out.println(lis);
			
		}
		
		System.out.println(mergeAlternately("hlo34","el3434"));
	}

}
