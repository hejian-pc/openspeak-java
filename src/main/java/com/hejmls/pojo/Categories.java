package com.hejmls.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
}
