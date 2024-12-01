package com.example.hotelbooking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HotelController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/reservation")
    public String reservationPage() {
        return "reservation";
    }

    @PostMapping("/reserveRoom")
    public String reserveRoom(@RequestParam String name,
                              @RequestParam String roomType,
                              @RequestParam int days,
                              Model model) {
        int bookingId = (int) (Math.random() * 10000); 
        model.addAttribute("message", "Room reserved successfully! Booking ID: " + bookingId);
        return "confirmation"; 
    }
    

    @GetMapping("/checkinout")
    public String checkInOutPage() {
        return "checkinout";
    }

    @PostMapping("/updateCheckIn")
    public String updateCheckIn(@RequestParam int bookingId,
                                 @RequestParam boolean isCheckIn,
                                 Model model) {
        String status = isCheckIn ? "Checked In" : "Checked Out";
        model.addAttribute("message", "Booking ID " + bookingId + " has been " + status + ".");
        return "confirmation";
    }

    @GetMapping("/billing")
    public String billingPage() {
        return "billing";
    }

    @PostMapping("/calculateBill")
    public String calculateBill(@RequestParam int bookingId, Model model) {
        double totalAmount = Math.random() * 1000 + 100;
        model.addAttribute("message", "Total bill for Booking ID " + bookingId + " is ₹" + String.format("%.2f", totalAmount));
        return "confirmation";
    }
    
}
