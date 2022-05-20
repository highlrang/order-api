package kr.zzimcong.ecommerce.item.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StyleTag {
    EUROPEAN("유럽풍"), DAILY("데일리"), INSTAGRAMABLE("인스타감성"),
    UNIQUE("유니크"), LOVELY("러블리"), SPORTY("스포티");

    private final String name;
}
