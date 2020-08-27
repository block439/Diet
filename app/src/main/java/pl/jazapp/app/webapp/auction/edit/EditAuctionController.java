package pl.jazapp.app.webapp.auction.edit;


import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.UserContext;
import pl.jazapp.app.auctions.AuctionEditService;
import pl.jazapp.app.auctions.AuctionEntity;
import pl.jazapp.app.auctions.AuctionSearchService;
import pl.jazapp.app.auctions.photos.PhotoEntity;
import pl.jazapp.app.auctions.photos.PhotoService;
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
    PhotoService photoService;

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



    public String save(){
        editAuctionRequest.userSearchService=userSearchService;
        editAuctionRequest.categorySearchService=categorySearchService;
        editAuctionRequest.userContext=userContext;
        var auction = editAuctionRequest.toAuctionEntity();
        auctionEditService.saveAuction(auction);
        var photo1 = new PhotoEntity(null, editAuctionRequest.getPhoto1(), auction);
        var photo2 = new PhotoEntity(null, editAuctionRequest.getPhoto2(), auction);
        var photo3 = new PhotoEntity(null, editAuctionRequest.getPhoto3(), auction);
        photoService.savePhoto(photo1);
        photoService.savePhoto(photo2);
        photoService.savePhoto(photo3);
        return "/auctions/auctionlist.xhtml?faces-redirect=true";
    }
    public List<CategoriesEntity> getListOfAllCategories() {return categorySearchService.listOfAllCategories();}
    public List<AuctionEntity> getListOfAllAuctions() {return auctionSearchService.listOfAllAuctions();}
    public List<AuctionEntity> getListOfAllMineAuctions() {return auctionSearchService.listOfAllMineAuctions(userContext.getUsername());}



}
