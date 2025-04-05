package com.astafiev.recipemanager.repository;

import com.astafiev.recipemanager.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CommentRepository extends JpaRepository<Comment, Serializable> {
}
