package de.hochschule.augsburg.emailService;

import de.hochschule.augsburg.registrationWindow.domain.model.RegistrationWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService
{
    @Autowired
    private JavaMailSender mailSender;

    /**
     * This method will compose and send the message about start of the registration period
     * */
    public void sendMailRegistrationStart(RegistrationWindow registrationWindow, String sendTo, String registationLink)
    {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(sendTo);
        message.setFrom("wpf.anmelding.hsa@gmail.com");
        message.setSubject("WPF Anmeldestart Bachelor/ Master");
        message.setText("Sehr geehrte Studierende,\n" +
                "\n" +
                "\n" +
                "\n" +
                "die Wahlpflichtfächer Anmeldung ist ab dem " +
                registrationWindow.getStartDate() +
                " bis einschließlich " +
                registrationWindow.getEndDate() +
                " möglich.\n" +
                "\n" +
                "Melden Sie sich unter folgendem Link an: " + registationLink +"\n" +
                "\n" +
                "\n" +
                "\n" +
                "Viele Grüße");

        mailSender.send(message);
    }

    /**
     * This method will compose and send a reminder about registration period
     * */
    public void sendMailRegistrationReminder(String sendTo, String registationLink)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendTo);
        message.setFrom("wpf.anmelding.hsa@gmail.com");
        message.setSubject("WPF Anmeldeerinnerung Bachelor/ Master");
        message.setText("Sehr geehrte Studierende,\n" +
                "\n" +
                "\n" +
                "\n" +
                "die Wahlpflichtfächer Anmeldung ist aktuell bis zum XX.XX.XXXX möglich.\n" +
                "\n" +
                "Melden Sie sich unter folgendem Link an: " + registationLink + "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Viele Grüße");
        mailSender.send(message);
    }

    /**
     * This method will compose and send an email with results for student
     *
     */
    public void sendMailRegistrationResultForStudent(String sendTo, String resultLink)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendTo);
        message.setFrom("wpf.anmelding.hsa@gmail.com");
        message.setSubject("Ergebnisse der WPF-Auslosung");
        message.setText("Sehr geehrte Studierende,\n" +
                "\n" +
                "Die Auslosung der WPF-Zuteilung ist abgeschlossen.\n" +
                "\n" +
                "Sollten Sie für eine Veranstaltung keinen Platz bekommen haben, wurden\n" +
                "die Punkte, die Sie für diese vergeben haben, intern im Losverfahren auf\n" +
                "die anderen Veranstaltungen verteilt und sie hatten dann dort höhere\n" +
                "Punktewerte. \n" +
                "\n" +
                "Es gibt noch Wahlpflichtfächer, die nicht ausgebucht sind und andere, die nicht\n" +
                "über das System vergeben wurden. Sollte sich Ihre Planung geändert haben und Sie wünschen eine\n" +
                "Veranstaltung zu besuchen, zu der Sie sich nicht angemeldet haben,\n" +
                "wenden Sie sich bitte direkt an den Dozenten.\n" +
                "\n" +
                "Sollten Sie eine Veranstaltung trotz erfolgreicher Anmeldung jetzt doch\n" +
                "nicht besuchen wollen, so ist es eine Frage der Höflichkeit sich\n" +
                "abzumelden. Auch hierfür melden Sie sich bitte beim Dozenten. Auch Ihre\n" +
                "KommilitonINNen sind Ihnen dankbar, wenn so Plätze frei werden und\n" +
                "sinnvoll belegt werden können.\n" +
                "\n" +
                "Der Link unter dem Sie Ihre Ergebnisse einsehen können ist: " + resultLink + "\n" +
                "\n" +
                "Bei weiteren Fragen, wenden Sie sich bitte an Frau Bäurle.\n" +
                "Ich wünsche Ihnen ein erfolgreiches und spannendes Semester,\n" +
                "\n" +
                "\n" +
                "\n" +
                "Viele Grüße");
        mailSender.send(message);
    }

    /**
     * This method will compose and send an email with results for professor
     */
    public void sendMailRegistrationResultForProfessor(String sendTo, String resultLink)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(sendTo);
        message.setFrom("wpf.anmelding.hsa@gmail.com");
        message.setSubject("Ergebnisse der WPF-Auslosung/ Teilnehmerliste");
        message.setText("Sehr geehrte Professoren,\n" +
                "\n" +
                "\n" +
                "\n" +
                "die Auslosung der WPF-Zuteilung ist abgeschlossen.\n" +
                "\n" +
                "unter folgendem Link können Sie die Teilnehmerliste Ihrer Kurse einsehen: " + resultLink + "\n" +
                "\n" +
                "\n" +
                "\n" +
                "Viele Grüße");
        mailSender.send(message);
    }
}