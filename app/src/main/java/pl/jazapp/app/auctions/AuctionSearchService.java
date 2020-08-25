package pl.jazapp.app.auctions;

import pl.jazapp.app.categories.CategoriesEntity;
import pl.jazapp.app.departments.DepartmentEntity;
import pl.jazapp.app.users.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuctionSearchService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<AuctionEntity> listOfAllAuctions(){
        return em.createNamedQuery("Auction.findAll", AuctionEntity.class).getResultList();

    }
//todo napisac query
    @Transactional
    public Optional<AuctionEntity> listOfAllMineAuctions(Long owner){
        return em.createQuery("from AuctionEntity where owner = :owner_id", AuctionEntity.class)
                .setParameter("owner_id", owner)
                .getResultList().stream()
                .findFirst();

    }


}
