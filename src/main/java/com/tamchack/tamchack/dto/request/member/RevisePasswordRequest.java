package com.tamchack.tamchack.dto.request.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RevisePasswordRequest {

    private String id;

    private String password;

}
