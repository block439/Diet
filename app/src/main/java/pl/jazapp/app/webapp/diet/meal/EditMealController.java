package pl.jazapp.app.webapp.diet.meal;


import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.diet.meals.MealEditService;
import pl.jazapp.app.diet.meals.MealEntity;
import pl.jazapp.app.diet.meals.MealSearchService;
import pl.jazapp.app.diet.meals.products.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
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
        mealEditService.saveMealProduct(meal.getProducts().iterator().next());

        return "/diets/meals/list.xhtml?faces-redirect=true";
    }


    public List<MealEntity> getListOfAllMeals(){
        return mealSearchService.listOfAllMeals();
    }


    public List<ProductEntity> getListOfAllProducts(){return productSearchService.listOfAllProducts();}


}
