package com.kp.apps.web.library;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Takes care of sending emails
 * 
 * @author HariKrishna Pesala
 */
public class EmailService {

  /**
   * Send an email with authentication without attachment
   * 
   * @param toEmails an array of email addresses to sent the email to
   * @param subject the subject of the email
   * @param body the message content of the email
   * @param from the from address for the email
   * @param hostName the hostname of the SMTP server
   * @param port the port of the SMTP server to use
   * @param useSSL whether to use SSL with the connection
   * @param username the username to use for authentication
   * @param password the password to use for authentication
   * @throws MessagingException if there is a problem sending the email
   */
  public void sendMailWithAuthentication(String toEmails[], String subject, String body,
      String from, String hostName, String port, boolean useSSL, String username, String password)
      throws MessagingException {
    // Setup the properties
    Properties props = new Properties();
    props.put("mail.smtp.host", hostName);
    props.put("mail.smtp.port", port);
    props.put("mail.smtp.ssl.enable", useSSL);
    props.put("mail.smtp.auth", "true");

    // Setup the Authenticator and Session
    Authenticator auth = new SMTPAuthenticator(username, password);
    Session session = Session.getDefaultInstance(props, auth);
    session.setDebug(false);

    // Send the mail
    sendMail(session, toEmails, subject, body, from, null, null, null);
  }

  /**
   * Send an email with authentication with attachment
   * 
   * @param toEmails an array of email addresses to sent the email to
   * @param subject the subject of the email
   * @param body the message content of the email
   * @param from the from address for the email
   * @param hostName the hostname of the SMTP server
   * @param port the port of the SMTP server to use
   * @param useSSL whether to use SSL with the connection
   * @param username the username to use for authentication
   * @param password the password to use for authentication
   * @param attachment the attachment to include in the email
   * @param fileName the fileName to display for the email attachment
   * @param embedAttachment if embedAttachemnt is set, the attachment will be embedded in the email
   *        with the specified mime type
   * @throws MessagingException if there is a problem sending the email
   */
  public void sendMailWithAuthentication(String toEmails[], String subject, String body,
      String from, String hostName, String port, boolean useSSL, String username, String password,
      String attachment, String fileName, String embedAttachment) throws MessagingException {
    // Setup the properties
    Properties props = new Properties();
    props.put("mail.smtp.host", hostName);
    props.put("mail.smtp.port", port);
    props.put("mail.smtp.ssl.enable", useSSL);
    props.put("mail.smtp.auth", "true");

    // Setup the Authenticator and Session
    Authenticator auth = new SMTPAuthenticator(username, password);
    Session session = Session.getDefaultInstance(props, auth);
    session.setDebug(false);

    // Send the mail
    sendMail(session, toEmails, subject, body, from, attachment, fileName, embedAttachment);
  }

  /**
   * Send the mail without authentication without an attachment
   * 
   * @param toEmails an array of email addresses to sent the email to
   * @param subject the subject of the email
   * @param body the message content of the email
   * @param from the from address for the email
   * @param hostName the hostname of the SMTP server
   * @param port the port of the SMTP server to use
   * @param useSSL whether to use SSL with the connection
   * @throws MessagingException
   */
  public void sendMailNoAuthentication(String toEmails[], String subject, String body, String from,
      String hostName, String port, boolean useSSL) throws MessagingException {
    // Setup the properties
    Properties props = new Properties();
    props.put("mail.smtp.host", hostName);
    props.put("mail.smtp.port", port);
    props.put("mail.smtp.ssl.enable", useSSL);

    // Setup the session
    Session session = Session.getDefaultInstance(props, null);
    session.setDebug(false);

    // Send the mail
    sendMail(session, toEmails, subject, body, from, null, null, null);
  }

  /**
   * Send the mail without authentication with attachment
   * 
   * @param toEmails an array of email addresses to sent the email to
   * @param subject the subject of the email
   * @param body the message content of the email
   * @param from the from address for the email
   * @param hostName the hostname of the SMTP server
   * @param port the port of the SMTP server to use
   * @param useSSL whether to use SSL with the connection
   * @param attachment the attachment to include in the email
   * @param fileName the fileName to display for the email attachment
   * @param embedAttachment if embedAttachemnt is set, the attachment will be embedded in the email
   *        with the specified mime type
   * @throws MessagingException
   */
  public void sendMailNoAuthentication(String toEmails[], String subject, String body, String from,
      String hostName, String port, boolean useSSL, String attachment, String fileName,
      String embedAttachment) throws MessagingException {
    // Setup the properties
    Properties props = new Properties();
    props.put("mail.smtp.host", hostName);
    props.put("mail.smtp.port", port);
    props.put("mail.smtp.ssl.enable", useSSL);

    // Setup the session
    Session session = Session.getDefaultInstance(props, null);
    session.setDebug(false);

    // Send the mail
    sendMail(session, toEmails, subject, body, from, attachment, fileName, embedAttachment);
  }

  /**
   * Method to actually send the email
   * 
   * @param session the session for the email
   * @param toEmails the array of to email addresses
   * @param subject the subject of the email
   * @param body the body of the email
   * @param from the from email address for the email
   * @param attachment the attachment to include in the email
   * @param fileName the fileName to display for the email attachment
   * @param embedAttachment if embedAttachemnt is set, the attachment will be embedded in the email
   *        with the specified mime type
   * @throws MessagingException if there is a problem sending the email
   */
  private void sendMail(Session session, String toEmails[], String subject, String body,
      String from, String attachment, String fileName, String embedAttachment)
      throws MessagingException {
    // Create the message
    Message message = new MimeMessage(session);

    // Set the from and to addresses
    InternetAddress fromAddress = new InternetAddress(from);
    message.setFrom(fromAddress);
    InternetAddress[] toAddresses = new InternetAddress[toEmails.length];
    for (int i = 0; i < toEmails.length; i++) {
      toAddresses[i] = new InternetAddress(toEmails[i]);
    }
    message.setRecipients(Message.RecipientType.TO, toAddresses);

    // Set the subject and body
    message.setSubject(subject);

    // Check for attachment
    if (attachment == null) {
      message.setContent(body, "text/plain");
    } else {
      // Create the multipart message and MimeBodypart
      Multipart multipart = new MimeMultipart();
      MimeBodyPart messageBodyPart = new MimeBodyPart();

      if (embedAttachment == null) {
        // Filename to use
        String theFileName = (fileName != null) ? fileName : attachment;
        // Set the text body
        messageBodyPart.setText(body);
        multipart.addBodyPart(messageBodyPart);

        // Set the attachment
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(attachment);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(theFileName);
        multipart.addBodyPart(messageBodyPart);

        // Add the parts to the message
        message.setContent(multipart);
      } else {
        // Set the body part
        message.setContent(attachment, embedAttachment);
      }
    }
    // Send the message
    Transport.send(message);
  }

  /**
   * SimpleAuthenticator is used to do simple authentication when the SMTP server requires it.
   */
  private class SMTPAuthenticator extends javax.mail.Authenticator {
    /**
     * The username for SMTP authentication
     */
    private String username;

    /**
     * The password for SMTP authentication
     */
    private String password;

    /**
     * Constructs a SMTPAuthenticator object
     * 
     * @param user the username for authentication
     * @param password the password for authentication
     */
    public SMTPAuthenticator(String username, String password) {
      this.username = username;
      this.password = password;
    }


  }

  public static void main(String[] args) {
    try {
      EmailService email = new EmailService();
      // email.sendMailNoAuthentication(new String[]{"jordan@yaanatech.com"}, "Test java email",
      // "This is only a test", "jordan@yaanatech.com", "webmail.yaanatech.com", "25", false);
      email.sendMailNoAuthentication(new String[] {"harikrishna.pesala@ishisystems.com"},
          "Test java email", "This is only a test", "harikrishna.pesal@ishisystems.com",
          "exchange10.ishisystems.com", "25", false);
      System.out.println("Successfully sent mail");
    } catch (MessagingException me) {
      me.printStackTrace();
    }
  }
}
