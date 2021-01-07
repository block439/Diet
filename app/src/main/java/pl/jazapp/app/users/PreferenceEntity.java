package pl.jazapp.app.users;


import pl.jazapp.app.diet.meals.MealDietEntity;
import pl.jazapp.app.diet.meals.MealEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="preference")
public class PreferenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name = "name")
    private Long name;

    @OneToMany(mappedBy = "preference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserPreferenceEntity> preferences = new ArrayList<>();


    public PreferenceEntity(Long id, Long name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreferenceEntity preferenceEntity = (PreferenceEntity) o;
        return Objects.equals(name, preferenceEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

