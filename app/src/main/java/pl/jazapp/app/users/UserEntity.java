package pl.jazapp.app.users;

import javax.inject.Inject;
import javax.persistence.*;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    public Long getId(){return id; }

    public void setId(Long id){this.id = id;}

    public String getUsername(){ return username; }

    public void setUsername(String username){this.username=username;}

}
