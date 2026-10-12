import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1
        Scanner input = new Scanner(System.in);

        try{
            System.out.println("Enter the first number: ");
            int a1=input.nextInt();
            System.out.println("Enter the second number: ");
            int a2=input.nextInt();

            int c = a1/a2;
            System.out.println(c);
        }
        catch(ArithmeticException e){
            System.out.println("/ by zero");
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input");
        }

        //2
        String[] names = new String[]{"Ali", "Vüsal", "Aysel"};

        try {
            System.out.println("Enter the index: ");
            int index = input.nextInt();
            System.out.println(names[index]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("array index out of bounds");
        }

        //3
        //A3 String array-dəki dəyərləri int-ə çevirin: {"12", "abc", "7", "", "3.5", "-4"}.
        // Hər element üçün ya nəticəni,
        // ya da “X: rəqəm deyil” mesajını çap edin. Sonda düzgün çevrilənlərin cəmini tapın
        String[] arr = new String[]{"12", "abc", "7", "", "3.5", "-4"};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
           try{
               int num = Integer.parseInt(arr[i]);
               System.out.println(arr[i] + " -> " + num);
               sum += num;
           }
           catch (NumberFormatException e){
               System.out.println("not number");
           }
            System.out.println(sum);
        }

        //4
        try {
            registerUser("Elvira", 22);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            registerUser("Aytac", 16);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        //5
        System.out.println(parseIntOrDefault("123", -1));
        System.out.println(parseIntOrDefault("abc", -1));

        System.out.println(parseDoubleOrDefault("3.14", 0.0));
        System.out.println(parseDoubleOrDefault("abc", 0.0));

    }
    //4
    public static void registerUser(String name, int age){
        if(age < 18 || age > 120){
            throw new InvalidAgeException("User not found with age " + age);
        }
        System.out.println("User with name " + name + " is registered" + " with age " + age);
    }

    //5
    public static int parseIntOrDefault(String s, int def){
        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            return def;
        }

    }

    public static double parseDoubleOrDefault(String s, double def){
        try {
            return Double.parseDouble(s);
        }
        catch (NumberFormatException e){
            return def;
        }
    }
}