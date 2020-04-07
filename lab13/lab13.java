
import java.util.*;
import static java.lang.System.out;
import java.util.Collections;
import java.util.Comparator;

class Student{
    private String imie;
    private String nazwisko;
    private int wiek;

    public Student(){}

    public Student(String imie, String nazwisko, int wiek){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public void setImie(String imie){
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }

    public void setWiek(int wiek){
        this.wiek = wiek;
    }

    public String getImie(){
        return imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public int getWiek(){
        return wiek;
    }

    public String toString(){
        return getImie() + " " + getNazwisko() + " " + getWiek();
    }
}

//komparatory
class StdCmpImie implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.getImie().compareTo(s2.getImie());
    }
}

class StdCmpImieInv implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return -s1.getImie().compareTo(s2.getImie());
    }
}

class StdCmpNazwisko implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.getNazwisko().compareTo(s2.getNazwisko());
    }
}

class StdCmpNazwiskoInv implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return -s1.getNazwisko().compareTo(s2.getNazwisko());
    }
}

class StdCmpWiek implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        if(s1.getWiek() > s2.getWiek())
            return -1;
        if(s1.getWiek() < s2.getWiek())
            return 1;
        return 0;
    }
}

class StdCmpWiekInv implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        if(s1.getWiek() > s2.getWiek())
            return 1;
        if(s1.getWiek() < s2.getWiek())
            return -1;
        return 0;
    }   
}

class Lista_Studentow{
    ArrayList<Student> arr;

    public Lista_Studentow(){
        arr = new ArrayList<Student>();
    }

    public void add(Student student){
        arr.add(student);
    }

    public void add(String imie, String nazwisko, int wiek){
        arr.add(new Student(imie, nazwisko, wiek));
    }

    public void wypisz_wszystkich(){
        for(Student iter : arr)
            out.println(iter);
    }

    public void sort_imie_rosnaca(){
        Collections.sort(arr, new StdCmpImie());
    }

    public void sort_imie_malejaca(){
        Collections.sort(arr, new StdCmpImieInv());
    }

    public void sort_nazwisko_rosnaca(){
        Collections.sort(arr, new StdCmpNazwisko());
    }

    public void sort_nazwisko_malejaca(){
        Collections.sort(arr, new StdCmpNazwiskoInv());
    }

    public void sort_wiek_rosnaca(){
        Collections.sort(arr, new StdCmpWiek());
    }

    public void sort_wiek_malejaca(){
        Collections.sort(arr, new StdCmpWiekInv());
    }

}

public class lab13
{
 public static void main(String[] args)
 {
  Student testowy_student = new Student();

  testowy_student.setImie("Jan");
  testowy_student.setNazwisko("Nowak");
  testowy_student.setWiek(22);

  System.out.println("Testowy student: " + testowy_student.getImie() + " "
                                         + testowy_student.getNazwisko()+ " "
                                         + testowy_student.getWiek());
  System.out.println("-------------------------------");

  //UWAGA! Kolekcja wewn¹trz klasy "Lista_Studentow" musi przechowywaæ obiekty klasy "Student"
  Lista_Studentow lista_studentow = new Lista_Studentow();

  lista_studentow.add(testowy_student);
  lista_studentow.add("Kamil","Kloch",23);
  lista_studentow.add("Alicja","Akacja",18);

  lista_studentow.wypisz_wszystkich();
  System.out.println("-------------------------------");

  //UWAGA! Do sortowania MUSI byæ wykorzystane Collections.sort(.....)
  lista_studentow.sort_imie_rosnaca();
  lista_studentow.wypisz_wszystkich();
  System.out.println("-------------------------------");

  lista_studentow.sort_imie_malejaca();
  lista_studentow.wypisz_wszystkich();
  System.out.println("-------------------------------");

  lista_studentow.sort_nazwisko_rosnaca();
  lista_studentow.wypisz_wszystkich();
  System.out.println("-------------------------------");

  lista_studentow.sort_nazwisko_malejaca();
  lista_studentow.wypisz_wszystkich();
  System.out.println("-------------------------------");

  lista_studentow.sort_wiek_rosnaca();
  lista_studentow.wypisz_wszystkich();
  System.out.println("-------------------------------");

  lista_studentow.sort_wiek_malejaca();
  lista_studentow.wypisz_wszystkich();
  System.out.println("-------------------------------");

 }
}

 /* Output:

Testowy student: Jan Nowak 22
-------------------------------
Jan Nowak 22
Kamil Kloch 23
Alicja Akacja 18
-------------------------------
Alicja Akacja 18
Jan Nowak 22
Kamil Kloch 23
-------------------------------
Kamil Kloch 23
Jan Nowak 22
Alicja Akacja 18
-------------------------------
Alicja Akacja 18
Kamil Kloch 23
Jan Nowak 22
-------------------------------
Jan Nowak 22
Kamil Kloch 23
Alicja Akacja 18
-------------------------------
Kamil Kloch 23
Jan Nowak 22
Alicja Akacja 18
-------------------------------
Alicja Akacja 18
Jan Nowak 22
Kamil Kloch 23
-------------------------------
 */