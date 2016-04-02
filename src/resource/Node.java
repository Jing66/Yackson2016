package resource;

import java.util.Arrays;
import enumerator.Judgement;
import enumerator.NodeType;

public class Node {
	
	private String[] aSentence;
	NodeType aType;
	Judgement aJudgement;
	
	public Node(String[] pSentence){
		aSentence = Arrays.copyOf(pSentence, pSentence.length);
		aType = NodeType.NONE;
		aJudgement = Judgement.NONE;
	}

}
