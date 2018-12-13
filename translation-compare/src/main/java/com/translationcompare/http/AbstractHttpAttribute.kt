package com.translate.compare.translatecompare.http

import com.translate.compare.translatecompare.enums.LanguageEnum
import org.apache.http.HttpEntity
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import java.io.IOException


abstract class AbstractHttpAttribute {
    var formData = HashMap<String, String>()
    var langMap = HashMap<LanguageEnum, String>()
    var httpClient: CloseableHttpClient? = HttpClients.createDefault()

    abstract fun query(): String

    abstract fun run(from: LanguageEnum, to: LanguageEnum, text: String): String

    fun close(httpEntity: HttpEntity, httpResponse: CloseableHttpResponse?) {
        try {
            EntityUtils.consume(httpEntity)
            httpResponse?.close()
            httpClient?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    fun close() {
        try {
            httpClient?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}