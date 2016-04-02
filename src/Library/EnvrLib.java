package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import enumerator.Judgement;
import resource.Node;

public class EnvrLib implements Library{
	
	private static HashSet<String> envrDic = new HashSet<>(); ;
	
	
	/**
	 * Generate Service Library
	 * @throws FileNotFoundException 
	 */
	public EnvrLib(String pPath) throws FileNotFoundException {
		Scanner scEnvr = new Scanner (new File(pPath));
		String word;
		while(scEnvr.hasNext()){
			word = scEnvr.next();
			word.trim();
			word = word.toUpperCase();
			envrDic.add(word);
		}
		scEnvr.close();	
	}

	@Override
	public void determineNodetype(Node pNode) {
			String[] input = pNode.getStrings();
			for(String check: input){
				check = check.toUpperCase();
				if (envrDic.contains(check)) {
					pNode.setType(NodeType.ENVR);
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