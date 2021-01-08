package pl.jazapp.app.diet.meals.products;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ProductEditService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveProduct(ProductEntity productEntity){
        if(productEntity.getId() == null){
            em.persist(productEntity);
        }else {
            em.merge(productEntity);
        }
    }

    public ProductEntity getProductById(Long productId){
        return em.find(ProductEntity.class, productId);
    }

}
