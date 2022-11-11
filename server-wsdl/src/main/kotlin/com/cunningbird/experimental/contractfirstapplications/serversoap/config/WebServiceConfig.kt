package com.cunningbird.experimental.contractfirstapplications.serversoap.config

import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.ws.config.annotation.EnableWs
import org.springframework.ws.config.annotation.WsConfigurerAdapter
import org.springframework.ws.transport.http.MessageDispatcherServlet
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition
import javax.servlet.Servlet

@EnableWs
@Configuration
class WebServiceConfig : WsConfigurerAdapter() {

    @Bean
    fun messageDispatcherServlet(applicationContext: ApplicationContext): ServletRegistrationBean<Servlet> {
        val servlet = MessageDispatcherServlet()
        servlet.setApplicationContext(applicationContext)
        return ServletRegistrationBean(servlet, "/codenotfound/ws/*")
    }

    @Bean(name = arrayOf("helloworld"))
    fun defaultWsdl11Definition(): Wsdl11Definition {
        val wsdl11Definition = SimpleWsdl11Definition()
        wsdl11Definition.setWsdl(ClassPathResource("/wsdl/PetstoreService.wsdl"))
        return wsdl11Definition
    }
}