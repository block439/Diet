package pl.jazapp.app.auctions.parameters;


import pl.jazapp.app.auctions.AuctionEntity;
import pl.jazapp.app.auctions.AuctionParameterId;
import pl.jazapp.app.diet.DietParameterEntity;
import pl.jazapp.app.diet.meals.MealDietEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="parameter")
public class ParameterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="name")
    private String parameterName;

    @OneToMany(mappedBy = "parameter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DietParameterEntity> diets = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }
    

}
