/*
string.length(); give the length of string
String.charAt(num); means the letter in the index number
String.indexOf(char); checks on what index is the char
String.lastIndex(char);
String.trim(); remove blanks
String.replaceAll("" , "");
String.isEmpty();
String.contains(" ");
String.substring(num,num);
*/


import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        //Declare variables:
        String email;
        String password;
        String phoneNumber;
        String userName;
        String domain;
        String newPhoneNum;
        int emailLength;
        int atIndex;
        int dotIndex;
        int passwordLength;

        boolean valid = false;
        boolean emailValid;
        boolean phoneNumValid;
        Scanner scanner = new Scanner(System.in);
        //loop:
        do {
            //get email:
            System.out.print("what's your email: ");
            email = scanner.nextLine().trim();
            emailLength = email.length();
            atIndex = email.indexOf("@");
            dotIndex = email.indexOf(".");

            //validate Email format:
            emailValid = atIndex > 0 && atIndex < dotIndex && emailLength > 5 && email.matches(".*[a-z].*") && dotIndex < emailLength -1;
            if (emailValid) {
                valid = true;
            } else {
                System.out.println("invalid email address, try again!");
                continue;
            }
        }
        while (!valid);
        valid = false;
        //put username/domain:
        userName = email.substring(0, atIndex);
        domain = email.substring(atIndex + 1);
        do {
            //get password:
            System.out.print("what's your password: ");
            password = scanner.nextLine().trim();
            passwordLength = password.length();

            //validate password format:
            //  &&  &&  &&
            if (passwordLength < 8) {
                System.out.println("password is too short, try again!");
                continue;
            } else if (!(password.matches(".*[A-Z].*"))) {
                System.out.println("password should have at least one uppercase letter, try again!");
                continue;
            } else if (!(password.matches(".*[a-z].*"))) {
                System.out.println("password should have a combination of upper/lowercase letters, try again!");
                continue;
            } else if (!(password.matches(".*[0-9].*"))) {
                System.out.println("password should have at least one number, try again!");
                continue;
            } else {
                System.out.println("Password accepted!");
                valid = true;
            }
        }
        while (!valid);
        valid = false;
        do {


            //get phoneNumber:
            System.out.print("what's your phone number: ");
            phoneNumber = scanner.nextLine().trim();

            //validate phoneNumber:
            phoneNumValid = phoneNumber.matches("\\+\\d{10,14}");
            if (!phoneNumValid) {
                System.out.println("invalid phone number, try again!");
                continue;
            } else {
                System.out.println("phone number accepted!");
                System.out.println("your username is: " + userName);
                System.out.println("your domain is: " + domain);
                newPhoneNum = phoneNumber.replace("+213", "0");
                System.out.println("your phone number is: " + newPhoneNum);
                valid = true;
            }
        }
        while (!valid);
        System.out.println("Thank you for using my email check program, by onlyzaki");
        scanner.close();
    }
}
