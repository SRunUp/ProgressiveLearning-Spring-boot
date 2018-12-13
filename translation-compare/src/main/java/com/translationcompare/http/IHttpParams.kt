package com.translate.compare.translatecompare.http

import com.translate.compare.translatecompare.enums.LanguageEnum

interface IHttpParams {
    fun setFormData(from: LanguageEnum, to: LanguageEnum, text: String)
}