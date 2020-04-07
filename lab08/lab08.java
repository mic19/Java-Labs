
import static java.lang.System.out;
import java.io.*;

class NoDataException extends Exception{

}

public class lab08 {
  public static void main( String args[] ){
    try{
      String inputFile = args[0];
      String outputFile = args[1];
      BufferedReader reader = new BufferedReader(new FileReader(inputFile));
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

      double sum = 0;
      int num = 0; //liczba elementow
      
      for(String str = reader.readLine(); str != null; str = reader.readLine()){
        try{
          sum += Double.parseDouble(str);
          num++;
        }
        catch(NumberFormatException e){
          out.println("w pliku wejsciowym podano niepoprawna dana");
          out.println("nie jest to pojedyncza liczba");
          out.println("numer lini w pliku: " + (num+1) + "\n");
        }
      }

      if(num == 0){
        throw new NoDataException();
      }

      String output = Double.toString(sum/num);

      //proba zapisu do pliku
      try{
        writer.write(output, 0, output.length());
        writer.newLine();
      }
      catch(IOException e){
        throw new IOException("blad przy zapisie");
      }

      reader.close();
      writer.close();
    }
    catch(FileNotFoundException e){
      out.println("nie znaleziono pliku wejsciowego o podanej nazwie");
      out.println("prosze sprobowac ponownie");
    }
    catch(IOException e){
      out.println("blad przy operacji na plikach");
      out.println("prosze sprobowac jeszcze raz");
      out.println(e.getMessage());
    }
    catch(ArrayIndexOutOfBoundsException e){
      out.println("podano za malo argumentow");
      if(e.getMessage().equals("1")){
        out.println("zabraklo pliku wyjsciowego");
      }
      if(e.getMessage().equals("0")){
        out.println("zabraklo pliku wejsciowgo i wyjsciowego");
        out.println("prosze podac te 2 argumenty");
      }
    }
    catch(NoDataException e){
      out.println("w pliku wejsciowym nie ma danych");
    }
  }
}