package pl.jazapp.app.meals;


import org.hibernate.FetchMode;
import org.hibernate.annotations.ManyToAny;
import pl.jazapp.app.diet.DietEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="meal_diet")
public class MealDietEntity {

    @EmbeddedId
    private MealDietEntityId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("mealId")
    private MealEntity mealEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("dietId")
    private DietEntity dietEntity;

    @Column(name = "weeknumber")
    private Long weekNumber;

    //TODO gettery settery. zmapowac po obu stroinach dlka diety i dla posiłku :)

    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass())
            return false;

        MealDietEntity that = (MealDietEntity) o;
        return Objects.equals(mealEntity, that.mealEntity) &&
                Objects.equals(dietEntity, that.dietEntity);
    }

    @Override
    public int hashCode(){
        return Objects.hash(mealEntity, dietEntity);
    }
}
