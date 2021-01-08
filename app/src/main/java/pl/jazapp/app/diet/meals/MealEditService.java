package pl.jazapp.app.diet.meals;


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

    public MealEntity getMealById(Long mealId){
        return em.find(MealEntity.class, mealId);
    }

}
