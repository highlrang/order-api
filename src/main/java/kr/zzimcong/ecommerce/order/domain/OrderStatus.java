package kr.zzimcong.ecommerce.order.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    INPROGRESS("진행"), COMPLETE("완료"), CANCEL("취소");

    private final String name;
}
