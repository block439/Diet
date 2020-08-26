package pl.jazapp.app.auctions.photos;


import pl.jazapp.app.auctions.AuctionEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class PhotoService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void savePhoto(PhotoEntity photoEntity,AuctionEntity auctionEntity){
        if(auctionEntity.getId() == null){
            em.persist(photoEntity);
        }else {
            em.merge(photoEntity);
        }
    }

    public AuctionEntity getAuctionById(Long auctionId){
        return em.find(AuctionEntity.class, auctionId);
    }

    //todo zrobic liste ze zdjeciami

}
