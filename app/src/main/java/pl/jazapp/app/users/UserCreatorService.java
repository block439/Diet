package pl.jazapp.app.users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.jazapp.app.webapp.extension.validator.PasswordValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserCreatorService {

    @PersistenceContext
    private EntityManager em;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void createUser(String username, String password){
        var userEntity = new UserEntity();
        userEntity.setUsername(username);
        em.persist(userEntity);
    }
}
