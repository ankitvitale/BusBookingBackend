package com.BusBookingbackend.controller;

import com.BusBookingbackend.Model.EmailMessage;
import com.BusBookingbackend.Model.TripModel;
import com.BusBookingbackend.Model.TripRequest;
import com.BusBookingbackend.dao.EmailSenderServiceDao;
import com.BusBookingbackend.dao.VendorDao;
import com.BusBookingbackend.entity.Trip;
import com.BusBookingbackend.service.DriverService;
import com.BusBookingbackend.service.MailService;
import com.BusBookingbackend.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;
import java.util.List;


@RestController
public class TripController {

    @Autowired
    private TripService tripService;
    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private VendorDao vendorDao;
    @Autowired
    private DriverService driverService;
    @Autowired
    private MailService emailService;

    private final EmailSenderServiceDao emailSenderServicedao;

    public TripController(EmailSenderServiceDao emailSenderServicedao) {
        this.emailSenderServicedao = emailSenderServicedao;
    }

    @PreAuthorize("hasRole('Vendor')")
    @PostMapping("/addTrip")
    public String addTrip(@RequestBody TripModel tripModel) throws Throwable {


        String driverEmail = driverService.getDriverEmailById(tripModel.getDriverId());
              Date date= tripService.getDateById(tripModel.getDate());
             Time time= tripService.getTimeById(tripModel.getTime());
        if (driverEmail != null) {
            EmailMessage emailMessage = new EmailMessage();
            emailMessage.setTo(driverEmail);
            emailMessage.setMessage("Hello Sir,\n" +
                    "\n" +
                    "I hope this message finds you well. We wanted to inform you that your trip scheduling date is set for "+date+". We are looking forward to assisting you throughout your journey and ensuring a pleasant experience.\n" +
                    "\n" +
                    "Additionally, we would like to remind you that the current time is "+time+". Should you have any questions or need further assistance, please do not hesitate to reach out to us.\n" +
                    "\n" +
                    "Thank you for choosing our services. We wish you a wonderful and safe trip ahead.\n" +
                    "\n" +
                    "Best regards,\n" +
                    "Harmony Bus Pvt.Ltd\n" +
                    "Customer Service Team");
            emailMessage.setSubject("Your trip has been scheduled");

            emailService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
            tripService.addTrip(tripModel);
            return "Email sent successfully";
        } else {
            return "Driver email not found";

        }
    }
    @GetMapping("/findTrip")
    public List<Trip> findTrip(@RequestBody TripRequest tripRequest){
        return tripService.findTrip(tripRequest.getStart() ,tripRequest.getDestination(),tripRequest.getDate());
    }
    private void scheduleTripDeletion(TripModel tripModel) {
        taskScheduler.schedule(() -> {
            tripService.deleteTrip(tripModel.getId());
        },
                tripModel.getTime());
    }



}
