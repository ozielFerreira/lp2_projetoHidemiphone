package email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import entidade.Orcamento;
import entidade.Telefone;

public class EnvioEmail {

	public static Properties abrirConex() {

		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true"); 
		props.setProperty("mail.smtp.*ssl.enable", "true"); 
		props.setProperty("mail.smtp.*ssl.required", "true");
		return props;

	}

	public static Session login() {
		Session session = Session.getDefaultInstance(abrirConex(), new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("email", "senha");// email e senha do hidemi que vai enviar 
			}

		});
		return session;
	}

	public static void htmlMail(String logo, String email, String sub, String nome, String clienteEmail,
			String clienteTelefone, String clienteMenssagem) {

		try {

			Message message = new MimeMessage(login());
			login().setDebug(true);
			Address[] toUser = InternetAddress.parse(email); // Destinat�rio(s)

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(sub);

			MimeMultipart multipart = new MimeMultipart();

			BodyPart messageBodyPart = new MimeBodyPart();
			StringBuffer html = new StringBuffer();

			String header = "<div style=\"background-color: rgba(0,0,0,.95); width:100%;color: white; border-top: thick double #000000; text-align: left;\">\r\n"
					+ "";
			html.append(
					"<div class=\"jumbotron\" align=\"center\" style=\"height:205px;width:100%; background-color: #000;color: #fff;padding: 35px 25px;font-family: Montserrat, sans-serif;margin-bottom: 1px !important;\"><img src=\"cid:header\" alt=\"logoapple\" width=\"65\" style=\"\"><h1 style=\"margin-bottom: 10px;font: 400 18px Lato, sans-serif;line-height: 1.8;font-size: 225%;\"> Hid<b style=\"font-size: 72%;\">EM</b><b style=\"color: red;\">i</b>Phone</h1> <p>Somos especializados no conserto de iPhone e iPad</p><form class=\"form-inline\"></form></div>");
			html.append(header);

			html.append("<div style=\"margin: 20px; \" style=\"width:100%; background-color: rgba(0,0,0,.75);\">");
			html.append("<p>\r\n" + "                            Prezado Cliente,<br> <br>\r\n"
					+ "                            Bem-vindo a HidemiPhone!<br> <br>\r\n"
					+ "                        </p>\r\n"
					+ "                        <table style=\"text-align: left;\">");

			html.append("<tr>\r\n" + "                                <th>Nome: &nbsp;&nbsp;</th>\r\n"
					+ "                                <td>" + nome + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>Email: &nbsp;&nbsp;</th>\r\n"
					+ "                                <td>" + clienteEmail + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>Telefone: &nbsp;&nbsp;</th>\r\n"
					+ "                                <td>" + clienteTelefone + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>Mensagem: &nbsp;&nbsp;</th>\r\n"
					+ "                                <td>" + clienteMenssagem + "</td>\r\n"
					+ "                            </tr></table> ");
			html.append("</div>");

			html.append(
					"              <div align=\"center\" style='background-color:rgba(0,0,0,.75); height:60px;'>\r\n"
							+ "                    \r\n"
							+ "                    <p style=\"\"><a style=\"color: white;text-decoration: none;\" href=\"https://www.hidemiphone.com.br\" target=\"_blank\" title=\"HidemiPhone\">&copy; 2017 Todos direitos reservados </a>| Designed by Turma 2016.3</p>\r\n"
							+ "                </div> ");
			html.append("</div>");

			String cod = "" + html;
			messageBodyPart.setContent(cod, "text/html; charset=UTF-8");

			multipart.addBodyPart(messageBodyPart);

			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource(logo + "logo-branco.png");
			
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<header>");
			
			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);
			// Send message
			Transport.send(message);
			System.out.println("ENVIADO");
		} catch (MessagingException me) {

			System.out.println("ERRO! ------");
			System.out.println(me.getMessage());
		}

	}

	public void esqueciSenha(String logo, String email, String sub, String token) {

		try {

			Message message = new MimeMessage(login());
			login().setDebug(true);
			Address[] toUser = InternetAddress.parse(email); // Destinat�rio(s)

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(sub);

			MimeMultipart multipart = new MimeMultipart();

			BodyPart messageBodyPart = new MimeBodyPart();
			StringBuffer html = new StringBuffer();

			String header = "<div style=\"background-color: rgba(0,0,0,.95); width:100%;color: white; border-top: thick double #000000; text-align: left;\">\r\n"
					+ "";
			html.append(
					"<div class=\"jumbotron\" align=\"center\" style=\"height:205px;width:100%; background-color: #000;color: #fff;padding: 35px 25px;font-family: Montserrat, sans-serif;margin-bottom: 1px !important;\"><img src=\"cid:header\" alt=\"logoapple\" width=\"65\" style=\"\"><h1 style=\"margin-bottom: 10px;font: 400 18px Lato, sans-serif;line-height: 1.8;font-size: 225%;\"> Hid<b style=\"font-size: 72%;\">EM</b><b style=\"color: red;\">i</b>Phone</h1> <p>Somos especializados no conserto de iPhone e iPad</p><form class=\"form-inline\"></form></div>");
			html.append(header);

			html.append("<div style=\"margin: 20px; \" style=\"width:100%; background-color: rgba(0,0,0,.75);\">");
			html.append("<p>\r\n" + "                            Prezado Cliente,<br> <br>\r\n"
					+ "                            Bem-vindo a HidemiPhone!<br> <br>\r\n"
					+ "                        </p>\r\n" + "                        ");

			html.append(token);
			html.append("</div>");

			html.append(
					"              <div align=\"center\" style='background-color:rgba(0,0,0,.75); height:60px;'>\r\n"
							+ "                    \r\n"
							+ "                    <p style=\"\"><a style=\"color: white;text-decoration: none;\" href=\"https://www.hidemiphone.com.br\" target=\"_blank\" title=\"HidemiPhone\">&copy; 2017 Todos direitos reservados </a>| Designed by Turma 2016.3</p>\r\n"
							+ "                </div> ");
			html.append("</div>");

			String cod = "" + html;
			messageBodyPart.setContent(cod, "text/html; charset=UTF-8");

			multipart.addBodyPart(messageBodyPart);

			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource(logo + "logo-branco.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<header>");

			// add image to the multipart
			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);
			// Send message
			Transport.send(message);
			System.out.println("ENVIADO");
		} catch (MessagingException me) {

			System.out.println("ERRO! ------");
			System.out.println(me.getMessage());
		}

	}

	public static void orcamento(String logo, String email, String sub, Orcamento o, String frente, String lateral,
			String verso) {

		try {

			Message message = new MimeMessage(login());
			login().setDebug(true);
			Address[] toUser = InternetAddress.parse(email); // Destinat�rio(s)

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(sub);

			MimeMultipart multipart = new MimeMultipart();

			BodyPart messageBodyPart = new MimeBodyPart();
			StringBuffer html = new StringBuffer();
			String header = "<div style=\"background-color: rgba(0,0,0,.95);  width:100%;color: white; border-top: thick double #000000; text-align: left;\">\r\n"
					+ "";
			html.append(
					"<div class=\"jumbotron\" align=\"center\" style=\"height:205px;width:100%; background-color: #000;color: #fff;padding: 35px 25px;font-family: Montserrat, sans-serif;margin-bottom: 1px !important;\"><img src=\"cid:header\" alt=\"logoapple\" width=\"65\" style=\"\"><h1 style=\"margin-bottom: 10px;font: 400 18px Lato, sans-serif;line-height: 1.8;font-size: 225%;\"> Hid<b style=\"font-size: 72%;\">EM</b><b style=\"color: red;\">i</b>Phone</h1> <p>Somos especializados no conserto de iPhone e iPad</p><form class=\"form-inline\"> <b></form></div>");
			html.append(header);

			html.append("<div style=\"margin: 20px; \" style=\"width:100%; background-color: rgba(0,0,0,.75);\">");
			html.append("<p>\r\n" + "                            Prezado Cliente,<br> <br>\r\n"
					+ "                            Bem-vindo a HidemiPhone!<br> <br>\r\n"
					+ "                        </p>\r\n"
					+ "                        <table style=\"text-align: left;\">");

			html.append("<tr>\r\n" + "                                <th>Numero da Serie: &nbsp;&nbsp;</th>\r\n"
					+ "                                <td style=''>" + o.getNumdeSerie() + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>Equipamento: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td style=''>" + o.getEquipamento() + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>Modelo: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td style=''>" + o.getModelo() + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>Origem: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td>" + o.getOrigem() + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>Cor: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td>" + o.getCor() + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>Problema: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td>" + o.getProblema() + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>Descrição: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td>" + o.getDescricao() + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>Nome do Cliente: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td>" + o.getCliente().getNome() + "</td>\r\n"
					+ "                            </tr>");

			html.append("<tr>\r\n" + "                                <th>E-mail: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td>" + o.getCliente().getEmail() + "</td>\r\n"
					+ "                            </tr>");
			html.append("<tr>\r\n" + "                                <th>Endereco: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td>" + o.getCliente().getEndereco().getLogradouro() +" "+ o.getCliente().getEndereco().getNumero() + "</td>\r\n"
					+ "                            </tr>");
			html.append("<tr>\r\n" + "                                <th>Bairro: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td>" + o.getCliente().getEndereco().getBairro() + "</td>\r\n"
					+ "                            </tr>");
			html.append("<tr>\r\n" + "                                <th>Bairro: &nbsp;&nbsp;  </th>\r\n"
					+ "                                <td>" + o.getCliente().getEndereco().getCidade() + "</td>\r\n"
					+ "                            </tr>");
			int i = 0;
			for (Telefone t : o.getCliente().getTelefone()) {
				i++;
				html.append("<tr>\r\n" + "                                <th>Telefone " + i
						+ ": &nbsp;&nbsp;  </th>\r\n" + "                                <td>" + t.getNumero()
						+ "</td>\r\n" + "                            </tr></table>");
			}
			html.append("<p>&nbsp;</p>");
			html.append("<p>&nbsp;</p>");

			html.append(
					"              <div align=\"center\" style='background-color:rgba(0,0,0,.75);width:100%; height:60px;'>\r\n"
							+ "                    \r\n"
							+ "                    <p style=\"\"><a style=\"color: white;text-decoration: none;\" href=\"https://www.hidemiphone.com.br\" target=\"_blank\" title=\"HidemiPhone\">&copy; 2017 Todos direitos reservados </a>| Designed by Turma 2016.3</p>\r\n"
							+ "                </div> ");
			html.append("</div>");

			String cod = "" + html;
			messageBodyPart.setContent(cod, "text/html; charset=UTF-8");

			multipart.addBodyPart(messageBodyPart);

			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource(logo + "logo-branco.png");

			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<header>");
			// fotos upadas
			// frente
			MimeBodyPart FrenteBodyPart = new MimeBodyPart();
			DataSource foto1 = new FileDataSource(frente);

			FrenteBodyPart.setDataHandler(new DataHandler(foto1));
			// FrenteBodyPart.setHeader("Content-ID", "<foto1>");
			FrenteBodyPart.setFileName(foto1.getName());
			// end frente

			// lateral
			MimeBodyPart lateralBodyPart = new MimeBodyPart();
			DataSource foto2 = new FileDataSource(lateral);

			lateralBodyPart.setDataHandler(new DataHandler(foto2));
			// messageBodyPart.setHeader("Content-ID", "<foto2>");
			lateralBodyPart.setFileName(foto2.getName());

			// verso
			MimeBodyPart versoBodyPart = new MimeBodyPart();
			DataSource foto3 = new FileDataSource(verso);

			versoBodyPart.setDataHandler(new DataHandler(foto3));
			// versoBodyPart.setHeader("Content-ID", "<foto3>");]
			versoBodyPart.setFileName(foto3.getName());
			// end

			// add image to the multipart

			multipart.addBodyPart(FrenteBodyPart);
			multipart.addBodyPart(lateralBodyPart);
			multipart.addBodyPart(versoBodyPart);

			multipart.addBodyPart(messageBodyPart);
			// put everything together
			
			message.setContent(multipart);
			
			// Send message
			Transport.send(message);
			System.out.println("ENVIADO");
		} catch (MessagingException me) {

			System.out.println("ERRO! ------");
			System.out.println(me.getMessage());
		}

	}

	public static void main(String[] args) {

	}
}

