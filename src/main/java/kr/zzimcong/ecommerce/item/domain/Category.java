package kr.zzimcong.ecommerce.item.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private List<Category> childCategoryList = new ArrayList<>();

    private String name;

    public Category(String name){
        this.name = name;
    }

    public void addChildCategory(Category category){
        this.childCategoryList.add(category);
        category.setParentCategory(this);
    }
}
