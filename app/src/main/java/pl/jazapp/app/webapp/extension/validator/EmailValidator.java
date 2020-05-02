package pl.jazapp.app.webapp.extension.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("emailValidator")
public class EmailValidator implements Validator<String> {

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if(!value.matches("\\b[\\pL0-9]+@[\\pL0-1]+\\.[\\pL]{2,}\\b")){
            throw new ValidatorException(new FacesMessage("Email is incorrect."));
        }
    }
}
