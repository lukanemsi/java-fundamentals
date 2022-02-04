package emailapplication;

public class EmailApp
{

    public static void main(String[] args)
    {
        Email johnsEmail = new Email("John","Cage");
        johnsEmail.changePassword("ValidPassword9");
        johnsEmail.setMailBoxCapacity(60);
        johnsEmail.setAlternateEmailAddress("john.cage@gmail.com");
        johnsEmail.getAlternateEmailAddress();
        johnsEmail.getGeneratedMail();
    }
}
