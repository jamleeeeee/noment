package com.noment.admin.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private LocalDateTime modifiedDate;
    @Builder
    public PostsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content; 
        this.modifiedDate = LocalDateTime.now();
    }
}
