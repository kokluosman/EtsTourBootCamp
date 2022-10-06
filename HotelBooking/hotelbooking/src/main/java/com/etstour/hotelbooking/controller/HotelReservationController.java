package com.etstour.hotelbooking.controller;


import com.etstour.hotelbooking.services.ReservationService;
import com.etstour.hotelbooking.services.UserService;
import com.etstour.hotelbooking.temp.CurrentReservation;
import com.etstour.hotelbooking.temp.CurrentUser;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class HotelReservationController {

    private final UserService userService;
    private final ReservationService reservationService;

    public HotelReservationController(UserService userService, ReservationService reservationServicee) {
        this.userService = userService;
        this.reservationService = reservationServicee;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/")
    public String homePage(){
        return "home-page";
    }

    //login-page
    @GetMapping("/login-from-page")
    public String loginPage(Model model){
        // if user already login, redirect to home
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)){
            return "redirect:/";
        }
        //new user attribute for signup page
        model.addAttribute("newUser",new CurrentUser());
        return "/login";
    }

    //registration process page
    @PostMapping("/processReagistration")
    public String processRegistrationForm(@Valid @ModelAttribute("newUser")CurrentUser currentUser,
                                          BindingResult bindingResult, Model model){
        //check database if user already exists
        if (userService.findUserByEmail(currentUser.getEmail()) !=null ){
            model.addAttribute("newUser",new CurrentUser());
            model.addAttribute("registrtionError","Email already exist");
            return "login";
        }

        //create user account
        userService.saveUser(currentUser);
            model.addAttribute("registrationSuccess","registration Success");
        return "redirect:/login-form-page";
    }

    //bookingpage
    @GetMapping("/new-reservation")
    public String newReservation(Model model){
        //reservation attribute
        model.addAttribute("newRes",new CurrentUser());

        return "reservation-page";
    }

    //save new reservation

    @PostMapping("/proceed-reservation")
    public String proceedReservation(@Valid @ModelAttribute("newRes")CurrentReservation currentReservation,
                                     BindingResult bindingResult,Model model){

        //send Reservation to services to save it in database
        reservationService.saveOrUpdateReservation(currentReservation);
        return "redirect:/your-reservation";
    }

    //reservations of user

    @GetMapping("/your-reservations")
    public String reservationList(Model model){
        //list of reservations for logged user
        model.addAttribute(reservationService.getReservationsForLoggedUser());
        return "your-reservations";

    }

    //update reservation
    @PostMapping("/reservation-update")
    public String updateReservation(@RequestParam("resId") int resId,Model model){
        //new update reservation send to services to store it in database
        model.addAttribute("newRes",
                reservationService.reservationToCurrentReservation(resId));
        return "reservation-page";
    }

    //delete reservation
    @PostMapping("/reservation-delete")
    public String deleteReservation(@RequestParam("resId") int resId){
        //delete reservation send to services to delete from database
            reservationService.deleteReservation(resId);
        return "redirect:/your-reservations";
    }

    //logout
    @RequestMapping(value = "/Logout",method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){
        //handle logout for logged user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth !=null){
            new SecurityContextLogoutHandler().logout(request,response,auth);

        }
        return "redirect:/login-form-page?logout";
    }

}
