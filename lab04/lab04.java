
import static java.lang.System.out;

class Tab{
	//plansza na ktorej rozgrywa sie gra
	char[][] tab;

	public Tab(int size_x, int size_y, int preset)
	{
		//utworzenie tablicy z liczba sasiadow kazdej komorki
		tab2 = new int[size_y][];

		//utworzenie tablicy
		tab = new char[size_y][];

		switch(preset){
			case 0:
			{
				for(int i = 0; i < size_y; i++)
				{
					tab[i] = new char[size_x];
					tab2[i] = new int[size_x];
					for(int j = 0; j < size_x; j++)
					{
						int temp = (int)(Math.random()*2);
						if(temp == 0)
							tab[i][j] = 'X';
						else tab[i][j] = '.';

						tab2[i][j] = 0;
					}
				}
			}
			break;
			case 1:
			{
				//lodz
				for(int i = 0; i < size_y; i++)
				{
					tab[i] = new char[size_x];
					tab2[i] = new int[size_x];
					for(int j = 0; j < size_x; j++)
					{
						tab[i][j] = '.';
						tab2[i][j] = 0;
					}
				}

				size_x--;
				size_y--;
				//srodek to size_x, size_y
				tab[size_y/2 - 1][size_x/2] = 'X';
				tab[size_y/2 + 1][size_x/2] = 'X';
				tab[size_y/2][size_x/2 - 1] = 'X';
				tab[size_y/2][size_x/2 + 1] = 'X';
				tab[size_y/2 - 1][size_x/2 - 1] = 'X';

			}
			break;
			case 2:
			{
				//blinker
				for(int i = 0; i < size_y; i++)
				{
					tab[i] = new char[size_x];
					tab2[i] = new int[size_x];
					for(int j = 0; j < size_x; j++)
					{
						tab[i][j] = '.';
						tab2[i][j] = 0;
					}
				}

				size_x--;
				size_y--;
				//srodek to size_x/2, size_y/2
				tab[size_y/2][size_x/2] = 'X';
				tab[size_y/2 + 1][size_x/2] = 'X';
				tab[size_y/2 - 1][size_x/2] = 'X';
			}
			break;
			default:
			{
				//szybowiec
				for(int i = 0; i < size_y; i++)
				{
					tab[i] = new char[size_x];
					tab2[i] = new int[size_x];
					for(int j = 0; j < size_x; j++)
					{
						tab[i][j] = '.';
						tab2[i][j] = 0;
					}
				}

				size_x--;
				size_y--;
				//srodek to size_x/2, size_y/2
				tab[size_y/2 - 1][size_x/2 - 1] = 'X';
				tab[size_y/2 - 1][size_x/2 + 1] = 'X';
				tab[size_y/2 + 1][size_x/2] = 'X';
				tab[size_y/2 - 1][size_x/2] = 'X';
				tab[size_y/2][size_x/2 - 1] = 'X';
			}
		}	
	}

	//metoda wypisuje aktulana plansze
	public void print(){
		for(int i = 0; i < tab.length; i++){
			for(int j = 0; j < tab[i].length; j++){
				out.print(tab[i][j]);
			}
			out.println();
		}
	}

	//zlicza sasiadow podanej komorki - zakladam ze nie sa na krawedziach
	public int sasiad(int x, int y){
		int count = 0;
		//8 przypadkow

		//po skosie
		if(y-1 >= 0 && x-1 >= 0 && y-1<tab.length && x-1<tab[0].length)
			if(tab[y - 1][x - 1] == 'X')
				count++;
		if(y-1 >= 0 && x+1 >= 0 && y-1<tab.length && x+1<tab[0].length)
			if(tab[y - 1][x + 1] == 'X')
				count++;
		if(y+1 >= 0 && x-1 >= 0 && y+1<tab.length && x-1<tab[0].length)
			if(tab[y + 1][x - 1] == 'X')
				count++;
		if(y+1 >= 0 && x+1 >= 0 && y+1<tab.length && x+1<tab[0].length)
			if(tab[y + 1][x + 1] == 'X')
				count++;
		
		///////////////////////////////////
		//po bokach
		if(y >= 0 && x-1 >= 0 && y<tab.length && x-1<tab[0].length)
			if(tab[y][x - 1] == 'X')
				count++;
		if(y >= 0 && x+1 >= 0 && y<tab.length && x+1<tab[0].length)
			if(tab[y][x + 1] == 'X')
				count++;
		if(y-1 >= 0 && x >= 0 && y-1<tab.length && x<tab[0].length)
			if(tab[y - 1][x] == 'X')
				count++;
		if(y+1 >= 0 && x >= 0 && y+1<tab.length && x<tab[0].length)
			if(tab[y + 1][x] == 'X')
				count++;

		return count;
	}

	//tablica wskazujaca liczbe sasiadow
	int[][] tab2;

	//metoda uaktualnia plansze o 1 "krok"
	public void step(){
		//wyznaczanie liczby sasiadow
		for(int i = 0; i < tab.length; i++){
			for(int j = 0; j < tab[i].length; j++){
				tab2[i][j] = sasiad(j, i);
			}
		}

		//uaktualnianie planszy w zaleznosci od tablicy sasiadow
		for(int i = 0; i < tab.length; i++){
			for(int j = 0; j < tab[i].length; j++){
				int count = tab2[i][j];

				if(count == 3)
					tab[i][j] = 'X';
				if(count < 2 || count > 3)
					tab[i][j] = '.';
				
			}
		}
	}

}

public class lab04{
	public static void main(String[] args){
		int size_x = Integer.parseInt(args[0]);
		int size_y = Integer.parseInt(args[1]);
		int steps = Integer.parseInt(args[2]);
		int preset = Integer.parseInt(args[3]);

		Tab tab = new Tab(size_x, size_y, preset);
		out.println("przed gra:");
		tab.print();
		out.println();

		char[] border = new char[size_x/2 - 2];
		for(int i = 0; i < border.length; i++)
			border[i] = '-';
		String str = new String(border);

		//rozgrywanie
		out.println("rozgrywka:");
		for(int i = 1; i <= steps; i++){
			//ramka na gorze
			out.print(str + "- " + i + " " + str);
			if(size_x % 2 == 1)
				out.println('-');
			else out.println();

			tab.step();
			tab.print();
			out.println();
		}

	}
}
