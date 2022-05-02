import java.util.*;
public class Expense_Tracker {  //for recording expenses
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        Methods exp = new Methods();
        System.out.println("EXPENSE TRACKER");//Display
        while (true) {
                exp.Display();

        }
    }
}

class Methods {
    String option = "";
    private ArrayList<String> listTitle = new ArrayList<>();
    private ArrayList<Date> listDate = new ArrayList<>();
    private ArrayList<Double> listAmount = new ArrayList<>();
    private ArrayList<String> listDescription = new ArrayList<>();
    int sum;
    Methods(){
    }
    public void Display(){
        System.out.println("What would you like to do? " +
                "\n 1.Add an Expense \n 2.Check list of Expenses \n 3. Delete an Expense \n 4.Exit");
        Options();
    }
    public void Options (){
        Scanner input = new Scanner(System.in);
        String  option = input.next();
        if (option.equals("1"))
            OptionAdd();
        else if (option.equals("2"))
            OptionCheck();
        else if (option.equals("3"))
            OptionDelete();
        else if(option.equals("4"))
            System.exit(0);
        else
            System.out.println("Enter a number from 1-4");
    }
    public void OptionAdd (){
        Scanner input = new Scanner(System.in);
        Date now = new java.util.Date();
        System.out.print("How many expenses do you want to add? ");
        try {
            int number = input.nextInt();
            System.out.println("Enter in this order: title, Description, Amount ");
            for (int i = 0; i < number; i++) {
                    listTitle.add(input.next());
                    listDescription.add(input.next());
                    listAmount.add(input.nextDouble());
                    listDate.add(now);
                }
        }
        catch (Exception ex){
            System.out.println("Invalid number");
        }
    }
    public void OptionCheck() {
        if (listTitle.isEmpty())
            System.out.println("Your expense list is empty");
        else {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.printf("%-20s%-15s%-15s%-10s", "TITLE","DESCRIPTION", "AMOUNT", "DATE");
            System.out.println();
            System.out.println("----------------------------------------------------------------------------------");
            setExpense();
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("Total Amount: "+ Sum());
        }
    }
    public void OptionDelete(){
        if (listTitle.isEmpty())
            System.out.println("Your expense list is empty");
        else
            deleteSearch();
    }
    public void setExpense(){
        for (int i = 0; i < listTitle.size(); i++) {
            System.out.printf("%-20s%-15s$%-15.2f%-10s", listTitle.get(i),
                    listDescription.get(i),listAmount.get(i), listDate.get(i));
            System.out.println();
        }
    }
    public void deleteSearch(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input title of expenses to delete. Press 1 to go back");//search by title
        for (int i = 0, j; i <= listTitle.size(); i++) {
            String search = input.next();
            if (listTitle.contains(search)) {
                j = listTitle.indexOf(search);
                System.out.println(j);
                listTitle.remove(search);
                listDescription.remove(j);
                listAmount.remove(j);
                listDate.remove(j);
            }
            else if (search.equals("1")){
                Display();
            break;}
            else
                System.out.println("Expense not found");
        }
    }
    public double Sum(){
        for (int i = 0; i < listAmount.size(); i++) {
            sum += listAmount.get(i);
        }return sum;
    }
}