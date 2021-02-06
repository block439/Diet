package pl.jazapp.app.webapp.diet.meal;


import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.diet.meals.MealEditService;
import pl.jazapp.app.diet.meals.MealEntity;
import pl.jazapp.app.diet.meals.MealSearchService;
import pl.jazapp.app.diet.meals.products.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;

@Named
@RequestScoped
public class EditMealController {

    @Inject
    ParameterRetriever parameterRetriever;
    @Inject
    MealEditService mealEditService;
    @Inject
    MealSearchService mealSearchService;
    @Inject
    ProductSearchService productSearchService;
    @Inject
    ProductEditService productEditService;

    private EditMealRequest mealRequest;

    public EditMealRequest mealRequest(){
        if(mealRequest == null){
            if(parameterRetriever.contains("mealId")){
                var mealId = parameterRetriever.getParameterAsLong("mealId");
                var mealEntity = mealEditService.getMealById(mealId);
                mealRequest = new EditMealRequest(mealEntity);
            }
            else
                mealRequest = new EditMealRequest();
        }
        return mealRequest;
    }

    public String save(){
        mealRequest.productEditService=productEditService;
        mealRequest.mealEditService = mealEditService;

        var meal = mealRequest.toMealEntity();

        mealEditService.saveMeal(meal);

        var mealProduct = new MealProductEntity();
        if(meal.getId() != null && !mealEditService.getMealById(meal.getId()).getProducts().isEmpty()) {
                mealProduct.setId(mealEditService.getMealById(meal.getId()).getProducts().iterator().next().getId());
                meal.getProducts().clear();
        }
        mealProduct.setMeal(meal);
        mealProduct.setProduct(productEditService.getProductById(mealRequest.getProductId1()));

        var productsList = new LinkedList<MealProductEntity>();
        productsList.add(mealProduct);
        meal.setProducts(productsList);



        mealEditService.saveMeal(meal);

        return "/diets/meals/list.xhtml?faces-redirect=true";
    }


    public List<MealEntity> getListOfAllMeals(){
        return mealSearchService.listOfAllMeals();
    }


    public List<ProductEntity> getListOfAllProducts(){return productSearchService.listOfAllProducts();}


}
