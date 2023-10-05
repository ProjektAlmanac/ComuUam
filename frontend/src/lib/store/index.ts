import type { Comunidad, UsuarioCreado } from '$lib/generated/openapi';
import services from '$lib/services';
import type { User } from '@firebase/auth';
import { writable } from 'svelte/store';

export const firebaseUser = writable<User | null | undefined>(undefined);

firebaseUser.subscribe(async (user) => {
	if (!user) return;
	const { usuariosApi } = services;
	const response = await usuariosApi.getMe();
	currentUser.set(response);
});

export const currentUser = writable<UsuarioCreado | null>(null);

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
