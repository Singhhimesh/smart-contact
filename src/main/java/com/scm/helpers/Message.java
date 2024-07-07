package com.scm.helpers;

import com.scm.enums.MesssageEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String message;

    @Builder.Default
    private MesssageEnum type = MesssageEnum.SUCCESS;
}
