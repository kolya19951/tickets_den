package Mail.ssl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SmtpAuthenticator extends Authenticator {
    public SmtpAuthenticator() {

        super();
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        String username = "kolya.simotyuk@gmail.com";
        String password = "kolya18121995";
        if ((username != null) && (username.length() > 0) && (password != null) && (password.length() > 0)) {

            return new PasswordAuthentication(username, password);
        }

        return null;
    }
}