package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import enumerator.Judgement;
import resource.Node;

public class FoodLib implements Library{
	
	private static HashSet<String> foodDic = new HashSet<>(); ;
	
	
	/**
	 * Generate Service Library
	 * @throws FileNotFoundException 
	 */
	public FoodLib(String pPath) throws FileNotFoundException {
		Scanner scFood = new Scanner (new File(pPath));
		String word;
		while(scFood.hasNext()){
			word = scFood.next();
			word.trim();
			word = word.toUpperCase();
			foodDic.add(word);
		}
		scFood.close();	
	}

	@Override
	public void determineNodetype(Node pNode) {
			String[] input = pNode.getStrings();
			for(String check: input){
				check = check.toUpperCase();
				if (foodDic.contains(check)) {
					pNode.setType(NodeType.FOOD);
					return;
				}
			}
 			
	}

	//This is to leave blank: determine judgement
	@Override
	public void determineJudgement(Node pNode) {
		// TODO Auto-generated method stub
			
	}
}