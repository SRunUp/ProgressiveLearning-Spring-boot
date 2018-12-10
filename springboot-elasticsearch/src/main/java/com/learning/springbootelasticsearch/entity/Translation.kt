package com.learning.springbootelasticsearch.entity

import org.springframework.data.elasticsearch.annotations.Document
import java.io.Serializable

@Document(indexName = "translation",type = "trans")
class Translation : Serializable {
    var id: Long? = null
    var chinese: String? = null
    var english: String? = null
}