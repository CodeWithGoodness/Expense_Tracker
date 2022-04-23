import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
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
    private ArrayList<Object> title = new ArrayList<>();
    String listTitle;
    private double amount;
    private String tags;

    public Methods(String listTitle, double amount, String tags) {
        this.listTitle = listTitle;
        this.amount = amount;
        this.tags = tags;
    }
    public  void Options (String option){
        if(option.equals("4"))
            System.exit(0);
        else
            System.out.println("error");
    }

    public String getTitle() {
        for (int i = 0; i < title.size(); i++) {
            if (title.contains(listTitle)) ;
        }
        return listTitle;
    }

    public void setTitle(String listTitle) {
        title.add(listTitle);
    }
}