package pl.jazapp.app.diet.meals.products;

import org.hibernate.annotations.Cascade;
import pl.jazapp.app.diet.meals.MealEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="meal_product")
public class MealProductEntity {

    @EmbeddedId
    private MealProductEntityId id = new MealProductEntityId();

    @Column(name="amount")
    private double amount;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @MapsId("mealId")
    @JoinColumn(name="meal_id")
    private MealEntity meal;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @MapsId("productId")
    @JoinColumn(name="product_id")
    private ProductEntity product;


    public MealProductEntity() {
    }

    public MealProductEntity(MealEntity mealEntity, ProductEntity productEntity) {
        this.id = new MealProductEntityId(meal.getId(), product.getId());
        this.meal = mealEntity;
        this.product = productEntity;
        this.amount = 1;
    }

    public MealProductEntityId getId() {
        return id;
    }

    public void setId(MealProductEntityId id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public MealEntity getMeal() {
        return meal;
    }

    public void setMeal(MealEntity meal) {
        this.meal = meal;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity productEntity) {
        this.product = productEntity;
    }
}
