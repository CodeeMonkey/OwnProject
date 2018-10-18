package com.realdolmen.beans;

import com.realdolmen.domain.BookedflightEntity;
import com.realdolmen.domain.CustomerEntity;
import com.realdolmen.view.SearchView;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class BookingFlowBean implements Serializable {

    @Inject
    private SearchView searchView;
    @Inject
    private BookedFlightBean bookedflightRepo;

    private BookedflightEntity newBooking;

    public BookedflightEntity getNewBooking() {
        return newBooking;
    }

    private String payMethod = "payMethod";

    public void setNewBooking(BookedflightEntity newBooking) {
        this.newBooking = newBooking;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String prepare() {
        newBooking = new BookedflightEntity();
        newBooking.setSheduleFK(searchView.getSelectedSchedule());
        newBooking.setUserFK((CustomerEntity) CurrentUserBean.getCurrentUser());
        return "bookingVisitor.xhtml";
    }


    /**
     *
     * @return to the bookingFinal Page
     */
    public String pay() {
        return "bookingFinal.xhtml";
        /*if (newBooking == null)
            newBooking = new BookedflightEntity();
        newBooking.setPayMethod("Debit/Creditcard");
        if(validatepay()){
            newBooking.setPricePaid(newBooking.getSheduleFK().getTotalPrice());
            newBooking.setSeatsBooked(newBooking.getSeatsBooked());

            if (newBooking.getPayMethod().equalsIgnoreCase("Debit/Creditcard")) {
                if (randomWithRange(0, 100) < 20) {
                    newBooking.setPayStatus("FAILED");
                }else{
                    newBooking.setPayStatus("PAID");
                }
                bookedflightRepo.save(newBooking);
                return "bookingFinal.xhtml";
            }
            else {
                newBooking.setPayStatus("PENDING");
                bookedflightRepo.save(newBooking);
                return "bookingFinal.xhtml";
            }
        }
        else{
            FacesContext.getCurrentInstance().addMessage("payMethod", new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Please select a payment method"));
        }
        return "";*/
    }

    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    /**
     * Validates pay method on pay page
     */
    private boolean validatepay() {
        return (payMethod != null && !payMethod.isEmpty());
    }
}
