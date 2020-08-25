package pl.jazapp.app.webapp.auction.edit;


import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.UserContext;
import pl.jazapp.app.auctions.AuctionEditService;
import pl.jazapp.app.auctions.AuctionEntity;
import pl.jazapp.app.auctions.AuctionSearchService;
import pl.jazapp.app.auctions.photos.PhotoEntity;
import pl.jazapp.app.categories.CategoriesEntity;
import pl.jazapp.app.categories.CategorySearchService;
import pl.jazapp.app.departments.DepartmentEntity;
import pl.jazapp.app.departments.DepartmentSearchService;
import pl.jazapp.app.users.UserSearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.LinkedList;
import java.util.List;


@Named
@RequestScoped
public class EditAuctionController {

    @Inject
    AuctionEditService auctionEditService;

    @Inject
    ParameterRetriever parameterRetriever;

    @Inject
    CategorySearchService categorySearchService;

    @Inject
    UserSearchService userSearchService;

    @Inject
    DepartmentSearchService departmentSearchService;

    @Inject
    UserContext userContext;

    @Inject
    AuctionSearchService auctionSearchService;


    private EditAuctionRequest editAuctionRequest;

    public EditAuctionRequest auctionRequest(){
        if (editAuctionRequest == null){
            if(parameterRetriever.contains("auctionId")) {
                var auctionId = parameterRetriever.getParameterAsLong("auctionId");
                var auctionEntity = auctionEditService.getAuctionById(auctionId);
                editAuctionRequest = new EditAuctionRequest(auctionEntity);
            } else {
                editAuctionRequest = new EditAuctionRequest();
            }

        }
        return editAuctionRequest;
    }
  /*  //todo przemyslec te injecty dzikie
    public LinkedList<PhotoEntity> photoEntityList(EditAuctionRequest editAuctionRequest){
        var auctionphoto = new LinkedList<PhotoEntity>();
        var auction = editAuctionRequest.toAuctionEntity();
        if(editAuctionRequest.getPhoto1()!=null){
            auctionphoto.add(new PhotoEntity());
        }

    }*/

    public String save(){
        editAuctionRequest.userSearchService= userSearchService;
        editAuctionRequest.categorySearchService=categorySearchService;
        editAuctionRequest.userContext = userContext;
        auctionEditService.saveAuction(editAuctionRequest.toAuctionEntity());
        return "/auctions/auctionlist.xhtml?faces-redirect=true";
    }
//TODO: tutaj zaimplementowac liste
    public List<CategoriesEntity> getListOfAllCategories() {return categorySearchService.listOfAllCategories();}
    public List<DepartmentEntity> getListOfAllDepartments() {return departmentSearchService.listOfAllDepartments();}
    public List<AuctionEntity> getListOfAllAuctions() {return auctionSearchService.listOfAllAuctions();}



}
