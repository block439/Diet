package pl.jazapp.app.webapp.diet.meal.products;

import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.diet.meals.products.ProductEditService;
import pl.jazapp.app.diet.meals.products.ProductEntity;
import pl.jazapp.app.diet.meals.products.ProductSearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class EditProductController {

    @Inject
    ProductEditService productEditService;
    @Inject
    ParameterRetriever parameterRetriever;
    @Inject
    ProductSearchService productSearchService;



    private EditProductRequest editProductRequest;

    public EditProductRequest productRequest(){
        if(editProductRequest == null){
            if(parameterRetriever.contains("productId")){
                var productId = parameterRetriever.getParameterAsLong("productId");
                var productEntity = productEditService.getProductById(productId);
                editProductRequest = new EditProductRequest(productEntity);
            } else{
                editProductRequest= new EditProductRequest();
            }
        }
        return editProductRequest;
    }

    public String save(){
        var product = editProductRequest.toProductEntity();
              productEditService.saveProduct(product);
        return "/diets/products/list.xhtml?faces-redirect=true";
    }

    //TODO zrobić liste wszytskich produktów List<ProductEntity>
    public List<ProductEntity> listOfAllProducts(){return productSearchService.listOfAllProducts();}
}
