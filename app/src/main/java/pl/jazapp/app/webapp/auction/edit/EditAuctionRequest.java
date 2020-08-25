package pl.jazapp.app.webapp.auction.edit;

import pl.jazapp.app.UserContext;
import pl.jazapp.app.auctions.AuctionEntity;
import pl.jazapp.app.categories.CategorySearchService;
import pl.jazapp.app.users.UserSearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
@RequestScoped
public class EditAuctionRequest {

    @Inject
    UserSearchService userSearchService;

    @Inject
    CategorySearchService categorySearchService;

    @Inject
    UserContext userContext;

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private Long version;
    private Long owner_id;
    private Long category_id;
    private String photo1;
    private String photo2;
    private String photo3;



    public EditAuctionRequest(AuctionEntity auctionEntity){
        this.id = auctionEntity.getId();
        this.title = auctionEntity.getTitle();
        this.description = auctionEntity.getDescription();
        this.price = auctionEntity.getPrice();
        this.version=auctionEntity.getVersion();
        this.owner_id=auctionEntity.getOwner().getId();
        this.category_id=auctionEntity.getCategory().getId();
        this.photo1=auctionEntity.getPhotoList().get(0).toString();
        this.photo2=auctionEntity.getPhotoList().get(1).toString();
        this.photo3=auctionEntity.getPhotoList().get(2).toString();
    }


    public EditAuctionRequest(){}
    public AuctionEntity toAuctionEntity(){
        var auctionEntity = new AuctionEntity();
        auctionEntity.setId(id);
        auctionEntity.setTitle(title);
        auctionEntity.setDescription(description);
        auctionEntity.setPrice(price);
        auctionEntity.setVersion(1L);
        auctionEntity.setOwner(userSearchService.findUser(userContext.getUsername()).get());
        auctionEntity.setCategory(categorySearchService.findCategoryById(category_id).get());
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


    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


}
