package pl.jazapp.app.auctions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AuctionParameterId implements Serializable {


    private Long auctionId;
    private Long parameterId;

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public AuctionParameterId() {
    }



    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        if(o == null || getClass() != o.getClass())
            return false;

        AuctionParameterId that = (AuctionParameterId)o;
        return Objects.equals(auctionId, that.auctionId) &&
                Objects.equals(parameterId, that.parameterId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(auctionId, parameterId);
    }

}
