package pl.jazapp.app.diet.meals;




import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MealSearchService {

        @PersistenceContext
        private EntityManager em;


        @Transactional
        public List<MealEntity> listOfAllMeals(){
            return em.createNamedQuery("Meal.findAll", MealEntity.class).getResultList();
        }



}
