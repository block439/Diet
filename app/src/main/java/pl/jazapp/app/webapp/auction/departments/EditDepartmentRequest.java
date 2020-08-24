package pl.jazapp.app.webapp.auction.departments;

import pl.jazapp.app.departments.DepartmentEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EditDepartmentRequest {
    private Long id;
    private String name;

    public EditDepartmentRequest(){}

    public EditDepartmentRequest(DepartmentEntity departmentEntity){
        this.id = departmentEntity.getId();
        this.name = departmentEntity.getDepartmentName();
    }

    public DepartmentEntity toDepartmentEntity(){
        var departmentEntity = new DepartmentEntity();
        departmentEntity.setId(id);
        departmentEntity.setDepartmentName(name);
        return departmentEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
