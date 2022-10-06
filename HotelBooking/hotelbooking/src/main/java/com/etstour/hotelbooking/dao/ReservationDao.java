package com.etstour.hotelbooking.dao;


import com.etstour.hotelbooking.entitiy.Reservation;

import java.util.Collection;

//DAO Pattern or Reservation
public interface ReservationDao {

    public Reservation getReservationForLoggedUserById(int resId);
    public Collection<Reservation> getReservationsUserById(int resId);

    public void saveOrUpdateReservation(Reservation reservation);

    public void deleteReservation(Reservation reservation);

}
