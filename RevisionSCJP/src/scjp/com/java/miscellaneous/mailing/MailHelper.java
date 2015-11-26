package scjp.com.java.miscellaneous.mailing;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

//import com.azure.sparkcommon.StringHelper;

public class MailHelper
{
    public static void sendEmail( List< String > toAddresses, List< String > ccAddresses, List< String > bccAddresses, String subject, String body, List< File > attachedFiles )
    {
        sendEmailWithAttachment( SmtpMail.getSmtpProperties(), toAddresses, ccAddresses, bccAddresses, subject, body, attachedFiles );
    }
    
    public static void sendMail( Properties properties, List< String > toAddresses, List< String > ccAddresses, String subject, String body )
    {
        // sanity check
        if ( !hasAddresses( toAddresses ) && !hasAddresses( ccAddresses ) )
            return;

        // get a default mailer session instance
        Session session = Session.getDefaultInstance( properties, new MailAuthenticator( properties ) );

        // create a new message
        final Message messageF = new MimeMessage( session );

        try
        {
            // set the message fields
            messageF.setSubject( subject );
            messageF.setText( body );
            messageF.setSentDate( new Date() );

            // add the message recipients
            addRecipients( messageF, toAddresses, Message.RecipientType.TO );
            addRecipients( messageF, ccAddresses, Message.RecipientType.CC );
        }
        catch ( MessagingException e )
        {
            throw new RuntimeException( "Failed to build mail message", e );
        }

        // send the message in it's own thread
        new Thread( new Runnable()
        {
            public void run()
            {
                try
                {
                    Transport.send( messageF );
                }
                catch ( MessagingException e )
                {
                    System.out.println( "Failed to send email message" + e.getMessage() );
                }
            }
        }, "Send Message" ).start();
    }

    private static void sendEmailWithAttachment( Properties properties, List< String > toAddresses, List< String > ccAddresses, List< String > bccAddresses, String subject, String body, List< File > attachedFiles )
    {
        if ( !hasAddresses( toAddresses ) && !hasAddresses( ccAddresses ) && !hasAddresses( bccAddresses ) )
            throw new RuntimeException( "No recipients found." );

        Session session = Session.getInstance( properties, new MailAuthenticator( properties ) );

        final MimeMessage message = new MimeMessage( session );
        try
        {
            message.setSentDate( new Date() );
            message.setSubject( subject );

            addRecipients( message, toAddresses, RecipientType.TO );
            addRecipients( message, ccAddresses, RecipientType.CC );
            addRecipients( message, bccAddresses, RecipientType.BCC );

            MimeBodyPart msgBodyPart = new MimeBodyPart();
            msgBodyPart.setContent( body, "text/html; charset=UTF-8" );

            Multipart multiPart = new MimeMultipart();
            multiPart.addBodyPart( msgBodyPart );

            if ( attachedFiles != null && attachedFiles.size() != 0 )
            {
                for ( File attachedFile : attachedFiles )
                {
                    MimeBodyPart msgAttachement = new MimeBodyPart();
                    DataSource source = new FileDataSource( attachedFile.getAbsoluteFile() );
                    msgAttachement.setDataHandler( new DataHandler( source ) );
                    msgAttachement.setFileName( attachedFile.getName() );
                    multiPart.addBodyPart( msgAttachement );
                }
            }

            message.setContent( multiPart );
        }
        catch ( MessagingException e )
        {
            throw new RuntimeException( "Failed to create E-Mail Message", e );
        }
        
     // send the message in it's own thread
        new Thread( new Runnable()
        {
            public void run()
            {
                try
                {
                    Transport.send( message );
                }
                catch ( MessagingException e )
                {
                    System.out.println( "Failed to send email message : " + e.getMessage() );
                }
            }
        }, "Send Message" ).start();
    }

    private static boolean hasAddresses( List< String > addresses )
    {
        // sanity check
        if ( addresses == null )
            return false;

        // check each address to see if we have any specified
        for ( String address : addresses )
        {
            //if ( !StringHelper.isEmpty( address ) )
                return true;
        }

        // if we got here we didn't find any addresses
        return false;
    }

    private static void addRecipients( Message message, List< String > addresses, Message.RecipientType type ) throws MessagingException
    {
        // sanity check
        if ( addresses == null )
            return;

        // add each of the address from the list to our message
        for ( String address : addresses )
        {
            // ignore if this address is empty
            //if ( StringHelper.isEmpty( address ) )
                continue;

            // add to the message
            //message.addRecipient( type, new InternetAddress( address, false ) );
        }
    }
    
    public static void sendMail( Properties properties, List< String > toAddresses, List< String > ccAddresses, String subject, String body, List< String > attachments )
    {
        // sanity check
        if ( !hasAddresses( toAddresses ) && !hasAddresses( ccAddresses ) )
            return;

        // get a default mailer session instance
        Session session = Session.getDefaultInstance( properties, new MailAuthenticator( properties ) );

        // create a new message
        final Message messageF = new MimeMessage( session );

        try
        {
            // set the message fields
            messageF.setSubject( subject );
            messageF.setSentDate( new Date() );

            // add the message recipients
            addRecipients( messageF, toAddresses, Message.RecipientType.TO );
            addRecipients( messageF, ccAddresses, Message.RecipientType.CC );

            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setContent( body, "text/html" );

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart( messagePart );

            for ( String attachment : attachments )
            {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                FileDataSource fileDataSource = new FileDataSource( attachment );

                attachmentPart.setDataHandler( new DataHandler( fileDataSource ) );
                attachmentPart.setFileName( attachment );
                multipart.addBodyPart( attachmentPart );
            }

            messageF.setContent( multipart );

        }
        catch ( MessagingException e )
        {
            System.out.println( "Failed to build mail message" );
        }

        // send the message in it's own thread
        new Thread( new Runnable()
        {
            public void run()
            {
                try
                {
                    Transport.send( messageF );
                }
                catch ( MessagingException e )
                {
                    System.out.println( "Failed to send email message : " + e.getMessage() );
                }
            }
        }, "Send Message" ).start();
    }
}