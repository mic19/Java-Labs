import static java.lang.System.out;

/**
Klasa reprezentujaca liczbe zespolona z podstawowa funkcjonalnoscia<br>
taka jak:<br>

<ul>
	<li>dodowanie</li>
	<li>odejmowanie</li>
	<li>mnozenie</li>
	<li>dzielenie</li>
	<li>wypisanie</li>
</ul>
*/
class Zespolona{
	/**
	Domyslny konstruktor inicjalizuje obuie czesci liczby zespolonej<br>
	liczba 0
	*/
	Zespolona(){
		r = 0;
		z = 0;
	}

	/**
	Konstruktor wykorzystujacy metode set(double rze, double zesp)<br>
	do zainicjalizowania wartosci rzeczywistej i zespolonej
	*/
	Zespolona(double rze, double zesp){
		this.set(rze, zesp);
	}

	double r;//czesc rzeczywista liczby
	double z;//czesc zespolona liczby

	/**
	Metoda ustawia wartosci (rzeczywista i zespolona)
	@param rze reprezentuje czesc rzeczywista liczby<br>
		zesp reprezentuje czesc zespolona
	*/
	public void set(double rze, double zesp){
		r = rze;
		z = zesp;
	}

	/**
	Metoda zwraca czesc rzeczywista liczby zespolonej
	@return czesc rzeczywista liczby zespolonej
	*/
	public double getRe(){
		return r;
	}

	/**
	Metoda zwraca czesc urojona liczby zespolonej
	@return czesc urojona liczby zespolonej
	*/
	public double getIm(){
		return z;
	}

	/**
	Metoda wypisuje liczbe zespolona w System.out<br>
	w formacie a + bi
	*/
	public void print(){
		if(z >= 0)
			out.println(r + " + " + z + "i");
		else out.println(r + " " + z + "i");
	}

	/**
	Metoda dodaje przekazana liczbe i zwraca referencje this
	@return referencja this
	*/
	public Zespolona dodaj(Zespolona zesp){
		r += zesp.getRe();
		z += zesp.getIm();                                                                                                                  
		return this;
	}

	/**
	Metoda odejmuje przekazana liczbe i zwraca referencje this
	@return referencja this
	*/
	public Zespolona odejmij(Zespolona zesp){
		r -= zesp.getRe();
		z -= zesp.getIm();
		return this;
	}

	/**
	Metoda mnozy przez przekazana liczbe i zwraca referencje this
	@return referencja this
	*/
	public Zespolona pomnoz(Zespolona zesp){
		double p = r;
		double q = z;

		double r2 = zesp.getRe();
		double s = zesp.getIm();
		
		r = p*r2 - q*s;
		z = p*s + q*r2;

		return this;
	}

	/**
	Metoda dzieli przez przekazana liczbe i zwraca referencje this
	@return referencja this
	*/
	public Zespolona podziel(Zespolona zesp){
		double p = r;
		double q = z;

		double r2 = zesp.getRe();
		double s = zesp.getIm();

		r = (p*r2+q*s)/(r2*r2+s*s);
		z = (q*r2-p*s)/(r2*r2+s*s);

		return this;
	}

}
