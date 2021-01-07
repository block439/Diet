package pl.jazapp.app.users;


import pl.jazapp.app.diet.meals.MealDietEntityId;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserPreferenceEntityId implements Serializable {

    private Long ownerId;
    private Long preferenceId;


    public UserPreferenceEntityId(Long ownerId, Long preferenceId) {
        this.ownerId = ownerId;
        this.preferenceId = preferenceId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(Long preferenceId) {
        this.preferenceId = preferenceId;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass())
            return false;

        UserPreferenceEntityId that = (UserPreferenceEntityId) o;
        return Objects.equals(ownerId, that.ownerId) &&
                Objects.equals(preferenceId, that.preferenceId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(ownerId, preferenceId);
    }
}
