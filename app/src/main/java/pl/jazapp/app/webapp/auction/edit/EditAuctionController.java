package pl.jazapp.app.webapp.auction.edit;


import pl.jazapp.app.ParameterRetriever;
import pl.jazapp.app.auctions.AuctionEditService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class EditAuctionController {

    @Inject
    AuctionEditService auctionEditService;

    @Inject
    ParameterRetriever parameterRetriever;

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
        auctionEditService.saveAuction(editAuctionRequest.toAuctionEntity());
        return "/auctions/auctionlist.xhtml?faces-redirect=true";
    }
//TODO: tutaj zaimplementowac liste

    public List<String> getListOfAllCategories() {return List.of("1","2","3");}

}
