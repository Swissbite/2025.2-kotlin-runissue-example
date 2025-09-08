package com.unic.daester.idea20252kotlinrunissueexample.web

import com.unic.daester.idea20252kotlinrunissueexample.controller.Hello
import com.unic.daester.idea20252kotlinrunissueexample.controller.RootRedirectController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = [Hello::class, RootRedirectController::class])
class HelloControllerTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun getHello_returnsHelloWorld() {
        mockMvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello World"))
    }

    @Test
    fun getRoot_redirectsToHello() {
        mockMvc.perform(get("/"))
            .andExpect(status().is3xxRedirection)
            .andExpect(header().string("Location", "/hello"))
    }
}
