package pl.jazapp.app.users;


import javax.persistence.*;

@Entity
@Table(name="preference")
public class PreferenceEntity {

    //TODO zmienić tabele preference zeby zawierała tylko name jak nazwa preferencji value bedzie w tabeli łączącej.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="calorific_value")
    private Long calorific_value;

    @Column(name="vege")
    private boolean vege;
    //TODO sprawdzić czy ten boolean działa


}
