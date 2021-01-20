package pl.jazapp.app.diet.meals.products;


import pl.jazapp.app.diet.meals.MealEntity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MealProductEntityId implements Serializable {

    private static final long serialVersionUID = -2403746842148223177L;

    private Long mealId;
    private Long productId;

    public MealProductEntityId() {
    }

    public MealProductEntityId(Long mealId, Long productId) {
        this.mealId = mealId;
        this.productId = productId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass())
            return false;

        MealProductEntityId that = (MealProductEntityId) o;
        return Objects.equals(mealId, that.mealId) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(mealId, productId);
    }
}
