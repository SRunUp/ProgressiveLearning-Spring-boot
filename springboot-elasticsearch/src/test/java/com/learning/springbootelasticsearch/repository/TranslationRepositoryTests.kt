package com.learning.springbootelasticsearch.repository

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class TranslationRepositoryTests{

    @Autowired
    private lateinit var translationRepository: TranslationRepository

    @Test
    fun testFindAll(){

        var result = translationRepository.findAll()

        for (item in result){
            println(item.chinese)
        }

    }
}