package pl.jazapp.app.departments;

import pl.jazapp.app.users.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DepartmentSearchService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<DepartmentEntity> listOfAllDepartments(){
        return em.createNamedQuery("Department.findAll", DepartmentEntity.class).getResultList();

    }

}
