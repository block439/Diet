package pl.jazapp.app.diet.meals;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MealDietEntityId implements Serializable {

    private Long mealId;
    private Long dietId;

    public MealDietEntityId(){}

    public MealDietEntityId(Long mealId, Long dietId) {
        this.mealId = mealId;
        this.dietId = dietId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Long getDietId() {
        return dietId;
    }

    public void setDietId(Long dietId) {
        this.dietId = dietId;
    }



    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass())
            return false;

        MealDietEntityId that = (MealDietEntityId) o;
        return Objects.equals(mealId, that.mealId) &&
                Objects.equals(dietId, that.dietId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(mealId, dietId);
    }
}
