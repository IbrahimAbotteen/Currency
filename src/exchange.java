import java.util.Hashtable;
import java.util.Scanner;

public class exchange {

    private String source;//the source symbols
    private String dest;// the destination symbols
    private Double convert=0.0;// the amount after conversion
    private Double sDollars;//the corresponding value in dollars for the source symbol
    private Double dDollars;// the corresponding value in dollars for the destination symbol
    private double amount=0.0;// the amount of money before conversion
    public Hashtable data=new Hashtable();// contains the symbols and their values
    Scanner x=new Scanner(System.in);//for taking the data from the users keyboard
//Method for filling the hashtable while reading the csv file
    public void fillTable(String x,Double y)
    {
        data.put(x,y);

    }
// method for taking the source symbols from the user and change it into dollars
    public double takeSourceSymbols() {
        System.out.println("enter the ORIGINAL currency symbol (example: USD) ");
        source = x.nextLine();
      source=  source.toUpperCase();
        if (!data.containsKey(source)) {
            System.out.println("Invalid currency ,,, please enter  a valid currency");
            source = x.nextLine();
        }
        sDollars = (Double) data.get(source);//taking the corresponding value of dollars from the hash table
        return sDollars;
    }

    // method for taking the destination symbols from the user and change it to dollars
    public double takeDestSymbols(){
        System.out.println("enter the NEW currency symbol (example: USD) ");
        dest=x.nextLine();
       dest= dest.toUpperCase();
        if(!data.containsKey(dest))
        {
            System.out.println("Invalid currency ,,, please enter  a valid currency");
            dest=x.nextLine();
        }

        dDollars= (Double) data.get(dest);
        return dDollars;

    }
    // method to calculate the new amount ... it takes the corresponding values in dollars and the amount of money

    public double convertor(double sd,double dd,double am)
    {
        amount=am;
        convert=(am*dd)/sd;
        return convert;
    }
    // printing the whole process
    public void printConversion()
    {
        System.out.println(source+" "+amount+" = "+dest+" "+convert);
    }

}









