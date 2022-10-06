package com.etstour.hotelbooking.services;

import com.etstour.hotelbooking.entitiy.Reservation;
import com.etstour.hotelbooking.temp.CurrentReservation;

import java.util.Collection;

//Service Pattern for reservation

public interface ReservationService {

    public Reservation getReservationForLoggedUserById(int resId);

    public Collection<Reservation> getReservationsForLoggedUser();

    public void saveOrUpdateReservation(CurrentReservation currentReservation);

    public void deleteReservation(int resId);

    public CurrentReservation reservationToCurrentReservation(int resId);

}
