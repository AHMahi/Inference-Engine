import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;


public class Main {
    public static void main(String[] args) {

        // args contains:
        // [0] - input file
        //[1] = method


        if(args.length < 2){
            System.out.println("Usage iengine <filename> <method>.");
            System.exit(1);
        }


        // inputing file from args[1]
        //Scanner inputfile = new Scanner(args[0]);
        //Read_file newfile = new Read_file(inputfile);
        try {
            File newfile = new File(args[0]);
            Scanner scanner = new Scanner(newfile);
            Read_file nFile = new Read_file(scanner);

//            for(int i = 0; i < nFile.getClauses().size();i++) {
//                //System.out.println("front element : " + nFile.getClauses().get(i).getListA() + " back element : " + nFile.getClauses().get(i).getListArrow());
//                    System.out.println(nFile.getClauses().get(i).getListAIndex(0));
//               // System.out.println(nFile.getp().get(i).getListAIndex(i));
//
//
//            }

//            System.out.println(nFile.getFacts());
//            System.out.println(nFile.getAsk());
//

        if(args[1].equals("fc")){
            forwardc foward = new forwardc(nFile);
           System.out.println("FC output: " + foward.testAsk());
        }
        if(args[1].equals("bc")) {
                backwardc backward = new backwardc(nFile);
                System.out.println("BC output: " + backward.testAsk());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }





    }
}
