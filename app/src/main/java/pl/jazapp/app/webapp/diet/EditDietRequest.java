package pl.jazapp.app.webapp.diet;


import pl.jazapp.app.diet.DietEditService;
import pl.jazapp.app.diet.DietEntity;
import pl.jazapp.app.diet.meals.MealDietEntity;
import pl.jazapp.app.diet.meals.MealEditService;
import pl.jazapp.app.webapp.diet.meal.EditMealRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;

@Named
@RequestScoped
public class EditDietRequest {


    @Inject
    DietEditService dietEditService;
    @Inject
    MealEditService mealEditService;


    private Long id;
    private String title;
    private String description;
    private Long mealId;

    public EditDietRequest(){}

    public EditDietRequest(DietEntity dietEntity){
        this.id = dietEntity.getId();
        this.title = dietEntity.getTitle();
        this.description = dietEntity.getDescription();
        this.mealId = dietEntity.getMeals().iterator().next().getMeal().getId();
    }

    public DietEntity toDietEntity(){
        var dietEntity = new DietEntity();
        dietEntity.setId(id);
        dietEntity.setTitle(title);
        dietEntity.setDescription(description);
        var dietMeal = new MealDietEntity();
        if(id != null){
            dietMeal.setId(dietEditService.getDietById(id).getMeals().iterator().next().getId());
        }
        dietMeal.setDiet(dietEntity);
        dietMeal.setMeal(mealEditService.getMealById(mealId));
        var mealList = new LinkedList<MealDietEntity>();
        mealList.add(dietMeal);
        dietEntity.setMeals(mealList);
        return dietEntity;
    }


    public MealEditService getMealEditService() {
        return mealEditService;
    }

    public void setMealEditService(MealEditService mealEditService) {
        this.mealEditService = mealEditService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }
}
