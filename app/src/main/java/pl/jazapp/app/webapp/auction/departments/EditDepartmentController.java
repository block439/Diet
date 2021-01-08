package pl.jazapp.app.webapp.auction.departments;

import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.departments.DepartmentEditService;
import pl.jazapp.app.departments.DepartmentEntity;
import pl.jazapp.app.departments.DepartmentSearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class EditDepartmentController {

    @Inject
    DepartmentEditService departmentEditService;
    @Inject
    DepartmentSearchService searchService;

    @Inject
    ParameterRetriever parameterRetriever;

    private EditDepartmentRequest editDepartmentRequest;

    public EditDepartmentRequest departmentRequest(){
        if (editDepartmentRequest == null){
            if(parameterRetriever.contains("departmentId")) {
                var departmentId = parameterRetriever.getParameterAsLong("departmentId");
                var departmentEntity = departmentEditService.getDepartmentById(departmentId);
                editDepartmentRequest = new EditDepartmentRequest(departmentEntity);
            } else {
                 editDepartmentRequest= new EditDepartmentRequest();
            }

        }
        return editDepartmentRequest;
    }

    public String save(){
        departmentEditService.saveDepartment(editDepartmentRequest.toDepartmentEntity());
        return "/departments/list.xhtml?faces-redirect=true";
    }

    public List<DepartmentEntity> getListOfAllDepartments() {return searchService.listOfAllDepartments();}


}
