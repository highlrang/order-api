package kr.zzimcong.ecommerce.item.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Getter
@NoArgsConstructor
public class Brand {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer startAge;

    private Integer endAge;

    private Gender gender;

    private StyleTag styleTag;

    @Builder
    public Brand(String name, Integer startAge, Integer endAge, Gender gender, StyleTag styleTag){
        this.name = name;
        this.startAge = startAge;
        this.endAge = endAge;
        this.gender = gender;
        this.styleTag = styleTag;
    }
}
