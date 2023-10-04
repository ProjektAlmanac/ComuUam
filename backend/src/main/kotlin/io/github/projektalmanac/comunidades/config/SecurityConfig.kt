package io.github.projektalmanac.comunidades.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(
//    prePostEnabled = true,
//    securedEnabled = true,
//    jsr250Enabled = true
//)
class ConfigSeguridad {

    companion object {
        private val log = org.slf4j.LoggerFactory.getLogger(ConfigSeguridad::class.java)
    }


    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        log.info("Configurando seguridad AAAAAAAAAAAAAAAAAAAAAAAAAAAA")
        http.authorizeHttpRequests { authorization ->
            authorization
                .anyRequest().permitAll()
        }
        return http.build()
    }
}
