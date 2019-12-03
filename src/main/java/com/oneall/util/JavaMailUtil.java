package com.oneall.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
	public static void main(String[] args) throws Exception {
		JavaMailUtil j = new JavaMailUtil("smtp.qq.com", "smtp", "true", "413038044@qq.com", "pzivczucpondbhhh",
				"413038044@qq.com");

		j.send("413038044@qq.com", "aq123123d", "qqqq");
	}

	public JavaMailUtil(String host, String protocol, String smtpAuth, String user, String pwd, String sender) {
		super();
		this.host = host;
		this.protocol = protocol;
		this.smtpAuth = smtpAuth;
		this.user = user;
		this.pwd = pwd;
		this.sender = sender;
	}

	private String host;
	private String protocol;
	private String smtpAuth;
	private String user;
	private String pwd;
	private String sender;

	public Message send(String receiver, String subject, String content) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.host", host);
		prop.setProperty("mail.transport.protocol", protocol);
		prop.setProperty("mail.smtp.auth", smtpAuth);
		// 使用JavaMail发送邮件的5个步骤
		// 1、创建session
		Session session = Session.getInstance(prop);
		// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		session.setDebug(true);
		// 2、通过session得到transport对象
		Transport ts = session.getTransport();
		// 3、连上邮件服务器
		ts.connect(host, user, pwd);

		// 4、创建邮件
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress(sender));
		// 指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
		// 邮件的标题
		message.setSubject(subject);
		// 邮件的文本内容
		message.setContent(content, "text/html;charset=UTF-8");
		// 返回创建好的邮件对象

		// 5、发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
		return message;
	}

}
