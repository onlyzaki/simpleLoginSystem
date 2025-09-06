import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        String email;
        String password;
        String phoneNumber;
        String userName;
        String domain;

        int emailLength;
        int atIndex;
        int dotIndex;
        int passwordLength;
        
        boolean valid = false;
        boolean emailValid;
        boolean passwordValid;
        boolean phoneNumValid;
        Scanner scanner = new Scanner(System.in);
        do {


            //get email:
            System.out.print("what's your email: ");
            email = scanner.nextLine();
            emailLength = email.length();
            atIndex = email.indexOf("@");
            dotIndex = email.indexOf(".");

            //validate Email format:
            emailValid = atIndex > 0 && atIndex < dotIndex && emailLength > 5 && email.matches(".*[A-Za-z].*") && dotIndex < emailLength -1;
            if (emailValid) {
                //put username/domain:
                userName = email.substring(0, atIndex);
                domain = email.substring(atIndex + 1);
            } else {
                System.out.println("invalid email address, try again!");
                continue;
            }

            //get password:
            System.out.print("what's your password: ");
            password = scanner.nextLine();
            passwordLength = password.length();

            //validate password format:
            passwordValid =  passwordLength > 8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[0-9].*");
            if (!passwordValid){
                System.out.println("invalid password, try again!");
                continue;
            }else {
                System.out.println("Password accepted!");
            }

            //get phoneNumber:
            System.out.print("what's your phone number: ");
            phoneNumber = scanner.nextLine().trim();

            //validate phoneNumber:
            phoneNumValid = phoneNumber.matches("\\+\\d{10,14}");
            if (!phoneNumValid){
                System.out.println("invalid phone number, try again!");
                continue;
            }else {
                System.out.println("phone number accepted!");
                System.out.println(userName);
                System.out.println(domain);
                valid = true;
            }
        }

        while (!valid);



        scanner.close();
    }
}
