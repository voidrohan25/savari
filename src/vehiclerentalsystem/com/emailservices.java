package vehiclerentalsystem.com;

import java.time.LocalDate;
import java.util.Properties;

import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class emailservices {
    
    private final static String sendermail = "rohan.yewale252005@gmail.com";
    private final static String sendpass = "wlvs bpid sfkb xpan";

    public static String sendconfirmationmail(customer customer, vehicle vehicle, double amount) {

        LocalDate startDate = LocalDate.now();

        String title = "Vehicle rental confirmation";

        String body = "\nRespected " + customer.getName() + " sir \n Thanks for using SAFARI , Your details are:,\n" +
                "Vehicle ID : " + vehicle.getVehicleId() + "\n" +
                "Rental Rate : " + vehicle.getRentalRate() + "\n" +
                "Total Bill : " + amount + "\n" +
                "Paid Amount : " + amount + "\n" +
                "Day start from : " + startDate + "\n";

        System.out.println("Sending mail to " + customer.getEmail() + "..........");

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendermail, sendpass);
            }
        });

        Message message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(sendermail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(customer.getEmail()));
            message.setSubject(title);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email send to : " + customer.getEmail());

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return body;
    }
}