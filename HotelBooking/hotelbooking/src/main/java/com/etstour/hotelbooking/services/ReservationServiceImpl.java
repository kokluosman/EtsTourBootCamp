package com.etstour.hotelbooking.services;

import com.etstour.hotelbooking.entitiy.Reservation;
import com.etstour.hotelbooking.repository.ReservationRepository;
import com.etstour.hotelbooking.temp.CurrentReservation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final UserService userService;

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(UserService userService, ReservationRepository reservationRepository) {
        this.userService = userService;
        this.reservationRepository = reservationRepository;
    }

    //get reservation for logged user
    @Override
    @Transactional
    public Reservation getReservationForLoggedUserById(int resId) {
        return reservationRepository.findById(resId);
    }

    //get all reservations for logged user
    @Override
    @Transactional
    public Collection<Reservation> getReservationsForLoggedUser() {
        return reservationRepository.findAllByUserId(userService.getLoggedUserId());
    }

    //Transfer data between temp reservation and
    //Reservation Class after check it to save it
    @Override
    @Transactional
    public void saveOrUpdateReservation(CurrentReservation currentReservation) {
        Reservation reservation = new Reservation();
        //get required id user using user service
        reservation.setUserId(userService.getLoggedUserId());

        reservation.setArrivalDate(currentReservation.getArrivalDate());
        reservation.setOpenbuffet(currentReservation.getOpenBuffet());
        reservation.setStayDays(currentReservation.getStayPeriod());
        reservation.setChildren(currentReservation.getChildren());
        reservation.setPersons(currentReservation.getPersons());
        reservation.setPrice(currentReservation.getPrice());
        reservation.setRooms(currentReservation.getRooms());
        reservation.setRoom(currentReservation.getRoom());
        reservation.setId(currentReservation.getId());

        reservationRepository.save(reservation);
    }

    //transfer data between Reservation and Temp Reservation Class update request
    @Override
    public CurrentReservation reservationToCurrentReservation(int resId) {

        Reservation reservation = getReservationForLoggedUserById(resId);
        CurrentReservation currentReservation = new CurrentReservation();

        currentReservation.setArrivalDate(reservation.getArrivalDate());
        currentReservation.setOpenBuffet(reservation.getOpenbuffet());
        currentReservation.setStayPeriod(reservation.getStayDays());
        currentReservation.setChildren(reservation.getChildren());
        currentReservation.setPersons(reservation.getPersons());
        currentReservation.setUsertId(reservation.getUserId());
        currentReservation.setRooms(reservation.getRooms());
        currentReservation.setRoom(reservation.getRoom());
        currentReservation.setPrice(reservation.getPrice());
        currentReservation.setId(reservation.getId());
        return currentReservation;
    }



    @Transactional
    @Override
    public void deleteReservation(int resId) {
        reservationRepository.deleteById(resId);
    }

}
