package kr.zzimcong.ecommerce.item.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Gender {
    ONLY_GIRL("여아전문몰"), ONLY_BOY("남아전문몰"), MIX("공용몰");

    private final String name;

}
