
import java.io.*;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;

class Record implements Serializable{
    public Record(String str2, String str1){
        pol = str1;
        eng = str2;
    }

    public String toString(){
        return pol + " - " + eng;
    }

    //rekordy sa uznawana za rowne jesli oba slowa sa rowne
    public boolean equals(Object other){
        if(pol.equals(((Record)other).getPol()) && eng.equals(((Record)other).getEng()))
            return true;
        else return false;
    }

    public boolean contains(String str){
        if(pol.equals(str) || eng.equals(str))
            return true;
        else return false;
    }

    //metoda tlumaczy jedno slowo na drugie a jesli w rekordzie go nie ma zwraca null
    public String translate(String str){
        if(str.equals(pol))
            return eng;
        if(str.equals(eng))
            return pol;
        return null;
    }

    public String getPol(){return pol;}
    public String getEng(){return eng;}

    private String pol;
    private String eng;
}

public class lab12{
    public static void main(String[] args){
        ArrayList<Record> arr;

        //sprawdzenie czy istnieje zapisany slownik
        try{
          ObjectInputStream in = new ObjectInputStream(new FileInputStream("slownik.dic"));
          arr = (ArrayList<Record>)in.readObject();
          in.close();
        }
        catch(Exception e){
          //jesli nie wczytano slownika to utworz nowy
          arr = new ArrayList<Record>();
        }
        
        //2 argumenty - dodaj slowo do slownika
        if(args.length == 2){
            Record givenRecord = new Record(args[0], args[1]);
            if(arr.contains(givenRecord) == false)
                arr.add(givenRecord);
            else out.println("podane tlumaczenie juz jest");
        }

        //jeden argument - sprawdz slowo w slowniku i jesli jest to przetlumacz
        if(args.length == 1){
            //szukaj slowa w slowniku
            String temp = args[0];
            String output = null;

            Iterator<Record> iter = arr.iterator();
            while(iter.hasNext() == true){
                Record rec = iter.next();
                if(rec.contains(temp) == true)
                    output = rec.translate(temp);
            }

            if(output == null)
                out.println("nie ma w slowniku");
            else out.println(output);
        }

        //jesli nie podano argumentow to wypisz caly slownik
        if(args.length == 0)
            out.println(arr);

        //zapisanie slownika
        try{
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("slownik.dic"));
            obj.writeObject(arr);
            obj.close();
        }
        catch(IOException e){
            out.println("blad przy zapisie slownika");
            out.println(e);
        }

    }
}

