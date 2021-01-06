package pl.jazapp.app.meals;


import javax.persistence.*;

@Entity
@Table(name="meal")
public class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="recipe")
    private String recipe;

    @OneToOne(mappedBy = "meal")
    private PhotoEntity photoEntity;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public PhotoEntity getPhotoEntity() {
        return photoEntity;
    }

    public void setPhotoEntity(PhotoEntity photoEntity) {
        this.photoEntity = photoEntity;
    }
}
