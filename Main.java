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


        if(args.length < 1){
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

            for(int i = 0; i < nFile.getp().size();i++) {
                System.out.println(nFile.getp().get(i).getListA());
                for (int j=0; j<nFile.getp().get(i).listAcount();j++){
                   // System.out.println(nFile.getp().get(i).getListAIndex(j));
                }
               // System.out.println(nFile.getp().get(i).getListAIndex(i));
            }
            System.out.println(nFile.getq());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }





    }
}
