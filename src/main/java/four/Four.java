package four;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        System.out.println(list);
        return list;
    }

    public static int getGuardWithMostTimeAsleep(List<GuardStatus> list) {

        List<MinutesAsleep> minutesAsleep = new ArrayList<>();
        int guardId = 0;

        for (int i = 0; i < list.size(); i++) {
            GuardStatus guardStatus = list.get(i);
            if (guardStatus.getId() != 0) {
                guardId = guardStatus.getId();
            } else if (guardStatus.getStatus().equals("awaken")) {
                GuardStatus previous = list.get(i-1);
                LocalTime begin = previous.getDate().toLocalTime();
                LocalTime end = guardStatus.getDate().toLocalTime();

                minutesAsleep.add(new MinutesAsleep(guardId,guardStatus.getDate().toLocalDate(), (int) begin.until(end, MINUTES)));
            }
        }

        return 10;
    }
}
