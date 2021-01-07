package pl.jazapp.app.diet;



import pl.jazapp.app.auctions.parameters.ParameterEntity;
import pl.jazapp.app.diet.meals.MealEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="diet_parameter")
public class DietParameterEntity {

    @EmbeddedId
    private DietParameterEntityId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("dietId")
    private DietEntity diet;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("parameterId")
    private ParameterEntity parameter;

    @Column(name = "value")
    private String value;



    public DietParameterEntity(DietEntity diet, ParameterEntity parameter) {
        this.id = new DietParameterEntityId(diet.getId(), parameter.getId());
        this.diet = diet;
        this.parameter = parameter;
    }

    public DietParameterEntityId getId() {
        return id;
    }

    public void setId(DietParameterEntityId id) {
        this.id = id;
    }

    public DietEntity getDiet() {
        return diet;
    }

    public void setDiet(DietEntity diet) {
        this.diet = diet;
    }

    public ParameterEntity getParameter() {
        return parameter;
    }

    public void setParameter(ParameterEntity parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass())
            return false;

        DietParameterEntity that = (DietParameterEntity) o;
        return Objects.equals(diet, that.diet) &&
                Objects.equals(parameter, that.parameter);
    }

    @Override
    public int hashCode(){
        return Objects.hash(diet, parameter);
    }
}
