
package Armia;

interface jakRozkaz{
	public String podajRozkaz();
}

public class Rozkaz implements jakRozkaz{
	public Rozkaz(String str){
		rozkaz = str;
	}

	public String podajRozkaz(){
		return rozkaz;
	}

	private String rozkaz;
}