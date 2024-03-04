import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner sc;
    static ArrayList<String> array=new ArrayList<>();
    public static void main(String[] args) {
        sc=new Scanner(System.in);
        System.out.println("Welcome to Mobile Ordering program");
        int choice1;
        do{
        System.out.println("Please enter 1 for SignUp");
        System.out.println("Please enter 2 for Quit");
        System.out.print("Enter your choice::");
        choice1=sc.nextInt();
        sc.nextLine();
            switch(choice1){
            case 1:
            SignUp();
            System.out.println();
            System.out.println("You have sucessfully singed up");
            break;
            case 2:
            Quit();
            break;
            default: System.out.println("Invaild input");
        }
        }while(choice1!=2);   
    }

    private static void SignUp(){
        
        //for user name
        System.out.print("enter your name");
       String name=sc.nextLine();

       //for checking if the length of name is greater than 4
       if(name.length()<4){
           System.out.println("Length of name should be grerater than 4\n\nPlease start again");
           SignUp();
       }
       //for user mobile number
       else{
       System.out.print("enter mobile number");
       String mobile=sc.nextLine();

       //for checking if the mobile number is of 10 digits
       if(mobile.length()!=10){
           System.out.println("Incorrect mobile number\n\nPlease start again");
           SignUp();
       }
       
       //for user password
       else{
            System.out.print("Enter your password::");
            String password=sc.nextLine();
            
            //for checking if the password is valid or not
            //vaild password-> first word should be character and last word should be number
            int passwordLength=password.length();
            char firstWord=password.charAt(0);
            char lastWord=password.charAt(passwordLength-1);            
            if(firstWord<'a' && firstWord>'z' || firstWord<'A' && firstWord>'Z'){                
                  if(lastWord>9 && lastWord<0){
                    System.out.println("Invalid password entry\nPlease start again");
                    System.out.println();
                    SignUp();   
                }                                                
            }
            
            //for password confirmation
            else{
                System.out.print("Please confirm your password::");
                String confirmPassword=sc.nextLine();

                //for checking if the password matches with the initial password
                if(!password.equals(confirmPassword)){
                    System.out.println("Your password doesnot match\n\nPlease start again");                    
                    SignUp();
                }
                
                //for dob
                else{
                    System.out.print("ENter your dob(DD/MM/YYYY)::");
                    String dob=sc.nextLine();
                    
                    //getting year from dob
                    String arr[]=dob.split("/");
                    int yob=Integer.parseInt(arr[2]);

                    //getting current year
                    LocalDate today = LocalDate.now();
                    int yearToday=today.getYear();
                    
                    //age 
                    int age=yearToday-yob;
                    if(age<20){
                        System.out.println("You shoukd be atleast 21 years old\n");
                        SignUp();
                    }
                     //saving user data in array
                array.add(name);
                array.add(mobile);
                array.add(password);
                array.add(dob);
                }
            }          
        }
       }
    }
        private static void Quit(){
        System.out.println("Thank you!");
   }
}
