package com.sixkery.basis.es.controller;

import com.sixkery.response.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sixkery
 * @since 2023/9/4
 */
@Slf4j
@RestController
@RequestMapping("/es")
public class EsController {

    @GetMapping
    public ApiResponses<Object> brandRank() {


        return ApiResponses.ok();
    }

    public static void main(String[] args) {

//        final Map<String, String> map = lastNextWeek("2023-07-03");
//        System.out.println("map = " + map);

        final long percent = getPercent(0, 100);
        System.out.println("percent = " + percent);
    }

    private static long getPercent(long count, long total) {

        BigDecimal currentCount = new BigDecimal(count);
        BigDecimal totalCount = new BigDecimal(total);
        BigDecimal divide = currentCount.divide(totalCount, 2, RoundingMode.HALF_UP);
        return divide.multiply(new BigDecimal(100)).longValue();
    }

    public static Map<String, String> lastNextWeek(String dateStr) {

        String DATA_FORMAT = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATA_FORMAT);
        LocalDate date = LocalDate.parse(dateStr, formatter);

        LocalDate lastMonday = date.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY)).minusWeeks(1);
        LocalDate sunday = date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        LocalDate monday = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("lastMonday", lastMonday.format(formatter));
        resultMap.put("monday", monday.format(formatter));
        resultMap.put("nextMonday", sunday.format(formatter));

        return resultMap;
    }
}
