package com.translate.compare.translatecompare.controller

import com.translate.compare.translatecompare.model.TranslatorRequest
import com.translate.compare.translatecompare.model.TranslatorResponse
import com.translate.compare.translatecompare.service.TranslateService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Api("接口")
@RestController
class TranslateController {

    @Autowired
    private val service: TranslateService? = null

    @ApiOperation("执行翻译")
    @PostMapping("/translate")
    fun execute(@RequestBody request: TranslatorRequest): List<TranslatorResponse> {
        return service!!.execute(request)
    }
}