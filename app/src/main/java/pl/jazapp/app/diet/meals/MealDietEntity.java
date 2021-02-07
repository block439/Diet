package pl.jazapp.app.diet.meals;



import pl.jazapp.app.diet.DietEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="meal_diet")
public class MealDietEntity {

    @EmbeddedId
    private MealDietEntityId id = new MealDietEntityId();

    @ManyToOne( fetch = FetchType.EAGER,  cascade = CascadeType.MERGE)
    @MapsId("mealId")
    private MealEntity meal;

    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @MapsId("dietId")
    private DietEntity diet;

    @Column(name = "day_number")
    private Long day_number;

    @Column(name ="meal_number")
    private Long meal_number;


    public MealDietEntity(){}

    public MealDietEntity(MealEntity meal, DietEntity diet) {
        this.id = new MealDietEntityId(meal.getId(), diet.getId());
        this.meal = meal;
        this.diet = diet;
    }

    public MealDietEntityId getId() {
        return id;
    }

    public void setId(MealDietEntityId id) {
        this.id = id;
    }

    public MealEntity getMeal() {
        return meal;
    }

    public void setMeal(MealEntity meal) {
        this.meal = meal;
    }

    public DietEntity getDiet() {
        return diet;
    }

    public void setDiet(DietEntity diet) {
        this.diet = diet;
    }

    public Long getDay_number() {
        return day_number;
    }

    public void setDay_number(Long weekNumber) {
        this.day_number = weekNumber;
    }

    public Long getMeal_number() {
        return meal_number;
    }

    public void setMeal_number(Long meal_number) {
        this.meal_number = meal_number;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass())
            return false;

        MealDietEntity that = (MealDietEntity) o;
        return Objects.equals(meal, that.meal) &&
                Objects.equals(diet, that.diet);
    }

    @Override
    public int hashCode(){
        return Objects.hash(meal, diet);
    }
}
