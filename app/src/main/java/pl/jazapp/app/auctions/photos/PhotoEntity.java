package pl.jazapp.app.auctions.photos;


import pl.jazapp.app.auctions.AuctionEntity;

import javax.persistence.*;


public class PhotoEntity {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column
    private Long id;

   // @Column(name="url")
    private String url;

   // @ManyToOne
   // @JoinColumn(name="auction_id")
    private AuctionEntity auction;


    public PhotoEntity(){}

    public PhotoEntity(Long id, String url, AuctionEntity auction){
        this.id = id;
        this.url=url;
        this.auction=auction;
    }
    public PhotoEntity(String url){
        this.url = url;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long photoId) {
        this.id = photoId;
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
