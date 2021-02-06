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
    private List<MealProductEntity> product;


    public EditMealRequest() {
    }

    public EditMealRequest(MealEntity mealEntity) {
        this.id = mealEntity.getId();
        this.name = mealEntity.getName();
        this.recipe = mealEntity.getRecipe();
        this.photo = mealEntity.getPhotoEntity().getUrl();
        this.product = mealEntity.getProducts();
        this.productId1 = product.iterator().next().getProduct().getId();
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

    public List<MealProductEntity> getProducts() {
        return product;
    }

    public void setProducts(List<MealProductEntity> product) {
        this.product = product;
    }
}
