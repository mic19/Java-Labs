import static java.lang.System.out;

public class lab02{
	public static void main(String args[]){
		Zespolona a = new Zespolona(1,3);
		Zespolona b = new Zespolona(2,-4);
		Zespolona c = new Zespolona(2,1);
		Zespolona d = new Zespolona(2,6);

		Zespolona outcome = new Zespolona();

		outcome = a;
		outcome.pomnoz(b).podziel(c).dodaj(d);

		outcome.print();

	}
}
