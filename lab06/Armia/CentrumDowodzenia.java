
package Armia;
import java.util.ArrayList;

interface obiektDowodzeniowy{
	public void zarejestrujCzolg(Czolg cz);
	public void wydajRozkaz(String str, Rozkaz roz);
}

public class CentrumDowodzenia implements obiektDowodzeniowy{
	public void zarejestrujCzolg(Czolg cz){
		list.add(cz);
	}

	public void wydajRozkaz(String str, Rozkaz roz){
		list.get(Integer.parseInt(str) - 1).dodajRozkaz(roz);
	}

	//metoda zwraca String rozkazow wyslanych do czolgow (w kolejnosci od pierwszego
	//czolgu) a dla czolgu w kolejnosci wydania rozkazu
	public String toString(){
		StringBuilder str = new StringBuilder();

		str.append("Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n");
		for(int i = 0; i < list.size(); i++){
			str.append("Czolg nr " + (i+1) + " otrzymal rozkazy:\n");
			str.append(list.get(i).wypiszRozkazy() + "\n");
		}

		return str.toString();
	}

	//lista zarejestrowanych czolgow (w takiej kolejnosci)
	private ArrayList<Czolg> list = new ArrayList<Czolg>();

}
