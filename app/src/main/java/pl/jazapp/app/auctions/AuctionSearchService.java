package pl.jazapp.app.auctions;

import pl.jazapp.app.User;
import pl.jazapp.app.UserContext;
import pl.jazapp.app.categories.CategoriesEntity;
import pl.jazapp.app.departments.DepartmentEntity;
import pl.jazapp.app.users.UserEntity;
import pl.jazapp.app.users.UserSearchService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
    public List<AuctionEntity> listOfAllMineAuctions(String username){
        UserEntity owner = em.
                createQuery("Select u from UserEntity u where u.username = :username", UserEntity.class).
                setParameter("username", username).getSingleResult();

        return em.createQuery("from AuctionEntity where owner = :owner", AuctionEntity.class)
                .setParameter("owner", owner)
                .getResultList();

    }


}
