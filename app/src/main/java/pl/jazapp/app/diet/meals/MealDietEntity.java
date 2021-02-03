package pl.jazapp.app.diet.meals;



import org.hibernate.annotations.Cascade;
import pl.jazapp.app.diet.DietEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="meal_diet")
public class MealDietEntity {

    @EmbeddedId
    private MealDietEntityId id = new MealDietEntityId();

    @ManyToOne( fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @MapsId("mealId")
    private MealEntity meal;

    @ManyToOne( fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.MERGE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @MapsId("dietId")
    private DietEntity diet;

    @Column(name = "weeknumber")
    private Long weekNumber;


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

    public Long getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Long weekNumber) {
        this.weekNumber = weekNumber;
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
