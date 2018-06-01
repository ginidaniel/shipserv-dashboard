package dashboard.controllers;

import dashboard.enums.BookingStatus;
import dashboard.model.Booking;
import dashboard.model.Dashboard;
import dashboard.model.Itinerary;
import dashboard.services.BookingService;
import dashboard.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private BookingService bookingService;

    @GetMapping("/itineraries")
    public String itineraries(@RequestParam(name="company", required=false, defaultValue="ShipServ") String company, Model model) {
        List<Booking> bookings = bookingService.getBookingsByCompany(company, BookingStatus.WON);
        List<Itinerary> itineraries = bookingService.createItineraries(bookings);
        model.addAttribute("itineraries", itineraries);
        return "itineraries";
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam(name="company", required=false, defaultValue="ShipServ") String company, Model model) {
        try        {
            Dashboard db = companyService.getDashboard(company);
            db.setBookingsDB(bookingService.getBookingDB(company));
            model.addAttribute("db", db);
            return "dashboard";
        }
        catch (Exception e) {return "error";}
    }

}
