package pl.jazapp.app.diet.meals.products;


import javax.persistence.*;

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
    private ProductEntity product;


    public PhotoEntity(Long id, String url, ProductEntity product) {
        this.id = id;
        this.url = url;
        this.product = product;
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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
