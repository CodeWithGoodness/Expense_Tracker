import java.util.*;
public class Expense_Tracker {  //for recording expenses
    public static void main(String[]args){
    Scanner input = new Scanner (System.in);
    Methods exp = new Methods();
    System.out.println("EXPENSE TRACKER" );//Display
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
    private ArrayList<Date> listDate = new ArrayList<>();
    private ArrayList<Double> listAmount = new ArrayList<>();
    private ArrayList<String> listTag = new ArrayList<>();
    int sum;

     Methods(){

     };

    public  void Options (String option){
        if (option.equals("1"))
            Option1();
        else if (option.equals("2"))
            Option2();
        else if (option.equals("3"))
            Option3();
        else if(option.equals("4"))
            System.exit(0);
        else
            System.out.println("error");
    }
    public void Option1 (){
        Scanner input = new Scanner(System.in);
        Date now = new java.util.Date();
        System.out.print("How many expenses do you want to add?");
        int number = input.nextInt();
        System.out.println("Enter in this order: title, amount, tag ");
        for (int i = 1; i <= number; i++) {
            listTitle.add(input.next()) ;
            listAmount.add(input.nextDouble());
            listTag.add(input.next());
            listDate.add(now);
        }
    }
    public void Option2() {
        if (listTag.isEmpty())
            System.out.println("Your expense list is empty");
        else {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.printf("%-20s%-15s%-15s%-10s", "TITLE", "AMOUNT", "TAG", "DATE");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------");
            setExpense();
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Total Amount: "+ getSum());
        }
    }
    public void Option3(){
        if (listTitle.isEmpty())
            System.out.println("Your expense list is empty");
        else
            deleteSearch();
    }
    public void setExpense(){
        for (int i = 0; i < listTitle.size(); i++) {
            System.out.printf("%-20s$%-15.2f%-15s%-10s", listTitle.get(i),listAmount.get(i),
                    listTag.get(i), listDate.get(i));
            System.out.println();
        }
    }
    public void deleteSearch(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input title of expense to delete");//search by title
        for (int i = 0, j; i < listTitle.size(); i++) {
            String search = input.next();
            if (listTitle.contains(search)) {
                j = listTitle.indexOf(search);
                listTitle.remove(search);
                listAmount.remove(j);
                listTag.remove(j);
                listDate.remove(j);
            }
        }
    }
    public double getSum(){
        for (int i = 0; i < listAmount.size(); i++) {
            sum += listAmount.get(i);
        }return sum;
    }
}