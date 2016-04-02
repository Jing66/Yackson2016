package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import enumerator.Judgement;
import resource.Node;

public class PriceLib implements Library{
	
	private static HashSet<String> priceDic = new HashSet<>(); ;
	
	
	/**
	 * Generate Service Library
	 * @throws FileNotFoundException 
	 */
	public PriceLib(String pPath) throws FileNotFoundException {
		Scanner scPrice = new Scanner (new File(pPath));
		String word;
		while(scPrice.hasNext()){
			word = scFood.next();
			word.trim();
			word = word.toUpperCase();
			priceDic.add(word);
		}
		scPrice.close();	
	}

	@Override
	public void determineNodetype(Node pNode) {
			String[] input = pNode.getStrings();
			for(String check: input){
				check = check.toUpperCase();
				if (priceDic.contains(check)) {
					pNode.setType(NodeType.PRICE);
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