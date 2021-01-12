package pl.jazapp.app.webapp.diet.meal;



import pl.jazapp.app.diet.meals.MealEntity;
import pl.jazapp.app.diet.meals.photo.PhotoEntity;
import pl.jazapp.app.diet.meals.products.ProductEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EditMealRequest {

    private Long id;
    private String name;
    private String recipe;
    private String photo;
    private Long productId1;


    public EditMealRequest() {
    }

    public EditMealRequest(MealEntity mealEntity) {
        this.id = mealEntity.getId();
        this.name = mealEntity.getName();
        this.recipe = mealEntity.getRecipe();
        this.photo = mealEntity.getPhotoEntity().getUrl();
        this.productId1 = mealEntity.getProducts().iterator().next()
                            .getId().getProductId();
        //TODO przemyslec jak iterowac na tabeli laczacej i jednoczesnie na tabeli do niej połączonej
    }

    public MealEntity toMealEntity(){
        var mealEntity = new MealEntity();
        mealEntity.setId(id);
        mealEntity.setName(name);
        mealEntity.setRecipe(recipe);
        mealEntity.setPhotoEntity(new PhotoEntity(photo,mealEntity));
        mealEntity.setProducts(new ProductEntity());
    }
}
