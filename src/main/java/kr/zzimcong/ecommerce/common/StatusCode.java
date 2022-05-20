package kr.zzimcong.ecommerce.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatusCode {

    SUCCESS("1001", "success"),

    FAILED("4001", "failed"),

    /** ITEM */
    ITEM_NOT_FOUND("20010", "상품 정보를 가져올 수 없습니다."),
    STOCK_ZERO_EXCEPTION("20011", "상품 재고가 부족합니다.");

    private final String code;
    private final String message;
}
