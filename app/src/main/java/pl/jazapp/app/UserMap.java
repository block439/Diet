package pl.jazapp.app;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ApplicationScoped
public class UserMap {
    private final Map<String,String> users = new ConcurrentHashMap<String,String>();

    @Inject
    private UserContext userContext;

    public UserMap(){
        users.put("admin","admin");
    }
    
  public void register(String name, String password){
      users.put(name,password);
  }

  public boolean isRegistered(String name){
      return users.containsKey(name);
  }

  public boolean login (String name, String password){
      if(users.containsKey(name) && users.containsValue(password)){
          userContext.login();
          return true;
      } else return false;
  }

}
