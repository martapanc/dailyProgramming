package AoC2019.eight;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Eight {

    public static List<String> readInput(String input, int width, int height) {
        List<String> list = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(input));
            String line = reader.readLine();
            while (line != null) {
                for (String s : Splitter.fixedLength(width * height).split(line)) {
                    list.add(s);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    static int getBestLayer(List<String> layers) {
        int zeroMinCount = 999;
        int checksumOfBestLayer = -1;
        for (String s : layers) {
            int zeroCount = StringUtils.countMatches(s, '0');
            if (zeroCount < zeroMinCount) {
                zeroMinCount = zeroCount;
                checksumOfBestLayer = StringUtils.countMatches(s, '1') * StringUtils.countMatches(s, '2');
            }
        }
        return checksumOfBestLayer;
    }
}
