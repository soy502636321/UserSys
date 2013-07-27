package soy.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;
import com.sun.mail.smtp.SMTPTransport;

/**
 * @author Lee.Wong
*/
public class Mail {

	private Properties props = new Properties();
	private Session sendMailSession;
	private Store store;
	private SMTPTransport transport;

	private String auth = "true"; //autherization 
	private static String from ;//= "lee.wang@completesolution.com.hk"; //from address;
	private static String fromAlias ;//= "Lee.Wong"; //alias
	private static String smtpServer;// = "mail.completesolution.com.hk"; //smtp server
	private static String userId;// = "lee.wang@completesolution.com.hk"; //userid
	private static String passWord;// = "lee"; //password

	private String subject = "DPAS"; //subject
	private String textContent = "Notification!\nnew DPAS workitems\n"; //text content \n to goto next line
	private InternetAddress[] addresses;
	
	//define the Recipients
	private Address[] to = null;
	private Address[] cc = null;
	private Address[] bcc = null;

	public void sendMail() throws Exception {
		if(smtpServer==null){
			Properties props= PropsParser.getProperties();
			from=props.getProperty("MAIL_FROM");		
			fromAlias=props.getProperty("MAIL_FROMALIAS");
			smtpServer=props.getProperty("MAIL_SMTPSERVER");
			userId=props.getProperty("MAIL_USERID");
			passWord=props.getProperty("MAIL_PASSWORD");	
		}
		
		//do not need to modify the codes below
		if (auth.equals("true")) {
			props.put("mail.smtp.auth", auth);
		}
		props.put("mail.smtp.host", smtpServer);
        
		sendMailSession = Session.getInstance(props, null);
		MimeMessage newMessage = new MimeMessage(sendMailSession);
		newMessage.setFrom(new InternetAddress(from, fromAlias));
		newMessage.setSubject(subject, "UTF-8");
		newMessage.setSentDate(new Date());
		newMessage.setText(textContent, "UTF-8");
		transport = (SMTPTransport) sendMailSession.getTransport("smtp");
		if (auth.equals("true")) {
			System.out.println("smtpServer=["+smtpServer+"]\n");
			System.out.println("userId=["+userId+"]\n");
			System.out.println("passWord=["+passWord+"]\n");
			System.out.println("newMessage=["+newMessage+"]\n");
			System.out.println("addresses=["+addresses+"]\n");
			transport.connect(smtpServer, userId, passWord);
		} else {
			transport.connect();
		}

		if (this.to != null) {
			newMessage.setRecipients(Message.RecipientType.TO, this.to);
		}
		if (this.cc != null) {
			newMessage.setRecipients(Message.RecipientType.CC, this.cc);
		}
		if (this.bcc != null) {
			newMessage.setRecipients(Message.RecipientType.BCC, this.bcc);
		}
		if(addresses==null ||addresses.length==0)
		{
			transport.sendMessage(newMessage, newMessage.getAllRecipients()); 
		}
		else
		{	
			transport.sendMessage(newMessage, addresses);
		}
		transport.close();
	}

	
	// add by roger 2011-3-29
	public void notifyOfficer(String emailAddress, String subject, String content) throws Exception {

		if (emailAddress != null && (! emailAddress.trim().equals("")))	{
			if (subject != null) {
				setSubject(subject);
			}
			if (content != null) {
				setTextContent(content);
			}

			this.setTo(emailAddress);
			sendMail();

		}
	}
	
	// add by vanson 2011-4-20
	public void notifyOfficer(String[] emailAddress, String subject, String content) throws Exception {

		if (emailAddress != null )	{
			if (subject != null) {
				setSubject(subject);
			}
			if (content != null) {
				setTextContent(content);
			}

			this.setTo(emailAddress);
			sendMail();

		}
	}

	/**
	 * 设置收件人地址
	 * @param aEmail 收件人Email地址
	 */
	public void setTo(String aEmail) {
	  String[] s = new String[1];
	  s[0] = aEmail;
	  this.to = getAddress(s);
	}

	/**
	 * 设置多个收件人地址
	 * @param Emails 收件人Email地址
	 */
	public void setTo(String[] Emails) {
	  this.to = getAddress(Emails);
	}

	/**
	 * 设置抄送地址
	 * @param aEmail 抄送地址
	 */
	public void setCC(String aEmail) {
	  String[] s = new String[1];
	  s[0] = aEmail;
	  this.cc = getAddress(s);
	}

	/**
	 * 设置多个抄送地址
	 * @param Emails 抄送地址
	 */
	public void setCC(String[] Emails) {
	  this.cc = getAddress(Emails);
	}

	/**
	 * 设置暗送地址
	 * @param Emails 暗送地址
	 */
	public void setBCC(String aEmail) {
	  String[] s = new String[1];
	  s[0] = aEmail;
	  this.bcc = getAddress(s);
	}

	/**
	 * 设置多个暗送地址
	 * @param Emails 暗送地址
	 */
	public void setBCC(String[] Emails) {
	  this.bcc = getAddress(Emails);
	}

	private Address[] getAddress(String[] add) {
	  Address[] a = new Address[add.length];
	  for (int i = 0; i < add.length; i++) {
		try {
		  a[i] = new InternetAddress(add[i]);
		}
		catch (AddressException ex) {
		  ex.printStackTrace();
		}
	  }
	  return a;
	}
	
	public String getSubject() {
		return subject;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setSubject(String string) {
		subject = string;
	}

	public void setTextContent(String string) {
		textContent = string;
	}

	public InternetAddress[] getAddresses() {
		return addresses;
	}

	public void setAddresses(InternetAddress[] addresses) {
		this.addresses = addresses;
	}

}
