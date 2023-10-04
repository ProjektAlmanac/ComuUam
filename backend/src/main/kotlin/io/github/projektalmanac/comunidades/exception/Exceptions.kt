package io.github.projektalmanac.comunidades.exception

class UserNotFoundException(userId: Int) : RuntimeException("No se encontró ningún usuario con id $userId.")

class UserAlreadyExistsException(email: String) : RuntimeException("Ya existe un usuario con el correo $email.")