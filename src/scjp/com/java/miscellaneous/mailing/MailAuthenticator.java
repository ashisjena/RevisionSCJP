package scjp.com.java.miscellaneous.mailing;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;

public class MailAuthenticator extends Authenticator
{
    private String username;
    private String password;

    public MailAuthenticator( Properties properties )
    {
        // get the SMTP username and password properties
        this.username = properties.getProperty( "mail.smtp.user" );
        this.password = properties.getProperty( "mail.smtp.password" );
    }

    public PasswordAuthentication getPasswordAuthentication()
    {
        // return the authentication username and password
        return new PasswordAuthentication( username, password );
    }
}
