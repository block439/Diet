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
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parameter", cascade = CascadeType.ALL)
    Set<AuctionParameterEntity> auctionParameterEntities = new HashSet<>();

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

    public Set<AuctionParameterEntity> getAuctionParameterEntities() {
        return auctionParameterEntities;
    }

    public void setAuctionParameterEntities(Set<AuctionParameterEntity> auctionParameterEntities) {
        this.auctionParameterEntities = auctionParameterEntities;
    }
}
