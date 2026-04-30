package com.ebac.modulo44.resttemplate;

import com.ebac.modulo44.dto.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RestTemplateService {

    @Autowired
    private RestTemplateClient client;

    @Autowired
    private ObjectMapper objectMapper;

    public Usuario getUserById(Long id) {
        ResponseEntity<String> response = client.getUserById(id);

        try {
            return objectMapper.readValue(response.getBody(), Usuario.class);
        } catch (Exception e) {
            throw new RuntimeException("Error parseando usuario");
        }
    }

    public Usuario createUser(Usuario usuario) {
        try {
            String json = objectMapper.writeValueAsString(usuario);
            ResponseEntity<String> response = client.createUser(json);
            return objectMapper.readValue(response.getBody(), Usuario.class);
        } catch (Exception e) {
            throw new RuntimeException("Error creando usuario");
        }
    }
}
