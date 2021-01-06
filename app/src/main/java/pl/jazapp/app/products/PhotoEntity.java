package pl.jazapp.app.products;


import javax.persistence.*;
import javax.ws.rs.core.GenericEntity;

@Entity
@Table(name="productphoto")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="url")
    private String url;

    @OneToOne
    @JoinColumn(name="product_id")
    private ProductEntity productEntity;


    public PhotoEntity(Long id, String url, ProductEntity productEntity) {
        this.id = id;
        this.url = url;
        this.productEntity = productEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
