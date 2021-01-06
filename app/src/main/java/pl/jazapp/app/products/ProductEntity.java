package pl.jazapp.app.products;


import javax.persistence.*;

@Entity
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="name")
    private String name;

    @OneToOne(mappedBy = "product")
    private PhotoEntity photoEntity;


    public ProductEntity(Long id, String name, PhotoEntity photoEntity) {
        this.id = id;
        this.name = name;
        this.photoEntity = photoEntity;
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

    public PhotoEntity getPhotoEntity() {
        return photoEntity;
    }

    public void setPhotoEntity(PhotoEntity photoEntity) {
        this.photoEntity = photoEntity;
    }
}
