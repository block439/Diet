package pl.jazapp.app.diet.meals;


import pl.jazapp.app.diet.meals.products.ProductEntity;
import pl.jazapp.app.diet.meals.products.photo.PhotoEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class MealEditService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveMeal(MealEntity mealEntity, ProductEntity productEntity){
        if(mealEntity.getId() == null){
            em.persist(mealEntity);
        }else {
            //TODO wymyslec jak zapisywac najpierw mealentity i następnie mergować tabele product.
            em.merge(mealEntity);
        }
    }

    public MealEntity getMealById(Long mealId){
        return em.find(MealEntity.class, mealId);
    }

}
