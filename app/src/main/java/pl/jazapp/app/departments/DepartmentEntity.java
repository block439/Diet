package pl.jazapp.app.departments;

import pl.jazapp.app.categories.CategoriesEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long departmentId;

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

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
