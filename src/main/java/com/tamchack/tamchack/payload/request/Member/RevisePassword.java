package com.tamchack.tamchack.payload.request.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RevisePassword {

    private String id;

    private String password;
}
