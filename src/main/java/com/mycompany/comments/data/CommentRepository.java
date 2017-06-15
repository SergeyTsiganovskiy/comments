package com.mycompany.comments.data;


import com.mycompany.comments.models.Comment;

import java.util.Arrays;

public class CommentRepository {

    public static Comment getValidActiveComment() {
        return new Comment("1"
                , "Valid comment text active"
                , true
                , Arrays.asList("Cat0", "Cat2", "Cat4"));
    }

    public static Comment getValidInactiveComment() {
        return new Comment("2"
                , "Valid comment text inactive"
                , false
                , Arrays.asList("Cat1", "Cat3", "Cat5"));
    }

    public static Comment getEmptyTextComment() {
        return new Comment("3"
                , ""
                , true
                , Arrays.asList("Cat1"));
    }

    public static Comment getInvalidSymbolsTextComment() {
        return new Comment("123"
                , "$#^@_"
                , true
                , Arrays.asList("Cat1"));
    }

    public static Comment getBoundaryLengthComment() {
        return new Comment("4"
                , "123456789_123456789_123456789_123456789_1234567890"
                , false
                , Arrays.asList("Cat2", "Cat3"));
    }

    public static Comment getOverBoundaryLengthComment() {
        return new Comment("5"
                , "123456789_123456789_123456789_123456789_123456789_1"
                , true
                , Arrays.asList("Cat4", "Cat5"));
    }

    public static Comment getEmptyNumberComment() {
        return new Comment(""
                , "Valid comment text"
                , false
                , Arrays.asList("Cat0", "Cat5", "Cat2", "Cat3"));
    }

    public static Comment getInvalidSymbolsNumberComment() {
        return new Comment("ff"
                , "Valid comment text"
                , true
                , Arrays.asList("Cat1", "Cat5", "Cat2"));
    }

    public static Comment getWithoutCategoriesComment() {
        return new Comment("123"
                , "Valid comment text"
                , false
                , Arrays.asList(new String[]{}));
    }

    public static Comment getNumberWithZeroInTheEndComment() {
        return new Comment("70"
                , "Valid comment text"
                , true
                , Arrays.asList("Cat0", "Cat1", "Cat2", "Cat3", "Cat4", "Cat5"));
    }

    public static Comment getBoundaryNumberComment() {
        return new Comment("999"
                , "Valid comment text"
                , false
                , Arrays.asList("Cat0", "Cat1", "Cat3", "Cat4", "Cat5"));
    }

    public static Comment getOverBoundaryNumberComment() {
        return new Comment("1001"
                , "Valid comment text"
                , true
                , Arrays.asList("Cat0", "Cat3", "Cat4"));
    }

    public static Comment getNewValidComment() {
        return new Comment("223",
                "NewComment Test",
                true,
                Arrays.asList("Cat0", "Cat1", "Cat2"));
    }
}
