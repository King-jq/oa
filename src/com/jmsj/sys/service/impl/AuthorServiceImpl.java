package com.jmsj.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jmsj.sys.dao.IAuthorDao;
import com.jmsj.sys.entity.Author;
import com.jmsj.sys.service.IAuthorService;

@Service("authorService")
public class AuthorServiceImpl implements IAuthorService {
	
	@Resource(name="authorDao")
	private IAuthorDao authorDao;

	@Override
	public boolean add(Author author) {
		return authorDao.add(author);
	}

	@Override
	public boolean delete(String authId) {
		return authorDao.delete(authId);
	}

	@Override
	public boolean update(Author author) {
		return authorDao.update(author);
	}

	@Override
	public Author getAuthor(String id) {
		return authorDao.getAuthor(id);
	}

}
