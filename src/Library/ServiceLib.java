package Library;

import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;

public class ServiceLib extends Library implements judgement{
	private static Hashtable serviceDic;
	
	public ServiceLib(Node node) {
		super(node);
	}
	

	static{
		serviceDic = new Hashtable<Integer, Integer>();
		Scanner scServe = new Scanner (new File("service.txt"));
		String serv;
		while(scServe.hasNext()){
			serv = scServe.next();
			serv = serv.toUpperCase();
			serviceDic.put(serv.hashCode(), 1);
			serviceDic.put(serv.hashCode(), 1);
		}
		
		scServe.close();
	}
	
	//use rate() in library
		@Override
		public Judgement rate(){
			super.rate();
		}
		
		/*judge if a node(comment) belongs to food aspect,
		 *sets its NodeType attribute and return boolean*/
		public boolean isService(){
			return super.searchLib(serviceDic);
		}
}
