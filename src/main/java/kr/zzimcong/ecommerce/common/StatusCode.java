package kr.zzimcong.ecommerce.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatusCode {

    SUCCESS("1001", "success"),

    FAILED("4001", "failed"),

    /** USER */
    USER_NOT_FOUND("20010", "사용자 정보를 찾을 수 없습니다."),
    USER_NOT_MATCHED("20011", "사용자 정보가 일치하지 않습니다."),

    /** ITEM */
    ITEM_NOT_FOUND("30010", "상품 정보를 가져올 수 없습니다."),
    STOCK_ZERO_EXCEPTION("30011", "상품 재고가 부족합니다."),

    /** CART */
    CART_NOT_FOUND("50010", "장바구니를 불러오지 못하였습니다."),

    /** ORDER */
    ORDER_NOT_FOUND("60010", "주문 내역을 불러오지 못하였습니다."),
    ORDER_CANCEL_IMPOSSIBLE("60011", "주문 취소가 불가합니다.");

    private final String code;
    private final String message;
}
