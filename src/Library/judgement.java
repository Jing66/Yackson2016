package Library;

import java.util.Hashtable;

import enumerator.Judgement;
import enumerator.NodeType;

public interface judgement {
	/*judge which aspect a node belongs to,
	 *sets its NodeType attribute and return boolean*/
	default public boolean isFood();
	default public boolean isService();
	default public boolean isEnvr();
	default public boolean isPrice();
	
	//set the judgement of the node and return its value
	public Judgement rate();
	
	public boolean searchDic(Hashtable<Integer, Integer> dic);
}
