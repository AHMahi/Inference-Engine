import java.sql.Array;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.LinkedList;

public class Read_file {
    private ArrayList<horn> clauses;
    private ArrayList<String> facts;
    private String Ask;



    public Read_file(Scanner file){
        clauses = new ArrayList<horn>();
        facts = new ArrayList<String>();
        Read_line(file);
    }

    public void Read_line(Scanner file){

        /* Taking the first line of the file */
       String Tell = file.nextLine();

       // taking the clauses and process it
        String cleanLine = file.nextLine();
        // Print out Tell in terminal
        System.out.println("Tell: " + cleanLine);

        // Taking the keyword Ask
        String keyword = file.nextLine();

        // Taking the facts and process it
        String ask = file.nextLine();
        System.out.println("Ask : " + ask);
        Ask = ask;

        cleanLine = cleanLine.replaceAll("\\s","");
        String [] splitLine = cleanLine.split(";");
      // p.add(file.nextLine());
       //String ABC = file.next();
//        while ((file.hasNext())) {
//            System.out.println(file.next());
//        }
//        System.out.println(Tell);
//        for(int i = 0; i < splitLine.length; i++) {
//            System.out.println(splitLine[i]);
//        }
        for(int i = 0; i < splitLine.length; i++){
            if(splitLine[i].contains("=>")){
                clauses.add(new horn(splitLine[i]));
            }
            else
            {
                facts.add(splitLine[i]);
            }
        }

    }



    public ArrayList<horn> getClauses(){
        return clauses;
    }
    public ArrayList<String> getFacts(){
        return facts;
    }
    public String getAsk(){return Ask; }



}
