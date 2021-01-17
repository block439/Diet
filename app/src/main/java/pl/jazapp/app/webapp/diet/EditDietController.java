package pl.jazapp.app.webapp.diet;


import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.diet.DietEditService;
import pl.jazapp.app.diet.DietEntity;
import pl.jazapp.app.diet.DietSearchService;
import pl.jazapp.app.diet.meals.MealEditService;
import pl.jazapp.app.diet.meals.MealEntity;
import pl.jazapp.app.diet.meals.MealSearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class EditDietController {

    @Inject
    ParameterRetriever parameterRetriever;
    @Inject
    DietEditService dietEditService;
    @Inject
    MealEditService mealEditService;
    @Inject
    MealSearchService mealSearchService;


    private EditDietRequest dietRequest;

    public EditDietRequest dietRequest(){
        if(dietRequest == null){
            if(parameterRetriever.contains("dietId")){
                var dietId = parameterRetriever.getParameterAsLong("dietId");
                var dietEntity = dietRequest.dietEditService.getDietById(dietId);
                dietRequest = new EditDietRequest(dietEntity);
            }
            else
                dietRequest = new EditDietRequest();
        }
        return dietRequest;
    }



    public String save(){
        dietRequest.dietEditService = dietEditService;
        dietRequest.mealEditService = mealEditService;
        var diet = dietRequest.toDietEntity();
        dietEditService.saveMealDiet(diet.getMeals().iterator().next());
        return "diets/list.xhtml?faces-redirect=true";
    }

    public List<MealEntity> getListOfAllMeals(){
        return mealSearchService.listOfAllMeals();
    }

}
