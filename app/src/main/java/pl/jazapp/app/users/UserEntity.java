package pl.jazapp.app.users;


import pl.jazapp.app.auctions.AuctionEntity;
import pl.jazapp.app.categories.CategoriesEntity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "role",  columnDefinition = "varchar(15) default 'STANDARD'")
    private String role = "STANDARD";

    @OneToMany(mappedBy = "owner")
    private List<AuctionEntity> owner;



    //TODO: powiązać tabele ze sobą



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.lang.Long getId(){return id; }

    public void setId(java.lang.Long id){this.id = id;}

    public String getUsername(){ return username; }

    public void setUsername(String username){this.username=username;}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
