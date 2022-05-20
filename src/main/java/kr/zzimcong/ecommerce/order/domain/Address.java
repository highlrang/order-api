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

    @Builder
    public Address(String basicAddress, String detailAddress, String postCode){
        this.basicAddress = basicAddress;
        this.detailAddress = detailAddress;
        this.postCode = postCode;
    }
}
