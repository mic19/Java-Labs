
import static java.lang.System.out;
import java.io.*;
import java.lang.Math.*;

public class lab09 {
  public static void main( String args[] ){
    double epsilon = 2;

    try{
      String inputFile = args[0];
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));    

      //pobranie 1 linii danych
      String[] dataAsString = reader.readLine().split(" ");

      //rozmiary pliku wyjsciowego
      int[] size = new int[2];
      size[0] = Integer.parseInt(dataAsString[0]);
      size[1] = Integer.parseInt(dataAsString[1]);
      
      //pobranie nazwy pliku wejsciowego
      String outputFile = dataAsString[2];
      if(outputFile.endsWith(".ppm") == false){
        //out.println("program nie obsluguje tego typu pliku");
        //throw new IOException();
      }

      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

      //liczba punktow w pliku
      int numberOfPoints = Integer.parseInt(reader.readLine());
      int[][] tab = new int[numberOfPoints][];
      for(int i = 0; i < numberOfPoints; i++)
        tab[i] = new int[2];

      for(int i = 0; i < numberOfPoints; i++){
        String temp[] = reader.readLine().split(",");
        tab[i][0] = Integer.parseInt(temp[0]);
        tab[i][1] = Integer.parseInt(temp[1]);
      }

      //zapis do pliku ppm
      String beginFile = "P3\n";
      beginFile += size[0] + " " + size[1] + "\n255\n";
      writer.write(beginFile, 0, beginFile.length());
      writer.flush();

      for(int i = 0; i < size[0]; i++){
        for(int j = 0; j < size[1]; j++){
          //domyslnie jest kolor bialy
          String colors = "255 255 255 ";

          //odleglosci od 2 najblizszych punktow
          double l1 = 10000;
          double l2 = 10000;
          
          //sprawdzenie czy jest punkt o danych wspolrzednych
          for(int k = 0; k < numberOfPoints; k++){
            if(i == tab[k][0] && j == tab[k][1])
              colors = "255 0 0 ";

            //sprawdzenie odleglosci od 2 najblizszych punktow
            double tempLength = length(i, j, tab[k][0], tab[k][1]);
            if(tempLength < l1)
              l1 = tempLength;
            if(tempLength > l1 && tempLength < l2)
              l2 = tempLength;
          }

          if(Math.abs(l1 - l2) < epsilon)
            colors = "0 0 0 ";

          writer.write(colors, 0, colors.length());
          writer.flush();
        }
      }

      reader.close();
      writer.close();
    }
    catch(FileNotFoundException e){
      out.println("nie znaleziono pliku");
    }
    catch(IOException e){
      out.println("blad przy wejsciu lub wyjsciu");
    }
    catch(NullPointerException e){
      out.println("podano zle dane");
    }
  }

  //odleglosc miedzy 2 punktami
  static double length(int x1, int y1, int x2, int y2){
    return Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
  }
}
