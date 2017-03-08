package com.ep.gojekleveluno.util;

import java.util.List;

/**
 *
 * @author Bayu Hendra Setiawan
 */
public class StringUtil {

    public static String implode(List<String> strings) {
        String listString = "";

        for (String string : strings) {
            listString += string;
            if (!strings.get(strings.size() - 1).equalsIgnoreCase(string)) {
                listString += ", ";
            }
        }
        return listString;
    }
}
