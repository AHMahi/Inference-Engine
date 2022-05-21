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

//    public Read_file(){
//        p = new ArrayList<String>();
//        q = new ArrayList<String>();
//    }

    public Read_file(Scanner file){
        clauses = new ArrayList<horn>();
        facts = new ArrayList<String>();
        //Ask = new ArrayList<String>();
        Read_line(file);
    }

    public void Read_line(Scanner file){
       // File readLine = new File(file);
        /* Taking the first line of the file */
       String Tell = file.nextLine();
        String cleanLine = file.nextLine();;
        String keyword = file.nextLine();
        String ask = file.nextLine();
        Ask = ask;
//        System.out.println(cleanLine);
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
