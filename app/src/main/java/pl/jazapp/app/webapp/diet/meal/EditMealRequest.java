package pl.jazapp.app.webapp.diet.meal;


import pl.jazapp.app.diet.meals.MealDietEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class EditMealRequest {

    private Long id;
    private String name;
    private String recipe;
    private String photo;
    private List<MealDietEntity> mealDietEntityList;
}
