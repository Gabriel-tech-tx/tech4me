package br.com.tech4me.tech4me.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.tech4me.model.Musica;

public interface MusicaRepository extends MongoRepository<Musica, String>{
    
}
