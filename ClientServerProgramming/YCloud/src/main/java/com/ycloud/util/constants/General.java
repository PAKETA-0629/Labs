package com.ycloud.util.constants;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public interface General {
    List<LocalTime> WORK_HOURS = Arrays.asList(LocalTime.parse("09:00"),
            LocalTime.parse("10:00"),LocalTime.parse("11:00"),LocalTime.parse("12:00"),
            LocalTime.parse("13:00"),LocalTime.parse("14:00"),LocalTime.parse("15:00"),
            LocalTime.parse("16:00"),LocalTime.parse("17:00"),LocalTime.parse("18:00"),
            LocalTime.parse("19:00"),LocalTime.parse("20:00"));
}
