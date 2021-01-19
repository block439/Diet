package pl.jazapp.app.diet.meals;



import org.hibernate.annotations.Cascade;
import pl.jazapp.app.diet.meals.photo.PhotoEntity;
import pl.jazapp.app.diet.meals.products.MealProductEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="meal")
@NamedQuery(name="Meal.findAll", query="SELECT d FROM MealEntity d")
public class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="recipe")
    private String recipe;

    @OneToOne(mappedBy = "meal", orphanRemoval = true, cascade = CascadeType.ALL)
    private PhotoEntity photoEntity;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<MealDietEntity> diets = new ArrayList<>();

    @OneToMany(mappedBy = "meal", orphanRemoval = true, fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<MealProductEntity> products = new ArrayList<>();


    public MealEntity(){}

    public MealEntity(String name, String recipe){
        this.name = name;
        this.recipe = recipe;
    }

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

    public List<MealDietEntity> getDiets() {
        return diets;
    }

    public void setMealDietEntityList(List<MealDietEntity> diets) {
        this.diets = diets;
    }

    public void setDiets(List<MealDietEntity> diets) {
        this.diets = diets;
   }

    public List<MealProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<MealProductEntity> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealEntity mealEntity = (MealEntity) o;
        return Objects.equals(name, mealEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
