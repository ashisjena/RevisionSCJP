package scjp.com.java.miscellaneous.mailing;

import java.util.Properties;
import java.util.List;

public class SmtpMail
{
    public static void sendMail( List< String > toAddresses, List< String > ccAddresses, String subject, String body )
    {
        // call the worker method
        MailHelper.sendMail( SmtpMail.getSmtpProperties(), toAddresses, ccAddresses, subject, body );
    }

    public static Properties getSmtpProperties()
    {
        // get the system properties
        Properties properties = System.getProperties();

        // turn on authentication and set the user and password properties
        properties.setProperty( "mail.smtp.auth", "true" );
        properties.setProperty( "mail.smtp.user", "ashisjena.talk2u@gmail.com" );
        properties.setProperty( "mail.smtp.password", "password" );

        // get and set the SMTP properties from our *server* property list
        properties.setProperty( "mail.smtp.from", "ashisjena.talk2u@gmail.com" );
        properties.setProperty( "mail.smtp.host", "smtp.gmail.com" );
        properties.setProperty( "mail.smtp.port", "587" );

        // turn on *send partial* so invalid addresses don't prevent others from being delivered
        properties.setProperty( "mail.smtp.sendpartial", "true" );

        // return the SMTP properties list
        return properties;
    }

}