package com.gundi.spring.reststarter.service;

import javax.transaction.Transactional;

import com.gundi.spring.reststarter.domain.Post;
import com.gundi.spring.reststarter.repository.AuthorRepository;
import com.gundi.spring.reststarter.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PostServiceImpl implements PostService {

	private PostRepository postRepository;
	private AuthorRepository authorRepository;
	
	@Autowired
	public PostServiceImpl(PostRepository postRepository, AuthorRepository authorRepository){
		this.postRepository = postRepository;
		this.authorRepository = authorRepository;
	}

	@Override
	public Iterable<Post> list() {
		return postRepository.findAll();
	}

	@Override
	public Post read(long id) {
		Post post = new Post();

		return postRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Post create(Post post) {
		// save the new author
		authorRepository.save(post.getAuthor());
		return postRepository.save(post);
	}

	@Override
	public void delete(long id) {

		postRepository.delete(postRepository.findById(id).get());
	}

	@Override
	public Post update(long id,Post update) {
		Post post = postRepository.findById(id).get();
		if( update.getTitle() != null ) {
			post.setTitle(update.getTitle());
		}
		return postRepository.save(post);
	}

}
