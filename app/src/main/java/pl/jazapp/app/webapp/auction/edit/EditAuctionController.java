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
import javax.faces.context.FacesContext;
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

        if(photoService.getPhotoByAuction(auction).size() == 0){
        var auctionPhotoList = new LinkedList<PhotoEntity>();
        if(editAuctionRequest.getPhoto1()!= null){
            auctionPhotoList.add(new PhotoEntity(null, editAuctionRequest.getPhoto1(), auction));
        }  if(editAuctionRequest.getPhoto2()!= null){
            auctionPhotoList.add(new PhotoEntity(null, editAuctionRequest.getPhoto2(), auction));
        }  if(editAuctionRequest.getPhoto3()!= null){
            auctionPhotoList.add(new PhotoEntity(null, editAuctionRequest.getPhoto3(), auction));
        }
            auction.setPhotoList(auctionPhotoList);
        } else {
            var oldPhotoList = photoService.getPhotoByAuction(auction).listIterator();
            for(int i=0; i<photoService.getPhotoByAuction(auction).size(); i++){
            auction.removePhoto(oldPhotoList.next());}

            if(editAuctionRequest.getPhoto1()!= null){
                auction.addPhoto(new PhotoEntity(null, editAuctionRequest.getPhoto1(), auction));
            }  if(editAuctionRequest.getPhoto2()!= null){
                auction.addPhoto(new PhotoEntity(null, editAuctionRequest.getPhoto2(), auction));
            }  if(editAuctionRequest.getPhoto3()!= null){
                auction.addPhoto(new PhotoEntity(null, editAuctionRequest.getPhoto3(), auction));
            }


        }



        auctionEditService.saveAuction(auction);

        return "/auctions/list.xhtml?faces-redirect=true";
    }
    public List<CategoriesEntity> getListOfAllCategories() {return categorySearchService.listOfAllCategories();}
    public List<AuctionEntity> getListOfAllAuctions() {return auctionSearchService.listOfAllAuctions();}
    public List<AuctionEntity> getListOfAllMineAuctions() {return auctionSearchService.listOfAllMineAuctions(userContext.getUsername());}



}
