package pl.jazapp.app.departments;

import pl.jazapp.app.categories.CategoriesEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="department")
@NamedQuery(name="Department.findAll", query="SELECT d FROM DepartmentEntity d")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column(name="name")
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<CategoriesEntity> categories;

    public List<CategoriesEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesEntity> categories) {
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long departmentId) {
        this.id = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
