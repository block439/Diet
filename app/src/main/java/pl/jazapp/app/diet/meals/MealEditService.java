package pl.jazapp.app.diet.meals;


import pl.jazapp.app.diet.meals.products.MealProductEntity;
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
    public void saveMeal(MealEntity mealEntity){
        if(mealEntity.getId() == null){
            em.persist(mealEntity);
        }else {
            em.merge(mealEntity);
        }
    }

    @Transactional
    public void saveMealProduct(MealProductEntity mealProductEntity){
        if(mealProductEntity.getId() == null){
            em.persist(mealProductEntity);
        }else {
            em.merge(mealProductEntity);
        }
    }

    public MealEntity getMealById(Long mealId){
        return em.find(MealEntity.class, mealId);
    }

}
