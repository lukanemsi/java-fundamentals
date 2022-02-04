package emailapplication;

import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Email
{
    private String firstname;
    private String lastname;
    private String password;
    private String department;
    private static HashMap<String,String> emailBase = new HashMap<>();

    private String generatedMail;
    private String alternateEmailAddress;
    private int mailBoxCapacity = 50;

    public Email(String firstname, String lastname)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        System.out.println("Email created: " + firstname +  " " + lastname );
        this.department = setDepartment();
        this.password = generateRandomPassword(10);
        System.out.println("your password is: " + this.password);

        var email = setEMail(this.firstname,this.lastname,department,password);
        System.out.println("your Email is: " + email);
    }
    private String setDepartment()
    {

        System.out.println("Enter department: \n (Sales,Development,Accounting)");
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();
        if(!(in.toUpperCase(Locale.ROOT).equals("SALES") || in.toUpperCase(Locale.ROOT).equals("DEVELOPMENT" )|| in.toUpperCase(Locale.ROOT).equals("ACCOUNTING")))
        {
            System.out.println("Invalid input try again");
            setDepartment();
        }
        return in;
    }
    // generate pass
    private String generateRandomPassword(int x)
   {
       String passPossibility = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                + "0123456789"
                                + "abcdefghijklmnopqrstuvxyz"
                                + "!@#$%^&*";
       StringBuilder password = new StringBuilder(x);
       for (int i = 0; i < x; i++)
       {
           int index  =  (int)(passPossibility.length() * Math.random());
           password.append(passPossibility.charAt(index));
       }
       return password.toString();
   }
    // set email and save it
    private String setEMail(String firstname,String lastname,String department,String password)
    {
       String mail = firstname.toLowerCase(Locale.ROOT) + "." + lastname.toLowerCase(Locale.ROOT) + "@" + department +"Company.com";
       emailBase.put(mail,password);
       generatedMail = mail;
       return mail;
    }
    public void changePassword(String newPassword)
    {
        if(validPassword(newPassword))
        {
            emailBase.replace(generatedMail,password,newPassword);
            this.password = newPassword;
            System.out.println("new password is: " + this.password );
        }
        else
        {
            System.out.println("\n Invalid password");
            return;
        }
    }
    private boolean validPassword(String newPassword)
    {

        if(newPassword.contains(" ") || newPassword.length() < 8)
        {
            System.out.println("Password can't contain space");
            System.out.println("Password should have more than 8 Character");
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasNumber = false;
        int index = 0;

        while (index < newPassword.length())
        {
            if(Character.isUpperCase(newPassword.charAt(index)))
                hasUpperCase = true;
            if(Character.isDigit(newPassword.charAt(index)))
                hasNumber = true;
            index++;
        }
        return hasNumber && hasUpperCase;
    }

    public void setMailBoxCapacity(int mailBoxCapacity)
    {
        this.mailBoxCapacity = mailBoxCapacity;
    }
    public void setAlternateEmailAddress(String alternateEmailAddress)
    {
        this.alternateEmailAddress = alternateEmailAddress;
    }
    // Getters
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getPassword() {
        return password;
    }
    public String getDepartment() {
        return department;
    }
    public static HashMap<String, String> getEmailBase() {
        return emailBase;
    }
    public String getGeneratedMail() {
        return generatedMail;
    }
    public String getAlternateEmailAddress() {
        return alternateEmailAddress;
    }
    public int getMailBoxCapacity() {
        return mailBoxCapacity;
    }
}
