package pl.jazapp.app.webapp.extension.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("usernameValidator")
public class UsernameValidator implements Validator<String> {

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException{
        if(!value.matches("[\\p{Ll}0-9]*")){
            throw new ValidatorException(new FacesMessage("Username can contain only numbers and small letters."));
        }
    }
}

