package json;

import com.google.gson.*;
import com.google.gson.reflect.*;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class jsonTest {

    private static final String FILE_NAME = "src/main/java/json/input.json";

    public static void main(String[] args) throws FileNotFoundException {

        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
        Type collectionType = new TypeToken<Collection<Agent>>(){}.getType();

        Collection<Agent> agents = gson.fromJson(bufferedReader, collectionType);

        for (Agent agent : agents) {
            System.out.println(agent);
        }

        System.out.println(Arrays.toString(new String[]{}));

    }
}
