import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Scanner;

public class currency {

    public static void main(String []args)
    {

        try {
            FileReader rd=new FileReader("src/forex.csv");
            Scanner read=new Scanner(rd);
            read.nextLine();//skipping the first line
            Hashtable map=new Hashtable();
            exchange obj=new exchange();
            while(read.hasNextLine())
            {
                String line=read.nextLine();
                //System.out.println(line);
                String[] lineSplit=line.split(",");// this is to split the line into an array
                String key=lineSplit[0];// taking the first col as a key for the next hashtable
                Double value= Double.valueOf(lineSplit[2]);// taking the value of each key from the third col
                //map.put(key,value);
                obj.fillTable(key,value);//filling the hashtable with the key and its value


                //System.out.println(key+" "+value);
            }

         double sourceD =obj.takeSourceSymbols();
          double destD= obj.takeDestSymbols();

          Scanner x=new Scanner(System.in);
          System.out.println("please enter the amount of money");
          double amount=x.nextDouble();
         double convert= obj.convertor(sourceD,destD,amount);
         obj.printConversion();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}




