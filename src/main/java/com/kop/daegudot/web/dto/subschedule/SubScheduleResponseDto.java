package com.kop.daegudot.web.dto.subschedule;

import com.kop.daegudot.domain.mainschedule.MainSchedule;
import com.kop.daegudot.domain.places.Places;
import com.kop.daegudot.domain.subschedule.SubSchedule;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class SubScheduleResponseDto {
    private LocalDate date;
    private LocalTime startDate;
    private LocalTime endDate;
    private Places places;
    private MainSchedule mainSchedule;

    public SubScheduleResponseDto(SubSchedule subSchedule) {
        this.date = subSchedule.getDate();
        this.startDate = subSchedule.getStartTime();
        this.endDate = subSchedule.getEndTime();
        this.places = subSchedule.getPlaces();
        this.mainSchedule = subSchedule.getMainSchedule();
    }
}