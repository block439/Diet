package pl.jazapp.app.auctions.parameters;

import javax.persistence.*;


@Entity
@Table(name="parameter")
public class ParameterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
/*
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parameter")
    Set<AuctionParameterEntity> auctionParameterEntities = new HashSet<>();*/

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
/*
    public Set<AuctionParameterEntity> getAuctionParameterEntities() {
        return auctionParameterEntities;
    }

    public void setAuctionParameterEntities(Set<AuctionParameterEntity> auctionParameterEntities) {
        this.auctionParameterEntities = auctionParameterEntities;
    }*/
}
