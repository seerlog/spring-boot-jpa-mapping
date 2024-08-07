package com.example.springbootjpamapping.response.member;

import com.example.springbootjpamapping.domain.member.Member;
import com.example.springbootjpamapping.response.order.OrderResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberResponse {
    private String id;
    private String name;

    public static MemberResponse of(Member member) {
        MemberResponse response = new MemberResponse();
        response.setId(member.getId());
        response.setName(member.getName());
        return response;
    }
}
