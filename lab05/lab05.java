
import static java.lang.System.out;
import java.io.*;

public class lab05{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		out.println("liczba symboli:");
		int n = Integer.parseInt(in.readLine());

		char[] symbole = new char[n];
		out.println("kolejne symbole:");
		for(int i = 0; i < n; i++){
			symbole[i] = in.readLine().charAt(0);
		}

		out.println("zbior:");
		String zbior = in.readLine();

		out.println("liczba regul:");
		int liczbaRegul = Integer.parseInt(in.readLine());
		String[] reguly = new String[liczbaRegul];

		out.println("kolejne reguly:");
		for(int i = 0; i < liczbaRegul; i++){
			reguly[i] = in.readLine();
		}

		/**zapisanie regul w wygodnej formie<br>
			pierwszy lancuch znakowy oznacza znak, ktory zamieniamy<br>
			drugi jest lancuchem na ktory zamieniamy
		*/
		String[][] reg = new String[liczbaRegul][];
		for(int i = 0; i < liczbaRegul; i++){
			reg[i] = new String[2];
			//tablica tymczasowa mowiaca co zamienic na co
			String[] temp = reguly[i].split(" ");
			//co zamieniamy
			reg[i][0] = temp[0];
			//na co zamieniamy
			reg[i][1] = temp[1];
		}

		//budowanie stringa
		StringBuilder sb = new StringBuilder("");
		out.println("n=0: " + zbior);

		//kolejne iteracje - budowanie lancucha wyjsciowego
		int iteracje = Integer.parseInt(in.readLine());
		for(int i = 0; i < iteracje; i++){
			for(int j = 0; j < zbior.length(); j++){
				//realizowanie regul
				for(int k = 0; k < liczbaRegul; k++){
					if(zbior.charAt(j) == reg[k][0].charAt(0))
						sb.append(reg[k][1]);
				}

			}
			zbior = sb.toString();
			sb.delete(0, sb.length());
			out.println("n=" + (i+1) + ": " + zbior);	

		}

		//out.println(zbior);
		
	}
}
