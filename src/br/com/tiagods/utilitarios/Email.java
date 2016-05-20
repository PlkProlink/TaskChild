/*
 * Todos direitos reservados a Tiago Dias.
 * OpenSource Project www.github.com.br/tiagods
 */
package br.com.tiagods.utilitarios;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Tiago
 */
public class Email {
    
    public boolean enviarEmail(String arquivoLog, String resumo, String mensagem, String destino){
            Properties props = new Properties();
            Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                     protected PasswordAuthentication getPasswordAuthentication() 
                     {
                           return new PasswordAuthentication("prolinkcontabil@gmail.com", "prolink10");
                     }
                });
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("prolinkcontabil@gmail.com")); //Remetente
                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse(destino);
                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Backup Versao Diaria Prolink - "+resumo);//Assunto
                //message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
                // cria a primeira parte da mensagem
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText(mensagem);
                Multipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                
                if(!arquivoLog.equals("")){
                // cria a segunda parte da mensage
                    MimeBodyPart mbp2 = new MimeBodyPart();
                    // anexa o arquivo na mensagem
                    FileDataSource fds = new FileDataSource(arquivoLog);
                    mbp2.setDataHandler(new DataHandler(fds));
                    mbp2.setFileName(fds.getName());
                    mp.addBodyPart(mbp2);
                } 

//                // cria a Multipart
//                Multipart mp = new MimeMultipart();
//                mp.addBodyPart(mbp1);
//                mp.addBodyPart(mbp2);
                // adiciona a Multipart na mensagem
                message.setContent(mp);
                // configura a data: cabecalho
                message.setSentDate(new Date());
                /**Método para enviar a mensagem criada*/
                Transport.send(message);
                return true;
            } catch (MessagingException e) {
                //throw new RuntimeException(e);
                return false;
            }
    }
}
