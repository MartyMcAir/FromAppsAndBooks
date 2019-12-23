Mail message bean
  
 

package com.ack.j2ee.javamail;

import java.util.List;

/**
 * MailMessageBeans are used to store information about at an email message.
 * They are then passed to an SmtpMailer object, that is responsible for
 * sending the email.  MailMessageBeans provide an additional level of
 * abstraction that separates application code from the underlying API, such as
 * JavaMail, that is used to send email messages
 */
public class MailMessageBean implements java.io.Serializable {
  private String contents;
  private String subject;
  private String fromAddress;
  private List toAddresses;
  private List replyToAddresses;
  private boolean isHTML = false;

  /**
   * Gets the mail content text
   * @return The email content as a String
   */
  public String getContents() {
    return contents;
  }

  /**
   * Sets the email content
   * @param newContents The content of the email
   */
  public void setContents( String newContents ) {
    contents = newContents;
  }

  /**
   * Sets the email subject field
   * @param newSubject The subject field text
   */
  public void setSubject( String newSubject ) {
    subject = newSubject;
  }

  /**
   * Gets the email subject
   * @return The email subject as a String
   */
  public String getSubject() {
    return subject;
  }

  /**
   * Sets the 'To' address list
   * @param newToAddresses A List of the to addresses as String objects.
   */
  public void setToAddresses( List newToAddresses ) {
    toAddresses = newToAddresses;
  }

  /**
   * Gets the 'To' list from the email
   * @return java.util.List The addresses as a List of String objects.
   */
  public List getToAddresses() {
    return toAddresses;
  }

  /**
   * Sets the 'From' field of the email
   * @param newFromAddress The 'From' email address
   */
  public void setFromAddress( String newFromAddress ) {
    fromAddress = newFromAddress;
  }

  /**
   * Gets the 'From' field content of the email
   * @return String The 'From' email address as a String
   */
  public String getFromAddress() {
    return fromAddress;
  }

  /**
   * Sets the 'Reply-To' field of the email
   * @param newReplyToAddresses The reply-to addresses as a List of String objects.
   */
  public void setReplyToAddresses( List newReplyToAddresses ) {
    replyToAddresses = newReplyToAddresses;
  }

  /**
   * Gets the list of reply-to addresses
   * @return List The reply-to addresses as a List of String objects
   */
  public List getReplyToAddresses() {
    return replyToAddresses;
  }

  /**
   * Sets the HTML flag to indicate whether the mail should be in HTML format
   * @param html HTML flag as boolean
   */
  public void setIsHTML( boolean html ) {
    isHTML = html;
  }

  /**
   * Gets the HTML flag
   * @return The html flag as a boolean value
   */
  public boolean getIsHTML() {
    return isHTML;
  }
}
