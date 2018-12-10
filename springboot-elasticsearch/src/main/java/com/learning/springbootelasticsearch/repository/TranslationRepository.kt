package com.learning.springbootelasticsearch.repository


import com.learning.springbootelasticsearch.entity.Translation
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

@Repository
interface TranslationRepository : ElasticsearchRepository<Translation, Long>