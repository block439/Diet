package pl.jazapp.app.webapp.diet.meal;


import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.diet.meals.MealEditService;
import pl.jazapp.app.diet.meals.products.ProductEntity;
import pl.jazapp.app.diet.meals.products.ProductSearchService;

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
    ProductSearchService productSearchService;

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
        mealEditService.saveMeal(mealRequest.toMealEntity());
        return "diets/meals/list.xhtml?faces-redirect=true";
    }


    public List<ProductEntity> getListOfAllProducts(){
        return productSearchService.listOfAllProducts();

    }





}
