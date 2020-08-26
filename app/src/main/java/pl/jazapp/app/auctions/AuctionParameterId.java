package pl.jazapp.app.auctions;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctionParameterId auctionParameterId = (AuctionParameterId) o;
        return Objects.equals(auctionId, auctionParameterId.auctionId) &&
                Objects.equals(parameterId, auctionParameterId.parameterId);
    }
}
