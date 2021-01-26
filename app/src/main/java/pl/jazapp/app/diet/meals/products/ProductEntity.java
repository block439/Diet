package pl.jazapp.app.diet.meals.products;


import org.hibernate.annotations.Cascade;
import pl.jazapp.app.diet.meals.products.photo.PhotoEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT d FROM ProductEntity d")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="name")
    private String name;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private PhotoEntity photo;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<MealProductEntity> meals = new ArrayList<>();



    public ProductEntity(){}

    public ProductEntity(Long id, String name, PhotoEntity photoEntity) {
        this.id = id;
        this.name = name;
        this.photo = photoEntity;
    }

    public ProductEntity(Long id, String name, PhotoEntity photo, List<MealProductEntity> meals) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.meals = meals;
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

    public PhotoEntity getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoEntity photoEntity) {
        this.photo = photoEntity;
    }

    public List<MealProductEntity> getMeals() {
        return meals;
    }

    public void setMeals(List<MealProductEntity> meals) {
        this.meals = meals;
    }


}
