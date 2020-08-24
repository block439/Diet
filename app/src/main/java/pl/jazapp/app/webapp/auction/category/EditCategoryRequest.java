package pl.jazapp.app.webapp.auction.category;

import pl.jazapp.app.categories.CategoriesEntity;
import pl.jazapp.app.departments.DepartmentEditService;
import pl.jazapp.app.departments.DepartmentEntity;
import pl.jazapp.app.departments.DepartmentSearchService;
import pl.jazapp.app.webapp.auction.departments.EditDepartmentRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditCategoryRequest {
    private Long id;
    private String name;
    private Long department;

    @Inject
    DepartmentEditService findDepartment;

    public EditCategoryRequest(){}

    public EditCategoryRequest(CategoriesEntity categoriesEntity){
        this.id = categoriesEntity.getId();
        this.name = categoriesEntity.getName();
        this.department = categoriesEntity.getDepartment().getId();
    }

    public CategoriesEntity toCategoryEntity(){
        var categoryEntity = new CategoriesEntity();
        categoryEntity.setId(id);
        categoryEntity.setName(name);
        categoryEntity.setDepartment(findDepartment.getDepartmentById(department));
        return categoryEntity;
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

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }
}
