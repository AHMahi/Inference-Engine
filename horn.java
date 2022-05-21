import java.util.LinkedList;


public class horn {
    private LinkedList<String> listA;
    private String listArrow;

//listA is the front element of the clause
    // listarrow is the back element of the clauses
    public horn(String inputA){
        listA = new LinkedList<String>();
        String[] splitarrow = inputA.split("=>");
        String[] splitand = splitarrow[0].split("&");

        for(int i =0; i < splitand.length; i++){
            listA.addLast(splitand[i]);
        }
        listArrow = splitarrow[1];
    }

    public LinkedList<String >getListA(){

        return listA;
    }


    public String getListAIndex(int index)
    {
        try {
            if (index >= 0 && index < listA.size()) {
                return listA.get(index);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            System.exit(3);
            return null;
        }

    }

    public void removelistA(String list){
        listA.remove(list);
    }
    public  int listAcount(){
        return listA.size();
    }

    public String getListArrow() {
        return listArrow;
    }

    //@override
    public String toString(){
        String returnString ="";
    for(int i =0; i<listA.size();i++){
        if(i != 0){
            returnString += "^";
        }
        returnString += listA.get(i);
    }
    returnString += "=>";
    return returnString;
    }

}

