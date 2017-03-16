package github.com.yadavsudhir405.springwebsecurity.services;

import github.com.yadavsudhir405.springwebsecurity.domain.Reservation;

import java.util.List;

/**
 * @author sudhir
 *         Date:15/3/17
 *         Time:11:42 AM
 *         Project:spring-web-security
 */
public interface ReservationService {
    Reservation save(Reservation reservation);
    Reservation getReservationByid(Long id);
    List<Reservation> byBookedPerson(String name);
}
