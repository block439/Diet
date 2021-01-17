package pl.jazapp.app.diet;


import pl.jazapp.app.diet.meals.MealDietEntity;
import pl.jazapp.app.diet.meals.MealEntity;
import pl.jazapp.app.diet.meals.products.MealProductEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class DietEditService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveDiet(DietEntity dietEntity){
        if(dietEntity.getId() == null){
            em.persist(dietEntity);
        }else {
            em.merge(dietEntity);
        }
    }
    @Transactional
    public void saveMealDiet(MealDietEntity mealDietEntity){
        if(mealDietEntity.getId() == null){
            em.persist(mealDietEntity);
        }else {
            em.merge(mealDietEntity);
        }
    }


    public DietEntity getDietById(Long dietId){
        return em.find(DietEntity.class, dietId);
    }

}
