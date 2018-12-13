package com.translate.compare.translatecompare.translator

import com.translate.compare.translatecompare.enums.LanguageEnum
import com.translate.compare.translatecompare.tranlator.impl.GoogleTranslator
import org.junit.Test

class GoogleTranslatorTests{
    @Test
    fun simpleTest(){
        val from = LanguageEnum.EN
        val to = LanguageEnum.ZH
        val text = "XXX Comment: Infections are not uncommon with the use of immunosuppressive agents because of the immunocompromised status of the patient hence the causal role for the suspect immunosuppressive drug XXX can not be ruled out for the events Urinary tract infection and Diarrhoea in concurrence to their infectious nature of aetiopathogenesis."

        val result = GoogleTranslator().run(from, to, text)
        println(result)
    }


}