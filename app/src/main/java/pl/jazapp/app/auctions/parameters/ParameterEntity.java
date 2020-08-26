package pl.jazapp.app.auctions.parameters;

import pl.jazapp.app.auctions.AuctionParameterEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="parameter")
public class ParameterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long parameterId;

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "parameter")
    //Set<AuctionParameterEntity> auctionParameterEntities = new HashSet<>();

    @Column(name="name")
    private String parameterName;

    public long getParameterId() {
        return parameterId;
    }

    public void setParameterId(long parameterId) {
        this.parameterId = parameterId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }
}
