
/**
klasa lab03string - klasa zawierajaca tylko funkcje statyczne<br>
do dzialan na obiektach klasy String.

*/
class lab03string{
	/**
	@param str - obiekt klasy String, ktorego dlugosc chcemy otrzymac.
	@return dlugosc przekazanego obiektu String.
	*/
	public static int dlugosc(String str){
		return str.length();
	}

	/**
	metoda statyczna wskazujaca ile razy dany znak pojawia sie w obiekcie String.

	@param str - badany obiekt, character - szukany znak.
	@return liczba wystapien znaku w przekazanym obiekcie.
	*/
	public static int ile_razy_literka_wystepuje(String str, char character){
		int licznik = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == character)
				licznik++;
		}
		return licznik;
	}

	/**
	metoda statyczna porownujaca tylko zawartosci obiektow String.<br>
	metoda korzysta z funkcji equals klasy String.

	@param str1, str2 - porownywane obiekty.
	@return wartosc true jesli zawartosc obiektow jest taka sama, false w przeciwnym przypadku.
	*/
	public static boolean czy_takie_same(String str1, String str2){
		return str1.equals(str2);
	}
	
	/**
	metoda statyczna zwracajaca odwrocony String.

	@param str - odwracany Stirng.
	@return nowy odwrocony String.
	*/
	public static String wspak(String str){
		char[] tab = str.toCharArray();
		char temp;

		int i = 0;
		int j = str.length() - 1;
		for(; i <= j; i++, j--){
			temp = tab[i];
			tab[i] = tab[j];
			tab[j] = temp;
		}

		return new String(tab);
	}

	/**
	metoda statyczna wskazujaca czy String czytany w dwie strony jest taki sam.

	@param str - badany String.
	@return wartosc true jest str jest palindromem, false w przeciwnym przypadku.
	*/
	public static boolean czy_plaindrom(String str){
		int i = 0;
		int j = str.length() - 1;
		for(; i <= j; i++, j--){
			if(str.charAt(i) != str.charAt(j))
				return false;
		}

		return true;
	}

	/**
	metoda statyczna wskazujaca czy str jest abecadlowy.<br>
	jesli chodzi o kolejnosc alfabetyczna znakow w String to jest<br>
	ona wyznaczana przez indeks w kodzie Unicode (bez polskich znakow dziala<br>
	tak jak w ascii.

	@param str - badany String.
	@return wartosc true jesli jest abecadlowy, false w przeciwnym przypadku.
	*/
	public static boolean czy_abecadlowe(String str){
		for(int i = 0; i < str.length() - 1; i++){
			if(str.charAt(i) > str.charAt(i + 1))
				return false;
		}

		return true;
	}

	/**
	metoda statyczna przesuwajaca litery w Stringu o 13 w alfabecie.<br>
	przesuniecie koncowych znakow zwroci znaki z poczatku<br>
	tak jakby do ostatniego znaku w albecie dolaczony byl nastepny alfabet.

	@param str - String ktorego znaki sa przesuwane.
	@return nowy String o przesunietych znakach.
	*/
	public static String rot13(String str){
		char[] tab = str.toCharArray();

		for(int i = 0; i < str.length(); i++){
			if(Character.isLowerCase(tab[i]) == false){
				if(tab[i] >= 'A' && tab[i] <= 'Z'){
					tab[i] = (char)(((tab[i]-'A')+13)%26+'A');
				}
			}
			else {
				if(tab[i] >= 'a' && tab[i] <= 'z'){
					tab[i] = (char)(((tab[i]-'a')+13)%26+'a');
				}
			}
		}

		return new String(tab);
	}

}
