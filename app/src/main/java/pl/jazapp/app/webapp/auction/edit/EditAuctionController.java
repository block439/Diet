package pl.jazapp.app.webapp.auction.edit;


import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.UserContext;
import pl.jazapp.app.auctions.AuctionEditService;
import pl.jazapp.app.auctions.AuctionEntity;
import pl.jazapp.app.auctions.AuctionParameterEntity;
import pl.jazapp.app.auctions.AuctionSearchService;
import pl.jazapp.app.auctions.parameters.ParameterEntity;
import pl.jazapp.app.auctions.photos.PhotoEntity;
import pl.jazapp.app.auctions.photos.PhotoService;
import pl.jazapp.app.categories.CategoriesEntity;
import pl.jazapp.app.categories.CategorySearchService;
import pl.jazapp.app.users.UserSearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


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
        var auctionPhotoList = new LinkedList<PhotoEntity>();


        if(photoService.getPhotoByAuction(auction).size() == 0){

            if(editAuctionRequest.getPhoto1()!= null){
                auctionPhotoList.add(new PhotoEntity(null, editAuctionRequest.getPhoto1(), auction));
            }  if(editAuctionRequest.getPhoto2()!= null){
                auctionPhotoList.add(new PhotoEntity(null, editAuctionRequest.getPhoto2(), auction));
            }  if(editAuctionRequest.getPhoto3()!= null){
                auctionPhotoList.add(new PhotoEntity(null, editAuctionRequest.getPhoto3(), auction));
            }
            auction.setPhotoList(auctionPhotoList);
        } else {
            auction = auctionEditService.getAuctionById(editAuctionRequest.getId());
            List<PhotoEntity> photoList = photoService.getPhotoByAuction(auction);
            if(editAuctionRequest.getPhoto1()!= null){
                photoList.get(0).setId(auction.getPhotoList().get(0).getId());
                photoList.get(0).setUrl(editAuctionRequest.getPhoto1());
            }  if(editAuctionRequest.getPhoto2()!= null){
                photoList.get(1).setId(auction.getPhotoList().get(1).getId());
                photoList.get(1).setUrl(editAuctionRequest.getPhoto2());
            }  if(editAuctionRequest.getPhoto3()!= null){
                photoList.get(2).setId(auction.getPhotoList().get(2).getId());
                photoList.get(2).setUrl(editAuctionRequest.getPhoto3());
            }
            auction.setPhotoList(photoList);
        }
/*
        var auctionParameterList = new HashSet<AuctionParameterEntity>();
        if(auctionEditService.getAuctionById(editAuctionRequest.getId()).getAuctionParameterEntities() == null){
            var param = new ParameterEntity();
            var auctionParameter = new AuctionParameterEntity();
            if(editAuctionRequest.getParam1() != null){
            param.setParameterName(editAuctionRequest.getParam1());
            param.setAuctionParameterEntities(Set.of(auctionParameter));
            auctionParameter.setParameter(param);
            auctionParameter.setAuction(auction);
            auctionParameter.setValue(editAuctionRequest.getParamVal1());
            auctionParameterList.add(auctionParameter);}

            if(editAuctionRequest.getParam2() != null){
                param = new ParameterEntity();
                auctionParameter = new AuctionParameterEntity();
                param.setParameterName(editAuctionRequest.getParam2());
                param.setAuctionParameterEntities(Set.of(auctionParameter));
                auctionParameter.setParameter(param);
                auctionParameter.setAuction(auction);
                auctionParameter.setValue(editAuctionRequest.getParamVal2());
                auctionParameterList.add(auctionParameter);}

            if(editAuctionRequest.getParam3() != null){
                param = new ParameterEntity();
                auctionParameter = new AuctionParameterEntity();
                param.setParameterName(editAuctionRequest.getParam3());
                param.setAuctionParameterEntities(Set.of(auctionParameter));
                auctionParameter.setParameter(param);
                auctionParameter.setAuction(auction);
                auctionParameter.setValue(editAuctionRequest.getParamVal3());
                auctionParameterList.add(auctionParameter);}
            auction.setAuctionParameterEntities(auctionParameterList);
        }*/




        auctionEditService.saveAuction(auction);

        return "/auctions/list.xhtml?faces-redirect=true";
    }
    public List<CategoriesEntity> getListOfAllCategories() {return categorySearchService.listOfAllCategories();}
    public List<AuctionEntity> getListOfAllAuctions() {return auctionSearchService.listOfAllAuctions();}
    public List<AuctionEntity> getListOfAllMineAuctions() {return auctionSearchService.listOfAllMineAuctions(userContext.getUsername());}



}
