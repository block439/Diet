package pl.jazapp.app.auctions;

import pl.jazapp.app.auctions.photos.PhotoEntity;
import pl.jazapp.app.categories.CategoriesEntity;
import pl.jazapp.app.users.UserEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "auction")
@NamedQuery(name="Auction.findAll", query="SELECT d FROM AuctionEntity d")
public class AuctionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name="version")
    private Long version;

    @ManyToOne
    @JoinColumn(name ="owner_id")
    private UserEntity owner;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private CategoriesEntity category;

    @OneToMany(mappedBy = "auction",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PhotoEntity> photoList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "auction", cascade = CascadeType.ALL)
   private Set<AuctionParameterEntity> auctionParameterEntities = new HashSet<>();



    public java.lang.Long getId() {
        return id;
    }

    public List<PhotoEntity> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PhotoEntity> photoList) {
        this.photoList = photoList;
    }


    public void setId(java.lang.Long id) {
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public CategoriesEntity getCategory() {
        return category;
    }

    public void setCategory(CategoriesEntity category) {
        this.category = category;
    }

   public Set<AuctionParameterEntity> getAuctionParameterEntities() {
        return auctionParameterEntities;
    }

    public void setAuctionParameterEntities(Set<AuctionParameterEntity> auctionParameterEntities) {
        this.auctionParameterEntities = auctionParameterEntities;
    }
}
