package pl.jazapp.app.webapp.diet.meal;



import pl.jazapp.app.diet.meals.MealEditService;
import pl.jazapp.app.diet.meals.MealEntity;
import pl.jazapp.app.diet.meals.photo.PhotoEntity;
import pl.jazapp.app.diet.meals.products.MealProductEntity;
import pl.jazapp.app.diet.meals.products.ProductEditService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;

@Named
@RequestScoped
public class EditMealRequest {

    @Inject
    ProductEditService productEditService;
    @Inject
    MealEditService mealEditService;

    private Long id;
    private String name;
    private String recipe;
    private String photo;
    //TODO edit tego productu na jakiś zbiór danych.
    private Long productId1;


    public EditMealRequest() {
    }

    public EditMealRequest(MealEntity mealEntity) {
        this.id = mealEntity.getId();
        this.name = mealEntity.getName();
        this.recipe = mealEntity.getRecipe();
        this.photo = mealEntity.getPhotoEntity().getUrl();
        this.productId1 = mealEntity.getProducts().iterator().next()
                            .getProduct().getId();
        //TODO przemyslec jak iterowac na tabeli laczacej i jednoczesnie na tabeli do niej połączonej
    }

    public MealEntity toMealEntity(){
        var mealEntity = new MealEntity();
        mealEntity.setId(id);
        mealEntity.setName(name);
        mealEntity.setRecipe(recipe);
        mealEntity.setPhotoEntity(new PhotoEntity(photo,mealEntity));
        var mealProduct = new MealProductEntity();
        mealProduct.setMeal(mealEntity);
        mealProduct.setProduct(productEditService.getProductById(productId1));
        var productsList = new LinkedList<MealProductEntity>();
        productsList.add(mealProduct);
        mealEntity.setProducts(productsList);
        return mealEntity;

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

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Long getProductId1() {
        return productId1;
    }

    public void setProductId1(Long productId1) {
        this.productId1 = productId1;
    }
}
