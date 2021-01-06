package pl.jazapp.app.meals;


import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Table(name="mealphoto")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="url")
    private String url;

    @OneToOne
    @JoinColumn(name="meal_id")
    private MealEntity mealEntity;

    public PhotoEntity(){

    }

    public PhotoEntity(Long id, String url, MealEntity mealEntity){
        this.id = id;
        this.url = url;
        this.mealEntity = mealEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MealEntity getMealEntity() {
        return mealEntity;
    }

    public void setMealEntity(MealEntity mealEntity) {
        this.mealEntity = mealEntity;
    }
}
