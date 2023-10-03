package org.example.data.service;


import jakarta.persistence.criteria.*;
import org.apache.log4j.Logger;
import org.example.data.model.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class Query {
    private static final Logger logger = Logger.getLogger(Query.class);
    private final EntityManagerFactory entityManagerFactory;

    public Query(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("osbb");
    }

    public void close(){
        entityManagerFactory.close();
    }

    public List<OsbbList> getListOfOsbb(){
        logger.info("Call getting list of osbb");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<OsbbList> criteriaQuery = criteriaBuilder.createQuery(OsbbList.class);

        Root<RightOfOwnership> root = criteriaQuery.from(RightOfOwnership.class);

        Join<RightOfOwnership, Osbb> osbb = root.join("osbb", JoinType.LEFT);
        Join<RightOfOwnership, RightToEntry> rte = root.join("rightToEntry");
        Join<RightOfOwnership, BuildingFlat> bt = root.join("buildingFlat");
        Join<BuildingFlat, Building> b = bt.join("building");
        Join<BuildingFlat, Flat> f = bt.join("flat");

        Predicate rightToEntry = criteriaBuilder.equal(rte.get("name"), "FORBIDDEN");

        Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
        Root<RightOfOwnership> ownershipRoot = subquery.from(RightOfOwnership.class);
        subquery.select(criteriaBuilder.count(ownershipRoot.get("id")));
        subquery.where(criteriaBuilder.equal(ownershipRoot.get("osbb").get("id"), osbb.get("id")));
        Predicate ownership = criteriaBuilder.lt(subquery, 2L);

        Predicate formOfOwnership = criteriaBuilder.equal(root.get("form"), "PRIVATE");

        Predicate allPredicate = criteriaBuilder.and(rightToEntry, formOfOwnership, ownership);

        criteriaQuery.select(
                criteriaBuilder.construct(
                    OsbbList.class,
                    osbb.get("firstName"),
                    osbb.get("lastName"),
                    osbb.get("email"),
                    b.get("address"),
                    f.get("number"),
                    f.get("sqr")
                    )
                ).distinct(true).where(allPredicate);

        TypedQuery<OsbbList> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }

}
