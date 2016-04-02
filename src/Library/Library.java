package Library;

import resource.Node;
import enumerator.Judgement;
import enumerator.NodeType;

import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;

public class Library implements judgement{
	Node node;
	private static Hashtable rating;
	private static Hashtable exception;
	
	//instance constructor
	public Library(Node node){
		this.node=node;
		rating = Judgement.NONE;
	}
	
	/*constructing hashtable for Judgement vocabulary
	 * 1 for positive view, 0 for negative view */
	static{
		//put hashvalues for good words from source txt.
		//GoodJudgement.txt contains all good words no matter word length
		rating = new Hashtable<Integer, Integer>();
		exception = new Hashtable<Integer, Integer>(); //exception hashvalue of words length <4
		String rate;
		Scanner scGood = new Scanner (new File("GoodJudgement.txt"));
		while(scGood.hasNext()){
			rate = scGood.next();
			rate = rate.toUpperCase();
			if(rate.length()<4) exception.put(rate.hashCode(), 1);
			rating.put(rate.hashCode(), 1);
		}
		//put hashvalues for bad words from source txt
		Scanner scBad = new Scanner (new File("BadJudgement.txt"));
		while(scBad.hasNext()){
			rate = scBad.next();
			rate = rate.toUpperCase();
			if(rate.length()<4) exception.put(rate.hashCode(), 0);
			rating.put(rate.hashCode(), 0);
		}
		
		scGood.close();
		scBad.close();
		
	}
	
	
	
	/*get the judgement of one aspect in a sentence
	 * modify the judgment attribute of node and return it*/
	public Judgement rate(){
		String[] input = this.node.getStrings();
		for(String check:input){
			check=check.toUpperCase();
			//if word length <4 && not an exception : skip
			if(check.length()<4 && exception.containsKey("check".hashCode())==false) continue;
			
			//if word maps to one in hashtable : check
			else if (rating.containsKey("check".hashCode())){
				int key=(int) rating.get("check".hashCode());
				if(key==1)	this.node.setType(Judgement.GOOD);
				else this.node.setType(Judgement.BAD);
			}
			else continue;
		}
		
		
		return this.node.getType();
	}
	
	
	public boolean searchLib(Hashtable<Integer,Integer> dictionary){
		String[] input = this.node.getStrings();
		boolean inDic=false;
		for(String check:input){
			check=check.toUpperCase();
			if(dictionary.containsKey(check.hashCode())) inDic=true;
		}
		return inDic;
	}
}

