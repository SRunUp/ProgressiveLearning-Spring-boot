package com.translate.compare.translatecompare.service

import com.translate.compare.translatecompare.enums.LanguageEnum
import com.translate.compare.translatecompare.model.TranslatorRequest
import com.translate.compare.translatecompare.model.TranslatorResponse
import com.translate.compare.translatecompare.tranlator.impl.GoogleTranslator
import org.jetbrains.annotations.NotNull
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service


@Service
@Component
class TranslateService {

    @Value("\${esc-table}")
    private var escString: String? = null

    fun execute(@NotNull request: TranslatorRequest): List<TranslatorResponse> {

        var escReplaceRegex = Regex(escString!!.toString())
        var result = arrayListOf<TranslatorResponse>()
        var text = request.text.replace(escReplaceRegex, "")


        //Google -- 长度限制
        var sourceTextArray = text.split(Regex("(?<=[.!?]|[.!?][\\'])\\s+"))
        var googleResult = StringBuilder(2000)

        for (sourceText in sourceTextArray) {
            googleResult.append(GoogleTranslator().run(LanguageEnum.EN, LanguageEnum.ZH, sourceText).replace(Regex("\""), ""))
        }

        result.add(TranslatorResponse("Google", googleResult.toString()))




        return result
    }

}
