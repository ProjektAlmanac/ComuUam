package io.github.projektalmanac.comunidades.exception

class UserNotFoundException(userId: Int) : RuntimeException("No se encontró ningún usuario con id $userId.")
