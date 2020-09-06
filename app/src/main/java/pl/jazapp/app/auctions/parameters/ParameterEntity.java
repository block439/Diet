package pl.jazapp.app.auctions.parameters;


import pl.jazapp.app.auctions.AuctionEntity;
import pl.jazapp.app.auctions.AuctionParameterId;

import javax.persistence.*;
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
