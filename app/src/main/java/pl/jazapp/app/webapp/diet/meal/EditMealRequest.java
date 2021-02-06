package pl.jazapp.app.webapp.diet.meal;


import pl.jazapp.app.diet.meals.MealEditService;
import pl.jazapp.app.diet.meals.MealEntity;
import pl.jazapp.app.diet.meals.photo.PhotoEntity;
import pl.jazapp.app.diet.meals.products.MealProductEntity;
import pl.jazapp.app.diet.meals.products.ProductEditService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Iterator;
import java.util.List;

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
    private Long productId1;
    private Long productId2;
    private Long productId3;
    private Double amount1;
    private Double amount2;
    private Double amount3;
    private Iterator<MealProductEntity> productEntityIterator;


    public EditMealRequest() {
    }

    public EditMealRequest(MealEntity mealEntity) {
        this.id = mealEntity.getId();
        this.name = mealEntity.getName();
        this.recipe = mealEntity.getRecipe();
        this.photo = mealEntity.getPhotoEntity().getUrl();
        this.productEntityIterator = mealEntity.getProducts().iterator();
        var product = productEntityIterator.next();
        this.productId1 = product.getProduct().getId();
        this.amount1 = product.getAmount();

        if(productEntityIterator.hasNext()) {
            product = productEntityIterator.next();
            this.productId2 = product.getProduct().getId();
            this.amount2 = product.getAmount();
        }
        if(productEntityIterator.hasNext()){
            product = productEntityIterator.next();
            this.productId3 = product.getProduct().getId();
            this.amount3 = product.getAmount();
        }
    }

    public MealEntity toMealEntity(){
        var mealEntity = new MealEntity();
        mealEntity.setId(id);
        mealEntity.setName(name);
        mealEntity.setRecipe(recipe);
        mealEntity.setPhotoEntity(new PhotoEntity(photo,mealEntity));
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

    public Iterator<MealProductEntity> getProducts() {
        return productEntityIterator;
    }

    public Long getProductId2() {
        return productId2;
    }

    public void setProductId2(Long productId2) {
        this.productId2 = productId2;

    }

    public Long getProductId3() {
        return productId3;
    }

    public void setProductId3(Long productId3) {
        this.productId3 = productId3;
    }

    public void setProducts(Iterator<MealProductEntity> product) {
        this.productEntityIterator = product;
    }

    public Double getAmount1() {
        return amount1;
    }

    public void setAmount1(Double amount1) {
        this.amount1 = amount1;
    }

    public Double getAmount2() {
        return amount2;
    }

    public void setAmount2(Double amount2) {
        this.amount2 = amount2;
    }

    public Double getAmount3() {
        return amount3;
    }

    public void setAmount3(Double amount3) {
        this.amount3 = amount3;
    }
}
