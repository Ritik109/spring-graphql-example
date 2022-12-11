package com.example.graphql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    private Long categoryId;

    private String categoryName;

    private String categoryDescription;
}
