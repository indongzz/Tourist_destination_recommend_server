package com.kop.daegudot.web.dto.comment;

import com.kop.daegudot.domain.comment.Comment;
import com.kop.daegudot.domain.recommendschedule.RecommendSchedule;
import com.kop.daegudot.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor
public class CommentRegisterDto {
    private String dateTime;
    private String comments;
    private int star;
    private long userId;
    private long recommendScheduleId;

    public CommentRegisterDto(String dateTime, String comments, int star, long userId,
                              long recommendScheduleId){
        this.dateTime = dateTime;
        this.comments = comments;
        this.star = star;
        this.userId = userId;
        this.recommendScheduleId = recommendScheduleId;
    }

    public Comment toEntity(User user, RecommendSchedule recommendSchedule){
        return Comment.builder().comments(comments).user(user).star(star)
                .dateTime(LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME)).recommendSchedule(recommendSchedule).build();
    }
}
