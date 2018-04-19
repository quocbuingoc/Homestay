package com.quocbn.dao;

import java.util.List;

import com.quocbn.model.Comment;

public interface CommentDAO {
	
	public List<Comment> listCommentByHomestayId(int id);
	public void addComment(Comment cm);
}
