package pl.jazapp.app.auctions;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AuctionEditService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void saveAuction(AuctionEntity auctionEntity){
        if(auctionEntity.getId() == null){
            em.persist(auctionEntity);
        }else {
            em.merge(auctionEntity);
        }
    }

    public AuctionEntity getAuctionById(Long auctionId){
        return em.find(AuctionEntity.class, auctionId);
    }

    //todo zrobic liste ze zdjeciami

}
