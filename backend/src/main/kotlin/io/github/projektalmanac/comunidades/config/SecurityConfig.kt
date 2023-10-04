package io.github.projektalmanac.comunidades.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


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
        http.authorizeHttpRequests {
            it
                .requestMatchers(AntPathRequestMatcher("/api/usuarios/id")).authenticated()
                .anyRequest().permitAll()
        }
            .csrf { it.disable() }
            .headers { it.frameOptions{it.sameOrigin()} }
            .oauth2ResourceServer {
                it.jwt { customizer ->
                    customizer.jwtAuthenticationConverter(jwtAuthenticationConverter())
                }
            }
            .cors()
        return http.build()
    }

    private fun jwtAuthenticationConverter(): JwtAuthenticationConverter {
        val convertidor = JwtAuthenticationConverter()

        convertidor.setJwtGrantedAuthoritiesConverter { jwt ->
            val roles = jwt.getClaimAsStringList("roles")?.map { SimpleGrantedAuthority(it) }
            log.info("Intentando autorizar. Usuario = ${jwt.subject}, Email = ${jwt.claims["email"]}, Roles = $roles")
            roles
        }

        return convertidor
    }
}
