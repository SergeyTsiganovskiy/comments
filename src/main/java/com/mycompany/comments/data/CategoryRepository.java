package com.mycompany.comments.data;

import java.util.Arrays;
import java.util.List;

public class CategoryRepository {

    public static List<String> getAvailbaleCategories() {
       return Arrays.asList("Cat0", "Cat1", "Cat2", "Cat3", "Cat4", "Cat5");
    }
}
