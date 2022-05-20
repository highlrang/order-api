package kr.zzimcong.ecommerce.order.dto;

import lombok.Getter;

@Getter
public class AddressDto {
    private String basicAddress;
    private String detailAddress;
    private String postCode;
}
