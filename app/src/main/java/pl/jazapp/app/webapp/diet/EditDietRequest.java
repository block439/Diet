package pl.jazapp.app.webapp.diet;


import pl.jazapp.app.diet.DietEditService;
import pl.jazapp.app.diet.DietEntity;
import pl.jazapp.app.diet.meals.MealDietEntity;
import pl.jazapp.app.diet.meals.MealEditService;
import pl.jazapp.app.diet.meals.MealEntity;
import pl.jazapp.app.webapp.diet.meal.EditMealRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Iterator;
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
    private Long meal_number1;
    private Long meal_number2;
    private Long meal_number3;
    private Long day_number;
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
        this.mealId = dietEntity.getMeals().iterator().next().getMeal().getId();
        this.mealDietEntityIterator = dietEntity.getMeals().iterator();
        var meal = mealDietEntityIterator.next();
        this.meal_number1 = meal.getMeal_number()
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

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Long getMeal_number() {
        return meal_number1;
    }

    public void setMeal_number(Long meal_number) {
        this.meal_number1 = meal_number;
    }

    public Long getDay_number() {
        return day_number;
    }

    public void setDay_number(Long day_number) {
        this.day_number = day_number;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }
}
