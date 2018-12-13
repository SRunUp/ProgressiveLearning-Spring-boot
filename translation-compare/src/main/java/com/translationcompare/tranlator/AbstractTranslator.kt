package com.translate.compare.translatecompare.tranlator

import com.translate.compare.translatecompare.enums.LanguageEnum
import com.translate.compare.translatecompare.http.AbstractHttpAttribute
import com.translate.compare.translatecompare.http.IHttpParams


abstract class AbstractTranslator : AbstractHttpAttribute(), IHttpParams {

    init {
        setLangSupport()
    }

    override fun run(from: LanguageEnum, to: LanguageEnum, text: String): String {
        var result = ""
        setFormData(from, to, text)
        try {
            result = parses(query())
        } catch (e: Exception) {
            e.printStackTrace()
        }

        close()
        return result
    }


    abstract fun setLangSupport()

    abstract override fun setFormData(from: LanguageEnum, to: LanguageEnum, text: String)

    abstract override fun query(): String

    abstract fun parses(text: String): String
}