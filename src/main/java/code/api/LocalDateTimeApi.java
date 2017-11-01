package code.api;

import java.time.*;

public class LocalDateTimeApi {

    public static void main(String[] args) {
        localDateTime();
    }

    private static void localDateTime() {

        { // Date
            LocalDate d = LocalDate.now();  // yyyy-mm-dd
            LocalDate d1 = LocalDate.of(2015, 11, 28);
            LocalDate d2 = LocalDate.of(2015, Month.NOVEMBER, 28);

            { // Fetch detail
                System.out.println("Date: year " + d.getYear());
                System.out.println("Date: month " + d.getMonthValue());
                System.out.println("Date: day " + d.getDayOfMonth());
            }
        }

        { // Time
            LocalTime t = LocalTime.now(); // hh:mm:ss:msc
            LocalTime t1 = LocalTime.of(21, 55, 2, 553);
            LocalTime t2 = LocalTime.now(ZoneId.of("Hongkong"));

            { // Fetch detail
                System.out.println("Time: hour " + t.getHour());
                System.out.println("Time: minute " + t.getMinute());
                System.out.println("Time: second " + t.getSecond());
            }
        }

        { // DateTime
            LocalDateTime dt = LocalDateTime.now();  // yyyy-mm-ddThh:mm:ss:msc
            LocalDateTime dt1 = LocalDateTime.of(2015, 11, 18, 12, 23, 5, 12);
            LocalDateTime dt2 = LocalDateTime.now(ZoneId.of("Japan"));

            { //Fetch detail
                System.out.println("DateTime: " + dt.getYear());
                System.out.println("DateTime: " + dt.getMonth());
                System.out.println("DateTime: " + dt.getDayOfMonth());
                System.out.println("DateTime: " + dt.getHour());
                System.out.println("DateTime: " + dt.getMinute());
                System.out.println("DateTime: " + dt.getSecond());
            }
        }

        { // Time ZoneIds
//            for (String s : ZoneId.getAvailableZoneIds())
//                System.out.println(s);
        }
    }
}
