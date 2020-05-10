package pl.jazapp.app;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ApplicationScoped
public class UserMap {
    private final Map<String,User> userMap = new ConcurrentHashMap<String,User>();

    @Inject
    private UserContext userContext;

    public UserMap(){
        User user = new User();
        user.setPassword("admin");
        userMap.put("admin",user);
    }

    
  public void register(String name, String password, String firstname, String lastName, String mail, String birthdate){
      User user = new User();
      user.setFirstName(firstname);
      user.setLastName(lastName);
      user.setEmail(mail);
      user.setBirthdate(birthdate);
      user.setPassword(password);
      userMap.put(name,user);
  }

  public boolean isRegistered(String name){
      return userMap.containsKey(name);
  }

  public User getUser(String name){
        return userMap.get(name);
  }


}
