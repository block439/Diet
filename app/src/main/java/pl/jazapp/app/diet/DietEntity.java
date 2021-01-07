package pl.jazapp.app.diet;


import pl.jazapp.app.auctions.parameters.ParameterEntity;
import pl.jazapp.app.diet.meals.MealDietEntity;
import pl.jazapp.app.users.UserEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="diet")
public class DietEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealDietEntity> meals = new ArrayList<>();

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserEntity> users = new ArrayList<>();

    @OneToMany(mappedBy = "diet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietParameterEntity> parameters = new ArrayList<>();

    public DietEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        DietEntity dietEntity = (DietEntity) o;
        return Objects.equals(title, dietEntity.title) && Objects.equals(description, dietEntity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

}
