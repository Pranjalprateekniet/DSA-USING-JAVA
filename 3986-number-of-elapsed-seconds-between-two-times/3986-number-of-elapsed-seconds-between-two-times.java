import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime start=LocalTime.parse(startTime,formatter);
        int sh=start.getHour();
        int sm=start.getMinute();
        int ss=start.getSecond();
        LocalTime end = LocalTime.parse(endTime, formatter);

        int eh=end.getHour();
        int em=end.getMinute();
        int es=end.getSecond();
        return 3600*(eh-sh)+60*(em-sm)+(es-ss);

    }
}