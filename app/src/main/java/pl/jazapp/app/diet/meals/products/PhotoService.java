package pl.jazapp.app.diet.meals.products;



import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class PhotoService {
    @PersistenceContext
    private EntityManager em;


    public List<PhotoEntity> getPhotoByProduct(ProductEntity product){
        return em.createQuery("from PhotoEntity where product = :product", PhotoEntity.class)
                .setParameter("product", product)
                .getResultList();
    }


}
