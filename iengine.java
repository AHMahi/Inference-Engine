import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class iengine {
    public static void main(String[] args) {

        // args contains:
        // [0] - input file
        //[1] = method
        String inputfile;


        if(args.length < 2){
            System.out.println("Usage iengine <filename> <method>.");
            System.exit(1);
        }


        // inputing file from args[1]
        //Scanner inputfile = new Scanner(args[0]);
        //Read_file newfile = new Read_file(inputfile);
        try {
            File newfile = new File(args[1]);
            Scanner scanner = new Scanner(newfile);
            Read_file nFile = new Read_file(scanner);


        if(args[0].equals("FC")){
            forwardc foward = new forwardc(nFile);
           System.out.println("FC output: " + foward.testAsk());
        }
        if(args[0].equals("BC")) {
                backwardc backward = new backwardc(nFile);

                System.out.println("BC output: " + backward.testAsk());
            }
            if(args[0].equals("TT"))
            {
                truthtable truthtable = new truthtable((nFile));
                System.out.println("truth output: " + truthtable.testTruth());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }





    }
}
