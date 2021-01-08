package pl.jazapp.app.diet.meals.products;



import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductSearchService {

        @PersistenceContext
        private EntityManager em;


        @Transactional
        public List<ProductEntity> listOfAllProducts(){
            return em.createNamedQuery("Product.findAll", ProductEntity.class).getResultList();
        }



}
