package com.etstour.hotelbooking.dao;


import com.etstour.hotelbooking.entitiy.Reservation;
import com.etstour.hotelbooking.entitiy.Role;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class ReservationDaoImpl implements ReservationDao{

    private static EntityManager entityManager;

    private Session currentSession(){
        return entityManager.unwrap(Session.class);
    }

    @Override
    public Reservation getReservationForLoggedUserById(int resId) {

        //create query with HQL to get user
        Query<Reservation> query = currentSession().
                createQuery(" FROM Reservation Where id = :resId", Reservation.class);
        query.setParameter("resId",resId);

        //check if valid user and is exist or null

        return query.getSingleResult();
    }

    @Override
    public Collection<Reservation> getReservationsUserById(int userId) {
        //create query with HQL to get user
        Query<Reservation> query = currentSession().
                createQuery(" FROM Reservation Where userId = :userId", Reservation.class);
        query.setParameter("userId",userId);

        //check if valid user and is exist or null

        return query.getResultList();
    }

    @Override
    public void saveOrUpdateReservation(Reservation reservation) {
        currentSession().saveOrUpdate(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        currentSession().delete(reservation);

    }
}
