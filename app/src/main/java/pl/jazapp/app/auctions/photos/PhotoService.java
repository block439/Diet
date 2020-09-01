package pl.jazapp.app.auctions.photos;


import pl.jazapp.app.auctions.AuctionEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.ListIterator;

@ApplicationScoped
public class PhotoService {
    @PersistenceContext
    private EntityManager em;


    public List<PhotoEntity> getPhotoByAuction(AuctionEntity auction){
        return em.createQuery("from PhotoEntity where auction = :auction", PhotoEntity.class)
                .setParameter("auction", auction)
                .getResultList();


    }


}
