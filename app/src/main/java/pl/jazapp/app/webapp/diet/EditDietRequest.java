package pl.jazapp.app.webapp.diet;


import pl.jazapp.app.diet.DietEditService;
import pl.jazapp.app.diet.DietEntity;
import pl.jazapp.app.diet.meals.MealDietEntity;
import pl.jazapp.app.diet.meals.MealEditService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Iterator;

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
    private Long mealId1;
    private Long mealId2;
    private Long mealId3;
    private Long meal_number1;
    private Long meal_number2;
    private Long meal_number3;
    private Long day_number1;
    private Long day_number2;
    private Long day_number3;
    private String param1;
    private String param2;
    private String param3;
    private String value1;
    private String value2;
    private String value3;
    private Iterator<MealDietEntity> mealDietEntityIterator;

    public EditDietRequest(){}

    public EditDietRequest(DietEntity dietEntity){
        this.id = dietEntity.getId();
        this.title = dietEntity.getTitle();
        this.description = dietEntity.getDescription();

        this.mealDietEntityIterator = dietEntity.getMeals().iterator();
        var meal = mealDietEntityIterator.next();
        this.meal_number1 = meal.getMeal_number();
        this.mealId1 = meal.getMeal().getId();
        this.day_number1 = meal.getDay_number();

        if(mealDietEntityIterator.hasNext()) {
            meal = mealDietEntityIterator.next();
            this.meal_number2 = meal.getMeal_number();
            this.mealId2 = meal.getMeal().getId();
            this.day_number2 = meal.getDay_number();
        }

        if(mealDietEntityIterator.hasNext()) {
            meal = mealDietEntityIterator.next();
            this.meal_number3 = meal.getMeal_number();
            this.mealId3 = meal.getMeal().getId();
            this.day_number3 = meal.getDay_number();
        }
    }

    public DietEntity toDietEntity(){
        var dietEntity = new DietEntity();
        dietEntity.setId(id);
        dietEntity.setTitle(title);
        dietEntity.setDescription(description);
        return dietEntity;
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

    public Long getMealId1() {
        return mealId1;
    }

    public void setMealId1(Long mealId1) {
        this.mealId1 = mealId1;
    }

    public Long getMealId2() {
        return mealId2;
    }

    public void setMealId2(Long mealId2) {
        this.mealId2 = mealId2;
    }

    public Long getMealId3() {
        return mealId3;
    }

    public void setMealId3(Long mealId3) {
        this.mealId3 = mealId3;
    }

    public Long getMeal_number1() {
        return meal_number1;
    }

    public void setMeal_number1(Long meal_number1) {
        this.meal_number1 = meal_number1;
    }

    public Long getMeal_number2() {
        return meal_number2;
    }

    public void setMeal_number2(Long meal_number2) {
        this.meal_number2 = meal_number2;
    }

    public Long getMeal_number3() {
        return meal_number3;
    }

    public void setMeal_number3(Long meal_number3) {
        this.meal_number3 = meal_number3;
    }

    public Long getDay_number1() {
        return day_number1;
    }

    public void setDay_number1(Long day_number1) {
        this.day_number1 = day_number1;
    }

    public Long getDay_number2() {
        return day_number2;
    }

    public void setDay_number2(Long day_number2) {
        this.day_number2 = day_number2;
    }

    public Long getDay_number3() {
        return day_number3;
    }

    public void setDay_number3(Long day_number3) {
        this.day_number3 = day_number3;
    }

    public Iterator<MealDietEntity> getMealDietEntityIterator() {
        return mealDietEntityIterator;
    }

    public void setMealDietEntityIterator(Iterator<MealDietEntity> mealDietEntityIterator) {
        this.mealDietEntityIterator = mealDietEntityIterator;
    }
}
