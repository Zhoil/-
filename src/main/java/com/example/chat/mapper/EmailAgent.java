package com.example.chat.mapper;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;

public class EmailAgent {
    private String username;
    private String password;
    private Properties properties;

    //初始化配置
    public EmailAgent(String username, String password) {
        this.username = username;
        this.password = password;

        // 设置连接属性
        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.qq.com"); // SMTP 服务器地址
        properties.put("mail.smtp.port", "465"); // SMTP 端口号

        // 添加 SSL 设置
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.ssl.enable", "true");
    }

    // 发送邮件
    public void sendEmail(String to, String subject, String body) throws MessagingException {
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
        System.out.println("Email sent successfully.");
    }

    // 接收邮件
    public void receiveEmail() throws MessagingException, IOException {
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Store store = session.getStore("pop3");
        store.connect("pop.example.com", 995, username, password); // POP3 服务器地址

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        Message[] messages = inbox.getMessages();
        for (Message message : messages) {
            System.out.println("From: " + message.getFrom()[0]);
            System.out.println("Subject: " + message.getSubject());
            System.out.println("Body: " + message.getContent().toString());
        }

        inbox.close(false);
        store.close();
    }



    public Message createEmail(String to, String subject, String body) throws MessagingException {
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);

        return message;
    }

    // 删除邮件
    public void deleteEmail(Message message) throws MessagingException {
        message.setFlag(Flags.Flag.DELETED, true);
        System.out.println("Email deleted successfully.");
    }

    // 将邮件标记为已读
    public void markAsRead(Message message) throws MessagingException {
        message.setFlag(Flags.Flag.SEEN, true);
        System.out.println("Email marked as read.");
    }


}
