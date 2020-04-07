
package Armia;
import java.util.ArrayList;

interface jakCzolg{
	public String ostatniRozkaz();
	public void dodajRozkaz(Rozkaz roz);
	public String wypiszRozkazy();
}

public class Czolg implements jakCzolg{
	public String ostatniRozkaz(){
		String str = "Ostatni rozkaz do mnie: ";
		if(list.size() - 1 >= 0)
			str += list.get(list.size() - 1).podajRozkaz();
		else str = "brak rozkazow";
		return str;
	}

	public void dodajRozkaz(Rozkaz roz){
		list.add(roz);
	}

	public String wypiszRozkazy(){
		StringBuilder str = new StringBuilder();

		for(int i = 0; i < list.size(); i++){
			str.append(list.get(i).podajRozkaz() + "\n");
		}

		return str.toString();
	}

	//lista przechowujaca rozkazy w kolejnosci wydania
	private ArrayList<Rozkaz> list = new ArrayList<Rozkaz>();

}