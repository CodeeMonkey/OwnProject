package com.realdolmen.view;

import com.realdolmen.beans.AirportBean;
import com.realdolmen.domain.AirportEntity;
import com.realdolmen.domain.DiscountEntity;
import com.realdolmen.domain.ScheduleEntity;
import com.realdolmen.repositories.DiscountRepository;
import com.realdolmen.repositories.ScheduleRepository;
import com.realdolmen.utils.RegEx;
import org.primefaces.event.SelectEvent;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SessionScoped
@Named
public class SearchView implements Serializable {

    private boolean retour = false;
    private String classChoice;
    private int passengers = 1;
    private Date destinationDate = new Date();
    private Date departureDate = new Date();
    private AirportEntity departureAirport;
    private AirportEntity destinationAirport;
    private ScheduleEntity selectedSchedule;
    private List<ScheduleEntity> schedules = new ArrayList<>();
    private List<ScheduleEntity> filteredSchedules = new ArrayList<>();

    //Filters
    private Set<String> airlines = new HashSet<>();
    private String[] selectedAirlines;

    private Set<String> seatClasses = new HashSet<>();
    private String[] selectedSeatClasses;

    @Inject
    private AirportBean airportBean;

    @Inject
    private ScheduleRepository scheduleRepository;

    @Inject
    private DiscountRepository discountRepository;

    /**
     * Getters and setters
     */
    public boolean isRetour() {
        return retour;
    }

    public void setRetour(boolean retour) {
        this.retour = retour;
    }

    public String getClassChoice() {
        return classChoice;
    }

    public void setClassChoice(String classChoice) {
        this.classChoice = classChoice;
    }

    public int getPassengers() {
        return passengers;
    }

    public List<ScheduleEntity> getSchedules() {
        if (schedules.isEmpty())
            return null;
        return schedules;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getDestinationDate() {
        return destinationDate;
    }

    public void setDestinationDate(Date destinationDate) {
        this.destinationDate = destinationDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setShedules(List<ScheduleEntity> shedules) {
        this.schedules = shedules;
    }

    public AirportEntity getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportEntity departureAirport) {
        this.departureAirport = departureAirport;
    }

    public AirportEntity getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(AirportEntity destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public AirportBean getAirportBean() {
        return airportBean;
    }

    public void setAirportBean(AirportBean airportBean) {
        this.airportBean = airportBean;
    }

    public void setSchedules(List<ScheduleEntity> schedules) {
        this.schedules = schedules;
    }

    public List<ScheduleEntity> getFilteredSchedules() {
        return filteredSchedules;
    }

    public void setFilteredSchedules(List<ScheduleEntity> filteredSchedules) {
        this.filteredSchedules = filteredSchedules;
    }

    public Set<String> getAirlines() {
        return airlines;
    }

    public void setAirlines(Set<String> airlines) {
        this.airlines = airlines;
    }

    public String[] getSelectedAirlines() {
        return selectedAirlines;
    }

    public void setSelectedAirlines(String[] selectedAirlines) {
        this.selectedAirlines = selectedAirlines;
    }

    public Set<String> getSeatClasses() {
        return seatClasses;
    }

    public void setSeatClasses(Set<String> seatClasses) {
        this.seatClasses = seatClasses;
    }

    public String[] getSelectedSeatClasses() {
        return selectedSeatClasses;
    }

    public void setSelectedSeatClasses(String[] selectedSeatClasses) {
        this.selectedSeatClasses = selectedSeatClasses;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Method is called on autocomplete of Airports
     */
    public ScheduleEntity getSelectedSchedule() {
        return selectedSchedule;
    }

    //autocomplete
    public List<AirportEntity> completeAirport(String query) {
        if (query.trim().length() > 1) {
            return airportBean.getAirports(query);
        }
        return null;
    }

    //TODO Give Date with the corresponding timezone to get the local time back
    public String calculateHoursInLocaleTimezone() {
        return "";
    }

    //Calendar
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }

    public String getCurrentDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }


    /**
     * Makes a search to the table Schedules to gather available flights of a user
     * Makes use of all available discounts and changes the new total price
     * Sorts all new filtered Schedules on Price, discount and remaining seats
     *
     * @return to the resultsVisitor Page
     */
    public String search() {
        if (departureAirport != null && destinationAirport != null) {
            if (validateSearch()) {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String startDate = dateFormat.format(departureDate);

                List<ScheduleEntity> availableSchedules = scheduleRepository.findAvailableSchedules(startDate, departureAirport.getAirportName(), destinationAirport.getAirportName(), passengers, classChoice);
                System.out.println("searchview results: " + availableSchedules.size());
                List<DiscountEntity> allDiscounts = discountRepository.findAllDiscounts();

                for (ScheduleEntity ent : availableSchedules) {
                    List<DiscountEntity> filteredDiscounts = new ArrayList<>();
                    for (DiscountEntity discount : allDiscounts) {
                        if (this.passengers >= discount.getMinNumOfSeatsReserved()
                                && (discount.getSheduleFK() == null || discount.getSheduleFK().getId() == ent.getId())) {
                            filteredDiscounts.add(discount);
                        }
                    }
                    ent.setDiscountList(filteredDiscounts);
                    ent.setTotalPrice(alterPriceToClass(ent.getDefaultPrice(), classChoice));
                    ent.setDiscountHighest(this.calculatePriceWithDiscounts(filteredDiscounts));
                    ent.setTotalPrice(round(ent.getTotalPrice() - ((ent.getTotalPrice() / 100) * ent.getDiscountHighest()),2 ));
                }

                Collections.sort(availableSchedules);
                this.setShedules(availableSchedules);
                generateAirportFilter(availableSchedules);
                filterResults();
                return "resultsVisitor.xhtml";
            }
        }
        return "";
    }

    public String gotoDetailView(Long id) {
        this.selectedSchedule = filteredSchedules.stream()
                .filter(schedule -> id.equals(schedule.getId()))
                .findAny()
                .orElse(null);

        return "detailVisitor.xhtml";
    }

    public Double calculateOldPrice(ScheduleEntity scheduleEntity)
    {
        return round(scheduleEntity.getTotalPrice() / (1 - ((float)scheduleEntity.getDiscountHighest()/100)),2 );
    }


    /**
     * Loops trough the Schedules and generate the filters based on all Shedules
     *
     * @param availableSchedules requires a list of available schedules
     */
    private void generateAirportFilter(List<ScheduleEntity> availableSchedules) {

        //Puts all airlines and Class Seats from the Scheduled query in a list
        availableSchedules.stream().forEach(schedule -> {
            airlines.add(schedule.getAircraftFK().getAirlineFK().getName());
            if (schedule.getAircraftFK().getEconomyClassSeats() >= this.passengers) {
                seatClasses.add("Economy");
            }
            if (schedule.getAircraftFK().getBusinessSeats() >= this.passengers) {
                seatClasses.add("Business");
            }
            if (schedule.getAircraftFK().getFirstClassSeats() >= this.passengers){
                seatClasses.add("First class");
            }
        });

        //Preselect checkbox values
        selectedAirlines = airlines.toArray(new String[0]);
        selectedSeatClasses = new String[]{classChoice};
    }

    /**
     * Method is called to filter on selected values like Airline and Class
     * Updates values with Ajax call
     */
    public void filterResults() {
        filteredSchedules = schedules.stream()
                .filter(schedule -> Arrays.stream(selectedAirlines).anyMatch(isSameAirline(schedule)))
                .filter(schedule -> Arrays.stream(selectedSeatClasses).anyMatch(isSameClassSeat(schedule)))
                .collect(Collectors.toList());
        filteredSchedules.stream().forEach(schedule ->  {
            schedule.setTotalPrice(round(schedule.getTotalPrice() - ((schedule.getTotalPrice() / 100) * schedule.getDiscountHighest()), 2));
        });
        Collections.sort(filteredSchedules);
    }

    private Predicate<? super String> isSameAirline(ScheduleEntity schedule) {
        return airline -> airline.equalsIgnoreCase(schedule.getAircraftFK().getAirlineFK().getName());
    }

    private Predicate<? super String> isSameClassSeat(ScheduleEntity schedule) {
        return classSeat -> {
            switch (classSeat) {
                case "Economy":
                    schedule.setTotalPrice(alterPriceToClass(schedule.getDefaultPrice(), "Economy"));
                    setClassChoice("Economy");
                    return schedule.getRemainingSeatsEconomy() >= passengers;
                case "Business":
                    schedule.setTotalPrice(alterPriceToClass(schedule.getDefaultPrice(), "Business"));
                    setClassChoice("Business");
                    return schedule.getRemainingSeatsBusiness() >= passengers;
                case "First class":
                    schedule.setTotalPrice(alterPriceToClass(schedule.getDefaultPrice(), "First class"));
                    setClassChoice("First class");
                    return schedule.getRemainingSeatsFirst() >= passengers;
                default:
                    return false;
            }
        };
    }


    /**
     * Alter the price related to a class
     * @param price default price
     * @param classSeats the class of seats
     * @return a new price
     */
    private Double alterPriceToClass(Double price, String classSeats){
        switch (classSeats) {
            case "First class":
                if (price < 85)
                    return price * 22;
                else return price * 15;
            case "Business":
                if (price > 85)
                    return price * 2.5;
                return price * 4;
            case "Economy":
                return price;
            default:
                return price;
        }
    }

    /**
     * Loops all discounts to get the highest discount linked to a Schedule
     */
    private int calculatePriceWithDiscounts(List<DiscountEntity> filteredDiscounts) {
        int highestPercentage = 0;

        for (DiscountEntity discount : filteredDiscounts) {
            if (discount.getDiscountPercentage() > highestPercentage) {
                highestPercentage = discount.getDiscountPercentage();
            }
        }
        return highestPercentage;
    }

    /**
     * Validates a search on index page
     */
    private boolean validateSearch() {
        return RegEx.isNumberOfPersonsValid(getPassengers()) && RegEx.notEmpty(getDepartureDate().toString()) && RegEx.notEmpty(getDestinationAirport().toString()) && RegEx.notEmpty(getDepartureAirport().toString());
    }
}
