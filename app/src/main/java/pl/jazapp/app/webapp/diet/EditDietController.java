package pl.jazapp.app.webapp.diet;


import pl.jazapp.app.ParameterRetriever;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditDietController {

    @Inject
    ParameterRetriever parameterRetriever;

    private EditDietRequest editDietRequest;

    public EditDietRequest editDietRequest(){
        if(editDietRequest == null){
            if(parameterRetriever.contains("dietId")){
                var dietId = parameterRetriever.getParameterAsLong("dietId");
                var dietEntity = editDietRequest.dietEditService.getDietById(dietId);
                editDietRequest = new EditDietRequest(dietEntity);
            }
        }return editDietRequest;//todo
    }
}
