package four;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.*;
import java.util.*;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Four {

    public static List<GuardStatus> readInputAndParse(String fileName) {

        List<GuardStatus> statusList = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    fileName));
            String line = reader.readLine();
            while (line != null) {
                String[] val = line.split(" ");
                LocalDateTime date = LocalDateTime.of(
                        Integer.parseInt(val[0]),
                        Integer.parseInt(val[1]),
                        Integer.parseInt(val[2]),
                        Integer.parseInt(val[3]),
                        Integer.parseInt(val[4]),
                        0);
                GuardStatus status;
                if (StringUtils.isNumeric(val[5])) {
                    status = new GuardStatus(date, Integer.parseInt(val[5]));
                } else {
                    status = new GuardStatus(date, val[5]);
                }

                statusList.add(status);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return statusList;
    }

    public static List<GuardStatus> sortInputByDate(List<GuardStatus> list) {

        Collections.sort(list);
        return list;
    }

    public static int getGuardWithMostTimeAsleep(List<GuardStatus> list) {

        Map<String, Integer> minutesAsleepMap = new HashMap<>();
        int guardId = 0;

        for (int i = 0; i < list.size(); i++) {
            GuardStatus guardStatus = list.get(i);
            if (guardStatus.getId() != 0) {
                guardId = guardStatus.getId();
            } else if (guardStatus.getStatus().equals("awaken")) {
                GuardStatus previous = list.get(i-1);
                LocalTime beginTime = previous.getDate().toLocalTime();
                LocalTime endTime = guardStatus.getDate().toLocalTime();
                LocalDate localDate = guardStatus.getDate().toLocalDate();
                int until = (int) beginTime.until(endTime, MINUTES);

                if (minutesAsleepMap.get(guardId + ":" + localDate) != null) {
                    Integer mins = minutesAsleepMap.get(guardId + ":" + localDate);
                    minutesAsleepMap.put(guardId + ":" + localDate, mins + until);
                } else {
                    minutesAsleepMap.put(guardId + ":" + localDate, until);
                }
            }
        }

        int maxMins = 0;
        for (Integer value : minutesAsleepMap.values()) {
            if (value > maxMins)
                maxMins = value;
        }

        String key = getKey(minutesAsleepMap, maxMins);
        return Integer.parseInt(key.split(":")[0]);
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
