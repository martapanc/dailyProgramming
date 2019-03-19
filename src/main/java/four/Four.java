package four;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Four {

    public static void readInputAndSort() {

        List<GuardStatus> statusList = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/main/java/four/out2"));
            String line = reader.readLine();
            while (line != null) {
                String[] val = line.split(" ");
//                for (int i = 0; i < val.length -1; i++) {
//                    val[i] = Integer.parseInt(val[i]);
//                }
                LocalDateTime date = LocalDateTime.of(
                        Integer.parseInt(val[0]),
                        Integer.parseInt(val[1]),
                        Integer.parseInt(val[2]),
                        Integer.parseInt(val[3]),
                        Integer.parseInt(val[4]),
                        0);
//                if (StringUtils.isNumeric(val[5])) {
                GuardStatus status = new GuardStatus(date, val[5]);
//                }
                statusList.add(status);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(statusList);
    }
}
