import java.util.*;
public class Expense_Tracker {
    public static void main(String[]args){
    Scanner input = new Scanner (System.in);
    Date now = new java.util.Date();
    Methods exp = new Methods("",0,"");
    System.out.println("EXPENSE TRACKER" );
       while (true) {
           System.out.println("What would you like to do? " +
                   "\n 1.Add an Expense \n 2.Check list of Expenses \n 3.Edit an Expense \n 4.Exit");
          String option = input.next();
          exp.Options(option);
       }
    }
}

class Methods {
    private ArrayList<String> listArray = new ArrayList<>();
    public Methods(String listTitle, double amount, String tags) {
    }
    public void Option1 (){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter in this order: title, amount, tag ");
        for (int row = 0; row < listArray.size(); row++) {
                listArray.add(input.next());

        }
    }
    public void Option2(){
        if (listArray .isEmpty()){
            System.out.println("Your expense list is empty");}
        else {
            System.out.println("Your expenses are as follows: ");
            for (int row = 0; row < listArray.size(); row++) {
                    System.out.print(listArray.get(row) + " ");
            }
        }
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