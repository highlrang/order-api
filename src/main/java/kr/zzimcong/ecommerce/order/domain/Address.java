package kr.zzimcong.ecommerce.order.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@Getter
public class Address {
    private String basicAddress;
    private String detailAddress;
    private String postCode;
    private DeliveryStatus status;

    @Builder
    private Address(String basicAddress, String detailAddress, String postCode){
        this.basicAddress = basicAddress;
        this.detailAddress = detailAddress;
        this.postCode = postCode;
    }

    public static Address create(String basicAddress, String detailAddress, String postCode){
        Address address = Address.builder()
                .basicAddress(basicAddress)
                .detailAddress(detailAddress)
                .postCode(postCode)
                .build();
        address.status = DeliveryStatus.READY;
        return address;
    }
}
