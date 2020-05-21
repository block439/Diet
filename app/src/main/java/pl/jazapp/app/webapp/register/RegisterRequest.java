package pl.jazapp.app.webapp.register;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestScoped
@Named
public class RegisterRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String mail;
    private java.sql.Date birthdate;
    private String date;
    private String checkPassword;

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        this.date = date;
        setBirthdate(date);
    }

    public java.sql.Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String date) throws ParseException {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date1 = dateFormat.parse(date);
            java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
            this.birthdate = sqlDate;
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
