package pl.jazapp.app.categories;

import pl.jazapp.app.departments.DepartmentEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategorySearchService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<CategoriesEntity> listOfAllCategories(){
        return em.createNamedQuery("Category.findAll", CategoriesEntity.class).getResultList();

    }

    @Transactional
    public Optional<CategoriesEntity> findCategoryById(Long id){
        return em.createQuery("from CategoriesEntity where id = :id", CategoriesEntity.class)
                .setParameter("id", id)
                .getResultList().stream()
                .findFirst();

    }


}
