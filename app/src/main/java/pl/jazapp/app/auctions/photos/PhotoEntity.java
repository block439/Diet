package pl.jazapp.app.auctions.photos;


import pl.jazapp.app.auctions.AuctionEntity;

import javax.persistence.*;

@Entity
@Table(name="photo")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long photoId;

    @Column(name="url")
    private String url;

    @ManyToOne
    @JoinColumn(name="auction_id")
    private AuctionEntity auction;

    @Column(name="order")
    private Integer order;

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AuctionEntity getAuction() {
        return auction;
    }

    public void setAuction(AuctionEntity auction) {
        this.auction = auction;
    }
}
