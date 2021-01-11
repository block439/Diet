package pl.jazapp.app.webapp.diet.meal;



import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EditMealRequest {

    private Long id;
    private String name;
    private String recipe;

    //TODO przemyslec defaultowo ile skladnikow przyjac do bazy zeby okreslic jak ogarnac ten request
}
