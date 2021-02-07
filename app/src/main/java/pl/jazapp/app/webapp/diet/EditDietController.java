package pl.jazapp.app.webapp.diet;


import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.diet.DietEditService;
import pl.jazapp.app.diet.DietEntity;
import pl.jazapp.app.diet.DietSearchService;
import pl.jazapp.app.diet.meals.MealDietEntity;
import pl.jazapp.app.diet.meals.MealEditService;
import pl.jazapp.app.diet.meals.MealEntity;
import pl.jazapp.app.diet.meals.MealSearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;
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
    @Inject
    DietSearchService dietSearchService;


    private EditDietRequest dietRequest;

    public EditDietRequest dietRequest(){
        if(dietRequest == null){
            if(parameterRetriever.contains("dietId")){
                var dietId = parameterRetriever.getParameterAsLong("dietId");
                var dietEntity = dietEditService.getDietById(dietId);
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
        dietEditService.saveDiet(diet);


        var mealList = new LinkedList<MealDietEntity>();
        var meals = dietEditService.getDietById(diet.getId()).getMeals().iterator();

        for(int i = 0; i<3 ; i++){
            var dietMeal = new MealDietEntity();

            if(diet.getId() != null && !dietEditService.getDietById(diet.getId()).getMeals().isEmpty() && meals.hasNext()){
               dietMeal.setId(meals.next().getId());
            }

            dietMeal.setDiet(diet);

            switch(i){
                case 0:
                    dietMeal.setMeal(mealEditService.getMealById(dietRequest.getMealId1()));
                    dietMeal.setDay_number(dietRequest.getDay_number1());
                    dietMeal.setMeal_number(dietRequest.getMeal_number1());
                    break;
                case 1:
                    dietMeal.setMeal(mealEditService.getMealById(dietRequest.getMealId2()));
                    dietMeal.setDay_number(dietRequest.getDay_number2());
                    dietMeal.setMeal_number(dietRequest.getMeal_number2());
                    break;
                case 2:
                    dietMeal.setMeal(mealEditService.getMealById(dietRequest.getMealId3()));
                    dietMeal.setDay_number(dietRequest.getDay_number3());
                    dietMeal.setMeal_number(dietRequest.getMeal_number3());
                    break;
                default:break;
            }

        mealList.add(dietMeal);
        }


        diet.getMeals().clear();
        diet.setMeals(mealList);


        dietEditService.saveDiet(diet);
        return "/diets/list.xhtml?faces-redirect=true";
    }

    public List<MealEntity> getListOfAllMeals(){
        return mealSearchService.listOfAllMeals();
    }
    public List<DietEntity> getListOfAllDiets(){
        return dietSearchService.listOfAllDiets();
    }

}
