package pl.jazapp.app.webapp.auction.edit;

import pl.jazapp.app.auctions.AuctionEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
@RequestScoped
public class EditAuctionRequest {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String photo1;
    private String photo2;
    private String photo3;
    private String parameter1;
    private String parameter2;
    private String parameter3;


//TODO: tutaj ten konsturktor ogarnąć.
    public EditAuctionRequest(AuctionEntity auctionEntity){
        this.id = auctionEntity.getId();
        this.title = auctionEntity.getTitle();
        this.description = auctionEntity.getDescription();
        this.price = auctionEntity.getPrice();
    }


    public EditAuctionRequest(){}
    public AuctionEntity toAuctionEntity(){
        var auctionEntity = new AuctionEntity();
        auctionEntity.setId(id);
        auctionEntity.setTitle(title);
        auctionEntity.setDescription(description);
        auctionEntity.setPrice(price);
        return auctionEntity;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getParameter1() {
        return parameter1;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public String getParameter3() {
        return parameter3;
    }

    public void setParameter3(String parameter3) {
        this.parameter3 = parameter3;
    }
}
