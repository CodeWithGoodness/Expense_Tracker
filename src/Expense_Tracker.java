import java.io.*;
import java.text.SimpleDateFormat;
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

class Methods implements Serializable {
    SimpleDateFormat format = new SimpleDateFormat("DD/MM/YYYY");
    private ArrayList<String> listTitle = new ArrayList<>();
    private ArrayList<String> listDate = new ArrayList<>();
    private ArrayList<Double> listAmount = new ArrayList<>();
    private ArrayList<String> listDescription = new ArrayList<>();
    int sum;

    public void Display() {
        System.out.println("What would you like to do? " +
                "\n 1.Add an Expense \n 2.Check list of Expenses \n 3. Delete an Expense \n 4.Exit");
        Options();
    }

    public void Options() {
        Scanner input = new Scanner(System.in);
        String option = input.next();
        switch (option) {
            case "1":
                OptionAdd();
                break;
            case "2":
                OptionCheck();
                break;
            case "3":
                OptionDelete();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("Enter a number from 1-4");
        }
    }

    public void OptionAdd() {
        Scanner input = new Scanner(System.in);
        Date now = new java.util.Date();
        System.out.print("How many expenses do you want to add? ");
        try {
            int number = input.nextInt();
            System.out.println("Enter in this order: Amount, title");
            for (int i = 0; i < number; i++) {
                listAmount.add(input.nextDouble());
                listTitle.add(input.next());
                listDate.add(format.format(now));
            }
        } catch (InputMismatchException ex) {
            System.out.println("Error: Invalid input");
        }
    }

    public void OptionDelete() {
        if (listTitle.isEmpty())
            System.out.println("Your expense list is empty");
        else
            deleteSearch();
    }
    public void OptionCheck() {
        if (listTitle.isEmpty())
            System.out.println("Your expense list is empty");
        else {
            for (int i = 0; i < listTitle.size(); i++) {
                System.out.println(listTitle.get(i) + "\t \t" + listAmount.get(i) + "\t \t" + "\t \t" + listDate.get(i));
            }
        }
    }
    public void deleteSearch() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input title of expenses to delete. Press 1 to go back");//search by title
        for (int i = 0, j; i <= listTitle.size(); i++) {
            String search = input.next();
            if (listTitle.contains(search)) {
                j = listTitle.indexOf(search);
                listTitle.remove(search);
                listAmount.remove(j);
                listDate.remove(j);
            } else if (search.equals("1")) {
                Display();
            } else
                System.out.println("Expense not found");
        }
    }

    public void Sum() {
        for (int i = 0; i < listAmount.size(); i++) {
            sum += listAmount.get(i);
        }
        System.out.println("Total amount: " + sum);
        sum = 0;
    }
}
