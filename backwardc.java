import java.util.ArrayList;

public class backwardc {
    private ArrayList<horn> clauses;
    private ArrayList<String> facts;
    private  ArrayList<String> factsout;
    private String query;
    private ArrayList<String> aQueries;

    public backwardc(Read_file aBase)
    {
        clauses= aBase.getClauses();
        facts= aBase.getFacts();
        query = aBase.getAsk();
        aQueries= new ArrayList<String>();
        factsout = new ArrayList<String>();
    }

    public boolean FactsCheck(){
        // search through all the elements in clauses lists

        aQueries.add(query);
        while(!aQueries.isEmpty())
        {
            String aQuery = aQueries.remove(0);
            factsout.add(aQuery);
            if(!compareFacts(aQuery))
            {
                if(!compareClauses(aQuery))
                {
                    return false;
                }
            }

            }

        return true;
    }


    public boolean compareFacts(String aQuery)
    {
        for(int i=0; i<facts.size();i++)
        {
            if(aQuery.equals(facts.get(i)))
            {
                return true;
            }
        }
        return false;
    }

    public boolean compareClauses(String aQuery){

        boolean result = false;
        for(int i = 0; i< clauses.size();i++)
        {
            if(aQuery.equals(clauses.get(i).getListArrow()))
            {
                result = true;
                for (int j = 0; j<clauses.get(i).listAcount();j++)
                {
                    aQueries.add(clauses.get(i).getListAIndex(j));
                }
            }
        }
        // might need to add a repeating check
        return result;

    }

    public String testAsk()
    {
        String output="";
        if(FactsCheck())
        {
            output = "YES: ";
            for(int i = 0; i<factsout.size();i++ )
            {
                output +=(factsout.get(i));
                if(i<factsout.size()-1)
                {
                    output += ",";
                }

            }
        }
        else
        {
            output = " NO: " + query + "can not be proven";

        }
        return output;
    }

}
