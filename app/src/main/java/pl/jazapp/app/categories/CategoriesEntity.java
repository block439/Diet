package pl.jazapp.app.categories;

import pl.jazapp.app.departments.DepartmentEntity;

import javax.persistence.*;

@Entity
@Table(name="category")
public class CategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="department_id")
    private DepartmentEntity department;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}
