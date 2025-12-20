package com.RDT_PastillasSercio.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class DbUtil {

        private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static int getInt(Map<String, Object> data, String key){
        if(data.get(key) == null)
            return 0;
        return (int)data.get(key);
    }

    public static Integer getInteger(Map<String, Object> data, String key){
        if(data.get(key) == null)
            return null;
        else
            return (int)data.get(key);
    }

    public static Long getLong(Map<String, Object> data, String key){
        if(data.get(key) == null)
            return null;
        else
            return (Long)data.get(key);
    }

    public static String getString(Map<String, Object> data, String key){
        return (String)data.get(key);
    }

    public static boolean getBoolean(Map<String, Object> data, String key){
        if(data.get(key) == null)
            return false;
        return (boolean)data.get(key);
    }

    public static String getfecha_hora(Map<String, Object> row, String column) {
        Object value = row.get(column);

        if (value == null) {
            return null;
        }

        // MySQL → LocalDateTime
        if (value instanceof LocalDateTime) {
            return ((LocalDateTime) value).format(FORMATTER);
        }

        // Fallback seguro
        return String.valueOf(value);
    }

}