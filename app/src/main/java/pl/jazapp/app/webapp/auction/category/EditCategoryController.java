package pl.jazapp.app.webapp.auction.category;

import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.UserContext;
import pl.jazapp.app.auctions.photos.PhotoEntity;
import pl.jazapp.app.categories.CategoriesEntity;
import pl.jazapp.app.categories.CategoryEditService;
import pl.jazapp.app.categories.CategorySearchService;
import pl.jazapp.app.departments.DepartmentEntity;
import pl.jazapp.app.departments.DepartmentSearchService;
import pl.jazapp.app.users.UserSearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Named
@RequestScoped
public class EditCategoryController {

    @Inject
    CategoryEditService categoryEditService;
    @Inject
    CategorySearchService categorySearchService;
    @Inject
    DepartmentSearchService departmentSearchService;
    @Inject
    UserContext userContext;
    @Inject
    UserSearchService userSearchService;
    @Inject
    ParameterRetriever parameterRetriever;

    private EditCategoryRequest editCategoryRequest;

    public EditCategoryRequest categoryRequest(){
        if (editCategoryRequest == null){
            if(parameterRetriever.contains("categoryId")) {
                var categoryId = parameterRetriever.getParameterAsLong("categoryId");
                var categoryEntity = categoryEditService.getCategoryById(categoryId);
                editCategoryRequest = new EditCategoryRequest(categoryEntity);
            } else {
                editCategoryRequest= new EditCategoryRequest();
            }

        }
        return editCategoryRequest;
    }


    public String save(){
        editCategoryRequest.findDepartment = departmentSearchService;
        categoryEditService.saveCategory(editCategoryRequest.toCategoryEntity());
        return "/categories/list.xhtml?faces-redirect=true";
    }


    public List<CategoriesEntity> getListOfAllCategories() {return categorySearchService.listOfAllCategories();}
    public List<DepartmentEntity> getListOfAllDepartments() {return departmentSearchService.listOfAllDepartments();}


}
