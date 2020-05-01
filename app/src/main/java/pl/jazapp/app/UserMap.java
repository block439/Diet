package pl.jazapp.app;

import pl.jazapp.app.webapp.login.LoginRequest;

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

  public boolean login (String name, String password){
      if(userMap.containsKey(name) && password.equals(userMap.get(name).getPassword())){
          userContext.login();
          userContext.setFullName(userMap.get(name).getFirstName(), userMap.get(name).getLastName());
          return true;
      } else return false;
  }


  public User getFullName(LoginRequest loginRequest){
        return userMap.get(loginRequest.getUsername());

  }


}
