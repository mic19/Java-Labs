
import static java.lang.System.out;
import java.io.*;
import java.util.*;

class Gra implements Serializable{
  //tablica reprezentuje plansze kolko i krzyzyk
  protected char[] tab;

  //licznik ruchow - jesli 9 to koniec gry (tablica pelna)
  protected int licznik;

  //flaga wskazuje ruch gracza
  protected boolean ruch;

  Gra(){
    tab = new char[9];
    for(int i = 0; i < 9; i++)
      tab[i] = ' ';

    licznik = 0;
    ruch = true;
  }

  //pole to miejsce postawienia znaku, znak to kolko albo krzyzyk
  void nowa(int pole){
    char ch;
    if(ruch == true)
      ch = 'O';
    else ch = 'X';

    if(tab[pole] == ' '){
      tab[pole] = ch;
      licznik++;
      ruch = !ruch;
    }
    else out.println("pole jest juz zajete");
  }

  public void wypisz(){
    //out.println("-------");
    for(int i = 0; i < 9; i++){
      out.print(tab[i]);

      if(i % 3 == 2){
        out.println();//"|");
        if(i != 8)
          out.println("-+-+-");
      }
      else out.print("|");
    }
    out.println("\n");
  }

  //metoda zwraca true jesli koniec gry zostal osiagniety
  //(w tym przypadku sprawdza tylko czy plansza jest pelna)
  public boolean koniec(){
    if(licznik == 9)
      return true;
    else return false;
  }

}

public class lab10 {
  public static void main( String args[] ){
    Gra p = null;

    //sprawdzenie czy istnieje zapisana gra
    try{
      ObjectInputStream in = new ObjectInputStream(new FileInputStream("gra.tmp"));
      p = (Gra) in.readObject();
      in.close();
    }
    catch(Exception e){
      //jesli nie wczytano gry to utworz nowa
      p = new Gra();
    }
    p.wypisz();

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    while(p.koniec() == false){
      //pole na ktorym zostanie postawiony znak
      int pole = -1;
      try{
        pole = in.read();
        in.read();
      }
      catch(IOException e){
        out.println("blad wejscia/wyjscia");
      }

      if(pole != -1){
        if(pole == 'x'){
          //serializacja - zapis stanu gry
          out.println("zapisanie stanu gry");
          try{
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("gra.tmp"));
            obj.writeObject(p);
            obj.close();
          }
          catch(IOException e){
            out.println("blad przy zapisie gry");
          }
          break;

        }else{
          //odejmowanie 49 zamienia char na int i odejmuje 1 (do indeksowania planszy)
          pole -= 49;
          p.nowa(pole);

          p.wypisz();
          pole = -1;
        }
      }
    }

  }
}