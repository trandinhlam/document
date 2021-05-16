package com.research.database.socialnetwork.storage.es.entity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ESUserRepository extends ElasticsearchRepository<ESUser, Integer> {
    List<ESUser> findByNameContaining(String nameInput, Pageable paging);
}
