package com.ebac.modulo44.feign;

import com.ebac.modulo44.dto.ResponseWrapper;
import com.ebac.modulo44.dto.Telefono;
import com.ebac.modulo44.dto.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class FeignService {

    public final FeignApiClient feignApiClient;
    public final String apiUrl;

    @Autowired
    public FeignService(FeignApiClient feignApiClient, String apiUrl) {
        this.feignApiClient = feignApiClient;
        this.apiUrl = apiUrl;
    }

    public ResponseWrapper<List<Usuario>> getUsers() {
        log.info("Obteniendo usuarios desde la api {}", apiUrl);
        return feignApiClient.getUsers();
    }

    public ResponseWrapper<Usuario> getUserById(int id) {
        log.info("Obteniendo usuario con id {}", id);
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        ResponseWrapper<Usuario> response = feignApiClient.getUserById(id);
        if (response == null || response.getResponseEntity() == null) {
            throw new RuntimeException("Usuario con id " + id + " no encontrado");
        }
        return response;
    }

    public ResponseWrapper<Usuario> createUser(Usuario user) {
        log.info("Creando usuario {}", user);
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        return feignApiClient.createUser(user);
    }

    public ResponseWrapper<Usuario> updateUser(int id, Usuario user) {
        log.info("Actualizando usuario {}", user.getNombre());
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        return feignApiClient.updateUser(user, id);
    }

    public void deleteUser(int id) {
        log.info("Eliminando usuario con id {}", id);
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        feignApiClient.deleteUser(id);
    }

    // ========== TELEFONOS ==========

    public ResponseWrapper<List<Telefono>> getTelefonos() {
        log.info("Obteniendo telefonos desde la api {}", apiUrl);
        return feignApiClient.getTelefonos();
    }

    public ResponseWrapper<Telefono> getTelefonoById(int id) {
        log.info("Obteniendo telefono con id {}", id);
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        ResponseWrapper<Telefono> response = feignApiClient.getTelefonoById(id);
        if (response == null || response.getResponseEntity() == null) {
            throw new RuntimeException("Telefono con id " + id + " no encontrado");
        }
        return response;
    }

    public ResponseWrapper<Telefono> createTelefono(Telefono telefono) {
        log.info("Creando telefono {}", telefono);
        if (telefono == null) {
            throw new IllegalArgumentException("El telefono no puede ser nulo");
        }
        return feignApiClient.createTelefono(telefono);
    }

    public ResponseWrapper<Telefono> updateTelefono(int id, Telefono telefono) {
        log.info("Actualizando telefono con id {}", id);
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        if (telefono == null) {
            throw new IllegalArgumentException("El telefono no puede ser nulo");
        }
        return feignApiClient.updateTelefono(telefono, id);
    }

    public void deleteTelefono(int id) {
        log.info("Eliminando telefono con id {}", id);
        if (id <= 0) {
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        feignApiClient.deleteTelefono(id);
    }
}