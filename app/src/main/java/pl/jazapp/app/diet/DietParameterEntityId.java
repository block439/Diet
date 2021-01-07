package pl.jazapp.app.diet;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DietParameterEntityId implements Serializable {

    private Long dietId;
    private Long parameterId;

    public DietParameterEntityId(){}

    public DietParameterEntityId(Long dietId, Long parameterId) {
        this.dietId = dietId;
        this.parameterId = parameterId;
    }

    public Long getDietId() {
        return dietId;
    }

    public void setDietId(Long dietId) {
        this.dietId = dietId;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass())
            return false;

        DietParameterEntityId that = (DietParameterEntityId) o;
        return Objects.equals(dietId, that.dietId) &&
                Objects.equals(parameterId, that.parameterId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(dietId, parameterId);
    }
}
