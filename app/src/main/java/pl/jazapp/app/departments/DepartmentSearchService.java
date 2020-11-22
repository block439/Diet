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

    @Transactional
    public Optional<DepartmentEntity> findDepartment(Long id){
        return em.createQuery("from DepartmentEntity where id = :id", DepartmentEntity.class)
                .setParameter("id", id)
                .getResultList().stream()
                .findFirst();

    }

}
