package pl.jazapp.app.diet;


import pl.jazapp.app.diet.meals.MealEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class DietSearchService {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public List<DietEntity> listOfAllDiets(){
        return em.createNamedQuery("Diet.findAll", DietEntity.class).getResultList();
    }
}
