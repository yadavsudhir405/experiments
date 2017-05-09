package github.com.yadavsudhir405.experiments.coreJavaPractise.generals;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author sudhir
 *         Date:3/5/17
 *         Time:11:14 PM
 *         Project:core-java-practise
 */
public class DateTest {
    public static void main(String[] args) {
        //testLocaleDate();
        //testLocaleTime();
        testLocaleDateTime();
    }

    private static void testLocaleDateTime() {
        Clock utcclock=Clock.systemUTC();
        System.out.println(utcclock.getZone());
        System.out.println(utcclock.instant());
    }

    private static void testLocaleTime(){
        LocalTime now=LocalTime.now();
        System.out.println("Now "+now);
        LocalTime afterHalfAnHour=now.plusHours(1).plusMinutes(30);
        System.out.println("After half an hour "+afterHalfAnHour);

        LocalTime sixAmMorning=LocalTime.of(6,0,0);
        System.out.println("Six Am Morning Time "+sixAmMorning);
        LocalTime sixPmEvening=LocalTime.of(18,0,0);
        System.out.println("Six Pm Evening "+sixPmEvening);
        String time="06:00AM";
        DateTimeFormatter timeFormatter=DateTimeFormatter.ofPattern("h:mma");
        LocalTime sixAm=LocalTime.parse(time,timeFormatter);
        System.out.println(sixAm);


    }
    private static void testLocaleDate() {
        LocalDate today=LocalDate.now();
        System.out.println("Todays Date "+today);
        LocalDate yesterdayDate=today.minusDays(1);
        System.out.println("YesterdayDate "+yesterdayDate);
        LocalDate tomorrow=today.plusDays(1);
        System.out.println("Tomorrow "+tomorrow);
        LocalDate afterFifteenDaysDate=today.plusDays(15);
        System.out.println("Fifteen Days After "+afterFifteenDaysDate);

        LocalDate fifteenAugust2014=LocalDate.of(2014, Month.AUGUST,15);
        System.out.println("Fifteen August 2014 "+fifteenAugust2014);
        String fifteenAugust2015String="15/07/2015";
        LocalDate fifteenAugust2015=LocalDate.parse(fifteenAugust2015String, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("FifteenAugust2015 "+fifteenAugust2015);
        System.out.println();
        //Creating date in the form of 15-Nov-2017
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String fifteenNovemeber2017String="15-Nov-2017";
        LocalDate fifteenNovemeber2017=LocalDate.parse(fifteenNovemeber2017String,dateTimeFormatter);
        System.out.println(fifteenNovemeber2017);
        System.out.println(dateTimeFormatter.toFormat().format(fifteenNovemeber2017));

        //Date pattern May 6,2017
        dateTimeFormatter=DateTimeFormatter.ofPattern("MMM d,yyyy");
        LocalDate may62017=LocalDate.parse("May 6,2017",dateTimeFormatter);
        System.out.println(may62017);
        System.out.println(dateTimeFormatter.toFormat().format(may62017));
    }
}
