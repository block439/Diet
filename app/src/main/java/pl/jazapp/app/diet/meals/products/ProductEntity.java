package pl.jazapp.app.diet.meals.products;


import javax.persistence.*;

@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT d FROM ProductEntity d")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="name")
    private String name;

    @OneToOne(mappedBy = "product")
    private PhotoEntity photo;


    public ProductEntity(){}

    public ProductEntity(Long id, String name, PhotoEntity photoEntity) {
        this.id = id;
        this.name = name;
        this.photo = photoEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhotoEntity getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoEntity photoEntity) {
        this.photo = photoEntity;
    }
}
