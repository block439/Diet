package pl.jazapp.app.auctions.photos;


import pl.jazapp.app.auctions.AuctionEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PhotoService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void savePhoto(PhotoEntity photoEntity){
        if(photoEntity.getId() == null){
            em.persist(photoEntity);
        }else {
            em.merge(photoEntity);
        }
    }

    public List<PhotoEntity> getPhotoById(AuctionEntity auction){
        return em.createQuery("from PhotoEntity where auction = :auction", PhotoEntity.class)
                .setParameter("auction", auction)
                .getResultList();


    }


}
