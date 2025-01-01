package com.example.demo.Repository;

import com.example.demo.model.Livre;
import com.example.demo.model.LivreE;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface BookRepositoryElastic extends ElasticsearchRepository<LivreE,Integer> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"title\": \"?0\"}}]}}")
    List<LivreE> findByTitle(String title, Pageable pageable);

    @Query("{\"bool\": {\"should\": [{\"match\": {\"title\": \"?0\"}}, {\"match\": {\"description\": \"?0\"}}]}}")
    List<LivreE> findByTitleAndDesc(String mot, Pageable pageable);
}
