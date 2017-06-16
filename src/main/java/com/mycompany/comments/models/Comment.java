package com.mycompany.comments.models;

import com.mycompany.comments.data.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

public class Comment {
    private String number;
    private String commentText;
    private boolean isActive;
    private List<String> categories;

    public Comment(String number, String commentText, boolean isActive, List<String> categories) {
        this.number = number;
        this.commentText = commentText;
        this.isActive = isActive;
        this.categories = categories;
    }

    public String getNumber() {
        return number;
    }

    public String getCommentText() {
        return commentText;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<String> getCategories() {
        return categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;

        Comment comment = (Comment) o;

        if (isActive != comment.isActive) return false;
        if (!number.equals(comment.number)) return false;
        if (!commentText.equals(comment.commentText)) return false;
        return categories.equals(comment.categories);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + commentText.hashCode();
        result = 31 * result + (isActive ? 1 : 0);
        result = 31 * result + categories.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "number='" + number + '\'' +
                ", commentText='" + commentText + '\'' +
                ", isActive=" + isActive +
                ", categories=" + categories +
                '}';
    }
}
