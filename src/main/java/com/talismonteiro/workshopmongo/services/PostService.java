package com.talismonteiro.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talismonteiro.workshopmongo.domain.Post;
import com.talismonteiro.workshopmongo.domain.User;
import com.talismonteiro.workshopmongo.repository.PostRepository;
import com.talismonteiro.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTittle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
