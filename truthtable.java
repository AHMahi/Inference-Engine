import java.util.ArrayList;


public class truthtable {

    private ArrayList<horn> clauses;
    private ArrayList<String> facts;
    private String query;
    private ArrayList<String > elementlist;
    private int columnsize;
    private int rowsize;
    private boolean [][] table;
    private boolean [] tableSetup;
    private int[] factsIndex;
    private int[] arrow;
    private int queryIndex;
    private int[][] listAIndex;
    private boolean[] queryResult;
    private int truthCount;



    public truthtable(Read_file aBase){
        clauses = aBase.getClauses();
        facts = aBase.getFacts();
        query = aBase.getAsk();
        elementlist = new ArrayList<String >();
        getElements();

        columnsize = elementlist.size();
        rowsize = ((int)Math.pow(2,columnsize));
        table = new boolean[rowsize][columnsize];
        tableSetup = new boolean[rowsize];
        queryResult = new boolean[rowsize];
        factsIndex = new int[facts.size()];
        listAIndex = new int[clauses.size()][2];
        arrow = new int[clauses.size()];
        table_setup();
        PopulateTable();
        ColumnIndexfacts();
        ColumnIndexlistA();


    }

    public void getElements(){

// adding listA which is the literal and listarrow which is the
// entailment in to an arraylist and check for duplicate
        for(int i = 0; i< clauses.size();i++)
        {
            for(int j = 0; j<clauses.get(i).listAcount();j++)
            {
                if(!elementlist.contains(clauses.get(i).getListAIndex(j)))
                {
                 elementlist.add(clauses.get(i).getListAIndex(j));
                }
            }
            if(!elementlist.contains(clauses.get(i).getListArrow()))
            {
                elementlist.add(clauses.get(i).getListArrow());
            }
        }
    }

    public String testTruth(){
        String result = "";
        String abc="";

        if(FactsCheck())
        {
            result = "Yes: " + truthCount;
        }
        else
        {
            result = "No: " + query + " can not be proven ";
        }
        for(int i =0; i<elementlist.size();i++)
        {
            abc += elementlist.get(i);
            abc += " , ";
        }


        return result;
    }

    public boolean FactsCheck()
    {
        for(int i =0; i < rowsize;i++)
        {
            for(int j =0; j < factsIndex.length;j++)
            {
                //
                if(tableSetup[i])
                {
                    if(!table[i][queryIndex])
                    {
                        tableSetup[i] = false;
                        queryResult[i]= false;
                        break;
                    }
                    else
                    {
                        queryResult[i] = true;
                    }
                    tableSetup[i] = table[i][factsIndex[j]];
                }
                else {
                    break;
                }
            }
        }

        for(int i = 0; i< rowsize; i++)
        {
            if(tableSetup[i])
            {
                for (int j =0; j < listAIndex.length;j++)
                {
                    if(clauses.get(j).listAcount() == 2)
                    {
                        if((table[i][listAIndex[j][0] ]== true)
                            && (table[i][listAIndex[j][1]]==true)
                            && (table[i][arrow[j]] == false))
                        {
                            tableSetup[i] = false;
                        }

                    }
                    else
                    {
                        if((table[i][listAIndex[j][0]]==true)
                            && (table[i][arrow[j]]== false))
                        {
                            tableSetup[i] = false;
                        }
                    }
                }
            }
        }

        for(int i=0; i< rowsize;i++)
        {
            if(tableSetup[i])
            {
                truthCount ++;
            }
            if(queryResult[i] == false && tableSetup[i] == true)
            {
                return false;
            }
        }
        return true;
    }

    public void table_setup(){
        // setting up the table with true for every position in the row
        for(int i = 0; i <rowsize;i++)
        {
            tableSetup[i] = true;
        }

    }

    public void PopulateTable()
    {

        // Populate the table from first row of each position in the column
        for (int i=0;i<rowsize;i++)
        {
            for (int j=0;j<columnsize;j++)
            {

                int x = i & 1 <<columnsize -1-j;
                table[i][j] = (x ==0? true:false);

            }
        }
    }

    public void ColumnIndexfacts()
    {

        // checking the facts against the element of elementlist we added(listA and listarrow)

        for(int i =0; i<facts.size();i++)
        {
            for(int j=0;j< elementlist.size();j++)
            {
                if(facts.get(i).equals(elementlist.get(j)))
                {
                    factsIndex[i] =j;
                }
                if(query.equals(elementlist.get(j)))
                {
                    queryIndex = j;
                }
            }
        }
    }

    public void ColumnIndexlistA()
    {
        // checking the clausese against the element of elementlist, if it is equal, we set the index
        for(int i =0; i < elementlist.size();i++)
        {
            for(int j = 0; j<clauses.size();j++)
            {
                for(int k = 0;k <clauses.get(j).listAcount();k++)
                {
                    if(clauses.get(j).getListAIndex(k).equals(elementlist.get(i)))
                    {
                        listAIndex[j][k] =i;
                    }
                }
                if(clauses.get(j).getListArrow().equals(elementlist.get(i)))
                {
                    arrow[j] =i;
                }
            }
        }
    }
}
