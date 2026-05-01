package com.ebac.modulo44.feign;

import com.ebac.modulo44.dto.ResponseWrapper;
import com.ebac.modulo44.dto.Telefono;
import com.ebac.modulo44.dto.Usuario;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface FeignApiClient {

    // USUARIOS

    @RequestLine("GET /usuarios")
    ResponseWrapper<List<Usuario>> getUsers();

    @RequestLine("GET /usuarios/{id}")
    ResponseWrapper<Usuario> getUserById(@Param("id") int id);

    @RequestLine("POST /usuarios")
    @Headers({"Content-Type: application/json"})
    ResponseWrapper<Usuario> createUser(Usuario usuario);

    @RequestLine("PUT /usuarios/{id}")
    @Headers({"Content-Type: application/json"})
    ResponseWrapper<Usuario> updateUser(Usuario usuario, @Param("id") int id);

    @RequestLine("DELETE /usuarios/{id}")
    void deleteUser(@Param("id") int id);

    //TELEFONOS

    @RequestLine("GET /telefonos")
    ResponseWrapper<List<Telefono>> getTelefonos();

    @RequestLine("GET /telefonos/{id}")
    ResponseWrapper<Telefono> getTelefonoById(@Param("id") int id);

    @RequestLine("POST /telefonos")
    @Headers({"Content-Type: application/json"})
    ResponseWrapper<Telefono> createTelefono(Telefono telefono);

    @RequestLine("PUT /telefonos/{id}")
    @Headers({"Content-Type: application/json"})
    ResponseWrapper<Telefono> updateTelefono(Telefono telefono, @Param("id") int id);

    @RequestLine("DELETE /telefonos/{id}")
    void deleteTelefono(@Param("id") int id);
}



