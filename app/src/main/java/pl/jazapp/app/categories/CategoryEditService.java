package pl.jazapp.app.categories;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoryEditService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveCategory(CategoriesEntity categoriesEntity){
        if(categoriesEntity.getId() == null){
            em.persist(categoriesEntity);
        }else {
            em.merge(categoriesEntity);
        }
    }

    public CategoriesEntity getCategoryById(Long categoryId){
        return em.find(CategoriesEntity.class, categoryId);
    }
}
