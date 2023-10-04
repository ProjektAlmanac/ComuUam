package io.github.projektalmanac.comunidades.service;

import io.github.projektalmanac.comunidades.entity.Comunidad;
import io.github.projektalmanac.comunidades.exception.CommunityNotFoundException;
import io.github.projektalmanac.comunidades.generated.dto.ComunidadDto;
import io.github.projektalmanac.comunidades.generated.dto.IdUsuarioDto;
import io.github.projektalmanac.comunidades.mapper.ComunidadMapper;
import io.github.projektalmanac.comunidades.repository.ComunidadRepository;
import io.github.projektalmanac.comunidades.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComunidadRepository comunidadRepository;

    public ComunidadDto getInfoComunidad(Integer id){
        LOGGER.info(">> getInfoComunidad {}", id);
        Comunidad comunidad = this.comunidadRepository.findComunidadById(id);

        if(comunidad == null){
            throw new CommunityNotFoundException(id);
        }
        ComunidadDto comunidadDto = ComunidadMapper.Companion.getINSTANCE().comunidadToDto(comunidad);
        if(comunidadDto == null){
            throw new IllegalArgumentException("Erro, el mapeo de entidad no fue exitoso");
        }

        LOGGER.info("<< getInfoComunidad {}", id);
        return comunidadDto;

    }

    public void agregaMiembroComunidad(Integer idComunidad, IdUsuarioDto usuarioDto){

    }

}
