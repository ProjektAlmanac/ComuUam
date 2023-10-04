import type { Comunidad } from '$lib/generated/openapi';
import services from '$lib/services';
import type { User } from '@firebase/auth';
import { writable } from 'svelte/store';

export const currentUser = writable<User | null | undefined>(undefined);

currentUser.subscribe(async (user) => {
	if (!user) return;
	const { usuariosApi } = services;
	const response = await usuariosApi.getId();
	currentUserId.set(response.idUsuario);
});

export const currentUserId = writable<number | null>(null);

export const currentCommunityId = writable<number | null>(null);

export const currentCommunity = writable<Comunidad | null>(null);

currentCommunityId.subscribe(async (id) => {
	if (!id) {
		currentCommunity.set(null);
		return;
	}
	const { comunidadApi } = services;
	const comunidad = await comunidadApi.getInfoComunidad({ idComunidad: id });
	currentCommunity.set(comunidad);
});
