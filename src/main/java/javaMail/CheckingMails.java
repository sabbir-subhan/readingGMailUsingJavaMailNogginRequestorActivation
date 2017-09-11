package javaMail;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.sun.mail.imap.IMAPFolder;

import jSoupParser.jSoupHTMLToString;

public class CheckingMails {


public static void check(String host, String storeType, String user,String password) 
   {
      try {

      //create properties field
      Properties properties = new Properties();
      properties.setProperty("mail.store.protocol", "imaps");

      Session session = Session.getDefaultInstance(properties, null);//creating session

      Store store = session.getStore("imaps");
  
      store.connect(host, user, password);//connect to GMail using imap protocol
         
      Folder folder = (IMAPFolder) store.getFolder("inbox");//get mails from inbox folder

     
      
      if(!folder.isOpen())
          folder.open(Folder.READ_WRITE);
          Message[] messages = folder.getMessages();
          System.out.println("No of Messages : " + folder.getMessageCount());
          System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
          System.out.println(messages.length);
          for (int i=0; i < messages.length;i++) 
          {

            System.out.println("*****************************************************************************");
            System.out.println("MESSAGE " + (i + 1) + ":");
            Message msg =  messages[i];
            //System.out.println(msg.getMessageNumber());
            //Object String;
            //System.out.println(folder.getUID(msg)

            String subject = msg.getSubject();//important value

            System.out.println("Subject: " + subject);
            System.out.println("From: " + msg.getFrom()[0]);
            System.out.println("To: "+msg.getAllRecipients()[0]);//important value
            System.out.println("Date: "+msg.getReceivedDate());
            //System.out.println("Size: "+msg.getSize());
            //System.out.println(msg.getFlags());
            
            //if To Email address has same address as the address used during sign up and subject is same as "Activate Account"    
            if((msg.getAllRecipients()[0].toString().equals("sabbirswitchmediatest+random1@gmail.com"))&&(subject.equals("Activate account")))
            {
            	String EmailContent=msg.getContent().toString();
            	System.out.println("Email Content: \n"+ EmailContent);//need to get extract link value from here 
            	 //Invoke jSoupHTMLToString object
            	 jSoupHTMLToString HTML=new jSoupHTMLToString();
            	 String activationURL=HTML.ActivationURL(EmailContent);//calling JSoup method to find link
            	 if(activationURL!=null){
            		 System.out.println("Activation URL : "+ activationURL);
            	 }
            	 else
            	 {
            		 System.out.println("Activation URL is Null!!!!! "); 
            	 }
            }       
            

          }
    
      
      store.close();//closing connect with GMail

      } catch (NoSuchProviderException e) {
         e.printStackTrace();
      } catch (MessagingException e) {
         e.printStackTrace();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void main(String[] args) {

      String host = "pop.gmail.com";// change accordingly
      String mailStoreType = "pop3";
      String username = "sabbirswitchmediatest@gmail.com";// change accordingly
      String password = "SwitchMedia";// change accordingly

      check(host, mailStoreType, username, password);

   }

}