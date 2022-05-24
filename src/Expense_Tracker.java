import java.io.*;
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

class Methods implements Serializable{
    private ArrayList<String> listTitle = new ArrayList<>();
    private ArrayList<Date> listDate = new ArrayList<>();
    private ArrayList<Double> listAmount = new ArrayList<>();
    private ArrayList<String> listDescription = new ArrayList<>();
    int sum;
    public void Display(){
        System.out.println("What would you like to do? " +
                "\n 1.Add an Expense \n 2.Check list of Expenses \n 3. Delete an Expense \n 4.Exit");
        Options();
    }
    public void Options (){
        Scanner input = new Scanner(System.in);
        String  option = input.next();
        switch (option){
            case "1":
                OptionAdd();
                break;
            case "2":
                readData();
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
    public void OptionAdd (){
        Scanner input = new Scanner(System.in);
        Date now = new java.util.Date();
        System.out.print("How many expenses do you want to add? ");
        try {
            int number = input.nextInt();
            System.out.println("Enter in this order: Amount, title");
            FileOutputStream fos = new FileOutputStream("C:\\Users\\HP/goodness.txt", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < number; i++) {
                    listAmount.add(input.nextDouble());
                    listTitle.add(input.next());
                    listDate.add(now);
                oos.writeObject(listDate.get(i).toString() + ":  " + listTitle.get(i).toString() + "  " + listAmount.get(i) + "\n");
            }
            oos.flush();
            oos.close();
        }
        catch (InputMismatchException ex){
            System.out.println("Error: Invalid input");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void OptionDelete(){
        if (listTitle.isEmpty())
            System.out.println("Your expense list is empty");
        else
            deleteSearch();
    }
    public void deleteSearch(){
        Scanner input = new Scanner(System.in);
        System.out.println("Input title of expenses to delete. Press 1 to go back");//search by title
        for (int i = 0, j; i <= listTitle.size(); i++) {
            String search = input.next();
            if (listTitle.contains(search)) {
                j = listTitle.indexOf(search);
                listTitle.remove(search);
                listAmount.remove(j);
                listDate.remove(j);
            }
            else if (search.equals("1")){
                Display();
            }
            else
                System.out.println("Expense not found");
        }
    }
    public void Sum(){
        for (int i = 0; i < listAmount.size(); i++) {
           sum += listAmount.get(i);
        }
        System.out.println("Total amount: " + sum);
       sum = 0;
    }
    public  void readData(){
        try{
            File newFile = new File("C:\\Users\\HP/goodness.txt");
            FileInputStream fis = new FileInputStream("C:\\Users\\HP/goodness.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            if (newFile.length() == 0){
                System.out.println("No recorded expenses yet");
            }else {
                int i;
                while ((i = fis.read())!= -1)
                    System.out.print((char) i);
               // ArrayList listTitle2 = (ArrayList <Methods>) ois.readObject();
                ois.close();
               // System.out.println(listTitle2.toString() + "\n");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}