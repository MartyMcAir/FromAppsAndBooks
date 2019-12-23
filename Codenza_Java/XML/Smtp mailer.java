Smtp mailer
  
 

package com.ack.j2ee.javamail;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.ack.j2ee.javamail.MailMessageBean;
import com.ack.j2ee.javamail.MailMessageUtil;

/**
 * SMTP Mailer class to handle sending SMTP emails from within the application
 */
public class SmtpMailer {
  private Session session;

  /**
   * creates an SmtpMailer object
   * @param hostName the SMTP mail server
   * @param debug set debug mode with SmtpMailer
   * @throws com.ack.j2ee.javamail.SmtpMailerException reports problems configure SmtpMailer
   */
  public SmtpMailer( String hostName, boolean debug ) throws SmtpMailerException {
    if( hostName == null ) {
      throw new SmtpMailerException( "supplied hostName was null" );
    }

    // create some properties and get the default Session
    Properties props = new Properties();
    props.put( "mail.smtp.host", hostName );
    props.put( "mail.debug", String.valueOf( debug ) );

    session = Session.getDefaultInstance( props, null );
    session.setDebug( true );
  }

  /**
   * creates an SmtpMailer object that is <b>not</b> debug mode
   * @param hostName the SMTP mail server
   * @throws com.ack.j2ee.javamail.SmtpMailerException reports problems configure SmtpMailer
   */
  public SmtpMailer( String hostName ) throws SmtpMailerException {
    this( hostName, false );
  }

  public SmtpMailer( Session mailSession ) {
    if( ( session = mailSession ) == null ) {
      throw new IllegalArgumentException( "supplied mail session was null" );
    }
  }

  /**
   * send a email message that is configured using information within the
   * MailMessageBean
   * @param MailMessageBean contains all the information need to send an
   * email message
   * @throws SmtpMailException reports problem sending the email
   * @see com.ack.j2ee.javamail.MailMessageBean
   */
  public void sendMail( MailMessageBean mb )
      throws SmtpMailerException {
    if( mb == null ) {
      throw new SmtpMailerException( "supplied mail message bean was null" );
    }

    try {
      Message msg = createMessageFromBean( mb );
      Transport.send( msg );
    }
    catch( MessagingException mex ) {
      MailMessageUtil.reportOnException( mex, System.out );
    }
  }

  /* private responsibilities
   */


  /**
   * create a JavaMail message from a MailMessageBean
   */
  private Message createMessageFromBean( MailMessageBean mb )
      throws MessagingException, SmtpMailerException {
    Message msg = new MimeMessage( session );

    if( mb.getFromAddress() == null ) {
      throw new SmtpMailerException( "mandatory from address not supplied" );
    }
    msg.setFrom( new InternetAddress( mb.getFromAddress() ) );

    List recipients = mb.getToAddresses();
    if( recipients == null || recipients.isEmpty() ) {
      throw new SmtpMailerException( "mandatory to addresses not supplied" );
    }
    msg.setRecipients( Message.RecipientType.TO, createAddresses( recipients ) );

    if( mb.getSubject() == null ) {
      throw new SmtpMailerException( "mandatory subject line was not supplied" );
    }
    msg.setSubject( mb.getSubject() );
    msg.setSentDate( new Date( System.currentTimeMillis() ) );

    if( mb.getContents() == null ) {
      throw new SmtpMailerException( "no email content was not supplied" );
    }
    msg.setText( mb.getContents() );

    if( mb.getIsHTML() == true ) {
      msg.addHeader( "Content-Type", "text/html" );
    }

    return msg;
  }

  private InternetAddress[] createAddresses( List l ) throws AddressException {
    InternetAddress[] addresses = new InternetAddress[l.size()];
    int i = 0;
    for( Iterator it = l.iterator(); it.hasNext(); i++ ) {
      String emailAddress = (String) it.next();
      if( emailAddress != null ) {
        addresses[i] = new InternetAddress( emailAddress );
      }
    }
    return addresses;
  }
}
