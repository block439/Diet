package pl.jazapp.app.users;




import pl.jazapp.app.diet.meals.MealDietEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="user_preference")
public class UserPreferenceEntity {

    @EmbeddedId
    private UserPreferenceEntityId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ownerId")
    private UserEntity owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("preferenceId")
    private PreferenceEntity preference;

    @Column(name = "value")
    private String value;

    public UserPreferenceEntity(UserEntity owner, PreferenceEntity preference) {
        this.id = new UserPreferenceEntityId(owner.getId(), preference.getId());
        this.owner = owner;
        this.preference = preference;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass())
            return false;

        UserPreferenceEntity that = (UserPreferenceEntity) o;
        return Objects.equals(owner, that.owner) &&
                Objects.equals(preference, that.preference);
    }

    @Override
    public int hashCode(){
        return Objects.hash(owner, preference);
    }
}
