package pl.jazapp.app.departments;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@ApplicationScoped
public class DepartmentEditService {



        @PersistenceContext
        private EntityManager em;

        @Transactional
        public void saveDepartment(DepartmentEntity departmentEntity){
            if(departmentEntity.getId() == null){
                em.persist(departmentEntity);
            }else {
                em.merge(departmentEntity);
            }
        }

        public DepartmentEntity getDepartmentById(Long departmentId){
            return em.find(DepartmentEntity.class, departmentId);
        }

}
