package pl.jazapp.app.auctions;

import pl.jazapp.app.auctions.parameters.ParameterEntity;

import javax.persistence.*;

@Entity
@Table(name="auction_parameter")
public class AuctionParameterEntity {


    @EmbeddedId
    private AuctionParameterId auctionParameterId = new AuctionParameterId();

    @ManyToOne
    @MapsId("auctionId")
    @JoinColumn(name = "auction_id")
    private AuctionEntity auction;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("parameterId")
    @JoinColumn(name = "parameter_id")
    private ParameterEntity parameter = new ParameterEntity();

    @Column(name = "value")
    private String value;

    public AuctionParameterEntity() { }
    public AuctionParameterEntity(ParameterEntity parameter)
    {
        this.parameter = parameter;
    }

    public AuctionParameterId getAuctionParameterId() {
        return auctionParameterId;
    }

    public void setAuctionParameterId(AuctionParameterId auctionParameterId) {
        this.auctionParameterId = auctionParameterId;
    }

    public AuctionEntity getAuction() {
        return auction;
    }

    public void setAuction(AuctionEntity auction) {
        this.auction = auction;
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
}
