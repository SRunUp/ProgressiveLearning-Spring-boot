package com.translate.compare.translatecompare.tranlator.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.translate.compare.translatecompare.enums.LanguageEnum
import com.translate.compare.translatecompare.tranlator.AbstractTranslator
import com.translate.compare.translatecompare.tranlator.TranslatorConsts
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.utils.URIBuilder
import org.apache.http.util.EntityUtils
import java.io.FileReader
import javax.script.Invocable
import javax.script.ScriptEngineManager


class GoogleTranslator : AbstractTranslator() {

    override fun setLangSupport() {
        langMap[LanguageEnum.ZH] = "zh-CN"
        langMap[LanguageEnum.EN] = "en"

    }

    override fun setFormData(from: LanguageEnum, to: LanguageEnum, text: String) {
        formData["client"] = "t"
        formData["sl"] = langMap[from].toString()
        formData["tl"] = langMap[to].toString()
        formData["hl"] = "zh-CN"
        formData["dt"] = "at"
        formData["dt"] = "bd"
        formData["dt"] = "ex"
        formData["dt"] = "ld"
        formData["dt"] = "md"
        formData["dt"] = "qca"
        formData["dt"] = "rw"
        formData["dt"] = "rm"
        formData["dt"] = "ss"
        formData["dt"] = "t"
        formData["ie"] = "UTF-8"
        formData["oe"] = "UTF-8"
        formData["source"] = "btn"
        formData["ssel"] = "0"
        formData["tsel"] = "0"
        formData["kc"] = "0"
        formData["tk"] = token(text)
        formData["q"] = text
    }

    override fun query(): String {
        val uri = URIBuilder(TranslatorConsts.GoogleUrl)
        for (key in formData.keys) {
            val value = formData[key]
            uri.addParameter(key, value)
        }
        val request = HttpGet(uri.toString())
        val response = httpClient!!.execute(request)
        val entity = response.entity

        val result = EntityUtils.toString(entity, "utf-8")

        EntityUtils.consume(entity)
        response.entity.content.close()
        response.close()

        return result
    }

    override fun parses(text: String): String {
        val mapper = ObjectMapper()
        return mapper.readTree(text).get(0).get(0).get(0).toString()
    }

    private fun token(text: String): String {
        var tk = ""
        val engine = ScriptEngineManager().getEngineByName("js")
        try {
            val reader = FileReader("./tk/Google.js")
            engine.eval(reader)

            if (engine is Invocable) {
                val invoke = engine as Invocable
                tk = invoke.invokeFunction("token", text).toString()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return tk
    }

}
