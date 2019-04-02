package four;

import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MINUTES;

public class Four {

    public static List<GuardStatus> readInputAndParse(String fileName) {

        List<GuardStatus> statusList = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
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
                GuardStatus previous = list.get(i - 1);
                LocalTime beginTime = previous.getDate().toLocalTime();
                LocalTime endTime = guardStatus.getDate().toLocalTime();
                LocalDate localDate = guardStatus.getDate().toLocalDate();
                int minuteDiff = (int) beginTime.until(endTime, MINUTES);

                if (minutesAsleepMap.get(guardId + ":" + localDate) != null) {
                    Integer mins = minutesAsleepMap.get(guardId + ":" + localDate);
                    minutesAsleepMap.put(guardId + ":" + localDate, mins + minuteDiff);
                } else {
                    minutesAsleepMap.put(guardId + ":" + localDate, minuteDiff);
                }
            }
        }

        Map<String, Integer> minutesSumPerGuard = new HashMap<>();

        for (Map.Entry<String, Integer> entry : minutesAsleepMap.entrySet()) {
            String id = entry.getKey().split(":")[0];
            String value = String.valueOf(entry.getValue());
            if (minutesSumPerGuard.containsKey(id)) {
                int prevSum = minutesSumPerGuard.get(id);
                minutesSumPerGuard.put(id, prevSum + Integer.parseInt(value));
            } else {
                minutesSumPerGuard.put(id, Integer.parseInt(value));
            }
        }

        int maxMins = 0;
        for (Integer value : minutesSumPerGuard.values())
            if (value > maxMins)
                maxMins = value;

        String key = getKeyFromValue(minutesSumPerGuard, maxMins);

        if (key != null)
            return Integer.parseInt(key);
        return 0;
    }

    private static <K, V> K getKeyFromValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet())
            if (entry.getValue().equals(value))
                return entry.getKey();
        return null;
    }

    public static int[] drawSleepPattern(int id, List<GuardStatus> list) {

        int[] minutes = new int[60];

        for (int i = 0; i < list.size(); i++) {

            GuardStatus guardStatus = list.get(i);

            if (guardStatus.getId() == id) {
                 int j = i+1;
                 while (j < list.size() && list.get(j).getId() == 0) {
                     int asleepTime = list.get(j).getDate().toLocalTime().getMinute();
                     int awakeTime = list.get(j+1).getDate().toLocalTime().getMinute();

                     for (int k = asleepTime; k < awakeTime; k++)
                         minutes[k] += 1;
                     j += 2;
                 }
            }
        }

        return minutes;
    }

    public static void buildSleepCountMatrix(List<GuardStatus> list) {

        List<Integer> idList = new ArrayList<>();

        for (GuardStatus status : list) {
            int id = status.getId();
            if (id != 0 && !idList.contains(id))
                idList.add(id);
        }

        int[][] sleepMatrix = new int[61][idList.size()];
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < idList.size(); j++) {
                int[] minutes = drawSleepPattern(idList.get(j), list);
                sleepMatrix[i][j] += minutes[i];
                sleepMatrix[60][j] = Integer.parseInt(String.valueOf(idList.get(j)));
            }
        }
    }
}
