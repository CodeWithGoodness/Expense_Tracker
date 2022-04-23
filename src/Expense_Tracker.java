import java.util.*;
public class Expense_Tracker {
    public static void main(String[]args){
    Scanner input = new Scanner (System.in);
    Date now = new java.util.Date();
    Methods exp = new Methods("",0,"");
    System.out.println("EXPENSE TRACKER" );
       while (true) {
           System.out.println("What would you like to do? " +
                   "\n 1.Add an Expense \n 2.Check list of Expenses \n 3. Delete an Expense \n 4.Exit");
          String option = input.next();
          exp.Options(option);
       }
    }
}

class Methods {
    private ArrayList<String> listTitle = new ArrayList<>();
    private ArrayList<String> listAmount = new ArrayList<>();
    private ArrayList<String> listTag = new ArrayList<>();
    private ArrayList<ArrayList<String>> collection = new ArrayList();
    public Methods(String listTitle, double amount, String tags) {
    }
    public void Option1 (){
        Scanner input = new Scanner(System.in);
        System.out.println("How many expenses do you want to add?");
        int number = input.nextInt();
        System.out.println("Enter in this order: title, amount, tag ");
        for (int i = 1; i <= number; i++) {
            listTitle.add(input.next());
            listAmount.add(input.next());
            listTag.add(input.next());
            collection.add(listTitle);
            collection.add(listAmount);
            collection.add(listTag);
        }
    }
    public void Option2(){
        if (collection.isEmpty()){
            System.out.println("Your expense list is empty");}
        else {
            System.out.println("Your expenses are as follows: ");
            for (int i = 0; i < collection.get(1).size(); i++) {
                    System.out.print( collection.get(0).get(i) + ": " + collection.get(1).get(i) +"(" + collection.get(2).get(i)+ ")" );
                    System.out.println();
            }
        }
    }
    public void Option3(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input expense to delete");
        String search = input.next();
        if ( listTitle.contains(search))
            listTitle.remove(search);
    }
    public  void Options (String option){
        if (option.equals("1"))
            Option1();
        if (option.equals("2"))
            Option2();
        if(option.equals("4"))
            System.exit(0);
        else
            System.out.println("error");
    }
}