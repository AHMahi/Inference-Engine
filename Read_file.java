import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.LinkedList;

public class Read_file {
    private ArrayList<horn> p;
    private ArrayList<String> q;

//    public Read_file(){
//        p = new ArrayList<String>();
//        q = new ArrayList<String>();
//    }

    public Read_file(Scanner file){
        p = new ArrayList<horn>();
        q = new ArrayList<String>();
        Read_line(file);
    }

    public void Read_line(Scanner file){
       // File readLine = new File(file);
        /* Taking the first line of the file */
       String Tell = file.nextLine();
        String cleanLine = file.nextLine();;
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
                p.add(new horn(splitLine[i]));
            }
            else
            {
                q.add(splitLine[i]);
            }
        }

    }

    public ArrayList<horn> getp(){
        return p;
    }
    public ArrayList<String> getq(){
        return q;
    }


}
