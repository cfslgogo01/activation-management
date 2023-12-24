package cn.edu.cs.database.activatemanage.Utils;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
public class MyDateTime {
    public String getDateTime() {
        // 获取当前时间
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        // 格式化当前时间
        String formattedDateTime = currentDateTime.format(formatter);
        return formattedDateTime;
    }

    public String getDateTime(long Time) {
        // 假设你有一个时间戳（以毫秒为单位）
//        long timestampInMillis = System.currentTimeMillis();

        // 使用Instant从时间戳创建时间点
        Instant instant = Instant.ofEpochMilli(Time);

        // 将Instant转换为LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // 定义日期时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");

        // 格式化LocalDateTime为字符串
        String formattedDateTime = localDateTime.format(formatter);
        return formattedDateTime;

    }

    public long getDateTime_num() {
        return System.currentTimeMillis()/1000;
    }
}
