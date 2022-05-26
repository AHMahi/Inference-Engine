import java.util.ArrayList;


public class forwardc {

    private ArrayList<horn> clauses;
    private ArrayList<String> facts;
    private  ArrayList<String> factsout;
    private String query;

    public forwardc(Read_file aBase)
    {
        clauses= aBase.getClauses();
        facts= aBase.getFacts();
        query = aBase.getAsk();

        factsout = new ArrayList<String>();
    }

    public boolean FactsCheck(){
        // search through all the elements in fact lists
        while(!facts.isEmpty())
        {
            //pop an element from facts list and adding to aFacts
            String aFacts = facts.remove(0);
            // adding a string into a factsout arraylist
            factsout.add(aFacts);

            // checking if the facts and the query which is ask is the same
            if(aFacts.equals(query))
            {
                return true;
            }

            //using the size and counts of clauses to run a for loop to get the listA on the right index
            for (int i=0; i< clauses.size();i++)
            {
                for(int j = 0; j<clauses.get(i).listAcount();j++)
                {
                    // if the pop element is equal to index j value, remove the value
                    if(aFacts.equals(clauses.get(i).getListAIndex(j)))
                    {
                        clauses.get(i).removelistA(aFacts);
                    }
                }
            }
            for (int i = 0; i < clauses.size();i++)
            {
                if(clauses.get(i).listAcount() == 0)
                {
                    // adding one element from clauses to the facts so we can check
                    facts.add(clauses.get(i).getListArrow());
                    clauses.remove(i);
                }
            }
        }
        return false;
    }
    public String testAsk()
    {
        String output="";
        if(FactsCheck())
        {
            output = "YES: ";

            for (int i =0; i<factsout.size(); i++)
            {
                output += (factsout.get(i));
                if(i<factsout.size()-1)
                {
                    output += ",";
                }
            }
        }
        else {
            output = " NO: " + query + " can not be proven";
        }
        return output;
    }
}
