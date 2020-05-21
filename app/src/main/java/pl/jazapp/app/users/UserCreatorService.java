package pl.jazapp.app.users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.jazapp.app.webapp.extension.validator.PasswordValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.transaction.Transactional;
import java.sql.Date;

@ApplicationScoped
public class UserCreatorService {

    @PersistenceContext
    private EntityManager em;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void createUser(String username, String password, String first_name,  String last_name, String email, Date birthdate){
        var userEntity = new UserEntity();
        userEntity.setUsername(username);
        System.out.println(String.format("Tried to register with password: %s", passwordEncoder.encode(password)));

        userEntity.setPassword(passwordEncoder.encode(password));
        userEntity.setFirst_name(first_name);
        userEntity.setLast_name(last_name);
        userEntity.setBirthdate(birthdate);
        userEntity.setEmail(email);
        em.persist(userEntity);
    }



}
