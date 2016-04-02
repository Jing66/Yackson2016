package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import enumerator.Judgement;
import resource.Node;

public class JudgeLib implements Library{
	
	private static HashSet<String> judgeDicGood = new HashSet<>(); 
	private static HashSet<String> judgeDicBad = new HashSet<>(); 

	
	
	/**
	 * Generate Judgemental Library (GOOD & BAD)
	 * @throws FileNotFoundException 
	 */
	public JudgeLib(String pPath, String bPath) throws FileNotFoundException {
		Scanner scJudgeGood = new Scanner (new File(pPath));
		String wordG;
		while(scJudgeGood.hasNext()){
			wordG = scJudgeGood.next();
			wordG.trim();
			wordG = word.toUpperCase();
			judgeDicGood.add(wordG);
		}
		scJudgeGood.close();
		
		Scanner scJudgeBad = new Scanner (new File(bPath));
		String wordB;
		while(scJudgeBad.hasNext()){
			wordB = scJudgeGood.next();
			wordB.trim();
			wordB = word.toUpperCase();
			judgeDicBad.add(wordB);
		}
		scJudgeBad.close();
	}
	

	
	//This method is determined to leave blank
	@Override
	public void determineNodetype(Node pNode) {
		// TODO Auto-generated method stub
			
	}

	@Override
	public void determineJudgement(Node pNode) {
		String[] input = pNode.getStrings();
		for(String check:input){
			check=check.toUpperCase();
		
			//if word maps to one in hashtable : check
			if (judgeDicGood.contains(check))  pNode.setJudgement(Judgement.GOOD);
			else if (judgeDicBad.contains(check)) pNode.setJudgement(Judgement.BAD);
			else continue;
		}
			
	}
}
