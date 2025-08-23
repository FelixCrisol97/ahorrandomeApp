package com.crisol.ahorrandome.service.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crisol.ahorrandome.dto.user.UserInfo;
import com.crisol.ahorrandome.exception.ErrorType;
import com.crisol.ahorrandome.exception.dto.user.UserNotFoundException;
import com.crisol.ahorrandome.model.user.User;
import com.crisol.ahorrandome.repository.user.UserRepository;



/**
 * Servicio encargado de manejar la lógica de negocio relacionada con usuarios.
 * Proporciona métodos para crear, leer, actualizar y eliminar usuarios.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Constructor del servicio.
     * 
     * @param userRepository Repositorio para acceder a la base de datos de usuarios.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ------------------- LISTAR -------------------

    /**
     * Obtiene la lista completa de usuarios.
     * 
     * @return Lista de todos los usuarios en la base de datos.
     */
    @Transactional(readOnly=true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // ------------------- BUSCAR POR ID -------------------

    /**
     * Busca un usuario por su ID.
     * 
     * @param id Identificador del usuario.
     * @return Usuario encontrado.
     * @throws UserNotFoundException Si no existe un usuario con el ID proporcionado.
     */
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                    "User not found with id " + id,
                    ErrorType.USER_NOT_FOUND,
                    new UserInfo(id, null, null)
                ));
    }

    /**
     * Busca un usuario usando un objeto User.
     * Útil si se desea pasar el objeto completo para lógica adicional futura.
     * 
     * @param user Objeto usuario que contiene al menos el ID.
     * @return Usuario encontrado.
     * @throws UserNotFoundException Si no existe un usuario con el ID proporcionado.
     */    
    @Transactional(readOnly=true)
    public User findById(User user) {
        return findById(user.getId()); // reutiliza el método anterior
    }

    // ------------------- BUSCAR POR USERNAME -------------------

    /**
     * Busca un usuario por su nombre de usuario.
     * 
     * @param username Nombre del usuario.
     * @return Usuario encontrado.
     * @throws UserNotFoundException Si no existe un usuario con el nombre proporcionado.
     */
    public User findByUsername(String username) {
        return userRepository.findByName(username)
                .orElseThrow(() -> new UserNotFoundException(
                    "User not found with username " + username,
                    ErrorType.USER_NOT_FOUND,
                    new UserInfo(null, username, null)
                ));
    }

    /**
     * Busca un usuario usando un objeto User.
     * 
     * @param user Objeto usuario que contiene al menos el nombre.
     * @return Usuario encontrado.
     * @throws UserNotFoundException Si no existe un usuario con el nombre proporcionado.
     */
    @Transactional(readOnly=true)
    public User findByUsername(User user) {
        return findByUsername(user.getName());
    }

    // ------------------- BUSCAR POR EMAIL -------------------

    /**
     * Busca un usuario por su email.
     * 
     * @param email Email del usuario.
     * @return Usuario encontrado.
     * @throws UserNotFoundException Si no existe un usuario con el email proporcionado.
     */
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(
                    "User not found with email " + email,
                    ErrorType.USER_NOT_FOUND,
                    new UserInfo(null, null, email)
                ));
    }

    /**
     * Busca un usuario usando un objeto User.
     * 
     * @param user Objeto usuario que contiene al menos el email.
     * @return Usuario encontrado.
     * @throws UserNotFoundException Si no existe un usuario con el email proporcionado.
     */
    @Transactional(readOnly=true)
    public User findByEmail(User user) {
        return findByEmail(user.getEmail());
    }

    // ------------------- GUARDAR -------------------

    /**
     * Guarda un usuario en la base de datos.
     * Este método sirve tanto para crear un nuevo usuario como para actualizar uno existente.
     * La restricción de unicidad del email se maneja en la base de datos.
     * 
     * @param user Usuario a guardar.
     * @return Usuario guardado.
     */
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    // ------------------- ELIMINAR -------------------

    /**
     * Elimina un usuario por su ID.
     * 
     * @param id ID del usuario a eliminar.
     */
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Elimina un usuario usando un objeto User.
     * 
     * @param user Objeto usuario que contiene al menos el ID.
     */
    @Transactional
    public void deleteById(User user) {
        deleteById(user.getId());
    }
}