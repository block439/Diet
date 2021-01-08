package pl.jazapp.app.webapp.diet.meal.products;


import pl.jazapp.app.diet.meals.products.photo.PhotoEntity;
import pl.jazapp.app.diet.meals.products.ProductEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EditProductRequest {
    private Long id;
    private String name;
    private String photo;


    public EditProductRequest(){}

    public EditProductRequest(ProductEntity productEntity){
        this.id = productEntity.getId();
        this.name = productEntity.getName();
        this.photo = productEntity.getPhoto().getUrl();
    }

    public ProductEntity toProductEntity(){
        var productEntity = new ProductEntity();
        productEntity.setId(id);
        productEntity.setName(name);
        productEntity.setPhoto(new PhotoEntity(photo, productEntity));
        return productEntity;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
