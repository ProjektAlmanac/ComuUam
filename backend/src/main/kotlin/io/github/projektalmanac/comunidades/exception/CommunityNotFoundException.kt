package io.github.projektalmanac.comunidades.exception

class CommunityNotFoundException(userId: Int) : RuntimeException("No se encontró a ninguna comunidad con id $userId.")