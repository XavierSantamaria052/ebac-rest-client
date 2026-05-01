package com.ebac.modulo44.resttemplate;

import com.ebac.modulo44.dto.ResponseWrapper;
import com.ebac.modulo44.dto.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class RestTemplateService {

    private final RestTemplateClient restTemplateClient;
    private final ObjectMapper objectMapper;

    public RestTemplateService(RestTemplateClient restTemplateClient, ObjectMapper objectMapper) {
        this.restTemplateClient = restTemplateClient;
        this.objectMapper = objectMapper;
    }

    public void getUsers() throws JsonProcessingException {
        String users = restTemplateClient.getUsers();

        ResponseWrapper<List<Usuario>> usuarios = objectMapper.readValue(users, new TypeReference<>() {});

        if (usuarios.isSuccess()) {
            log.info(usuarios.getMessage());
            usuarios.getResponseEntity().getBody().forEach(System.out::println);
        }
    }

    public void getUserById(long id) throws JsonProcessingException {
        String user = restTemplateClient.getUserById(id);

        ResponseWrapper<Usuario> usuario = objectMapper.readValue(user, new TypeReference<>() {});

        if (usuario.isSuccess()) {
            log.info(usuario.getMessage());
            System.out.println(usuario.getResponseEntity().getBody());
        }
    }

    public void createUser(Usuario usuario) throws JsonProcessingException {
        String usuarioCreado = restTemplateClient.createUser(usuario);

        ResponseWrapper<Usuario> usuarioMapeado = objectMapper.readValue(usuarioCreado, new TypeReference<>() {});

        log.info("Usuario creado: {}", usuarioMapeado.getResponseEntity().getBody());
    }

    public void updateUser(Usuario usuario, long id) {
        String usuarioActualizado = restTemplateClient.updateUserById(usuario, id);
        log.info("Usuario actualizado: {}", usuarioActualizado);
    }

    public void deleteUser(long id) {
        String usuarioEliminado = restTemplateClient.deleteUserById(id);
        log.info("Usuario eliminado: {}", usuarioEliminado);
    }
}
