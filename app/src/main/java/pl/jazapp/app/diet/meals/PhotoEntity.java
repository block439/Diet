package pl.jazapp.app.diet.meals;


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
    private MealEntity meal;

    public PhotoEntity(){

    }

    public PhotoEntity(Long id, String url, MealEntity meal){
        this.id = id;
        this.url = url;
        this.meal = meal;
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

    public MealEntity getMeal() {
        return meal;
    }

    public void setMeal(MealEntity meal) {
        this.meal = meal;
    }
}
