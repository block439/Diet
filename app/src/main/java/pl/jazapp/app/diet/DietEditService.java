package pl.jazapp.app.diet;


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
    public void saveMeal(DietEntity dietEntity){
        if(dietEntity.getId() == null){
            em.persist(dietEntity);
        }else {
            em.merge(dietEntity);
        }
    }


    public DietEntity getDietById(Long dietId){
        return em.find(DietEntity.class, dietId);
    }

}
