<script lang="ts">
	import TopAppBar, { Row, Section, Title, AutoAdjust } from '@smui/top-app-bar';
	import IconButton from '@smui/icon-button';
	import Drawer from './Drawer.svelte';
	import { Scrim, AppContent } from '@smui/drawer';
	import Button from '@smui/button';
	import { currentUser, firebaseUser } from '$lib/store';
	import { getAuth, signOut } from 'firebase/auth';

	let topAppBar: TopAppBar;

	let open = false;

	function openDrawer() {
		open = true;
	}

	async function logout() {
		const auth = getAuth();
		await signOut(auth);
	}

	$: console.log($firebaseUser);
</script>

<Drawer bind:open />

<Scrim />
<AppContent style="height: 100%">
	<TopAppBar bind:this={topAppBar} variant="fixed">
		<Row>
			<Section>
				<IconButton on:click={openDrawer} class="material-icons">menu</IconButton>
				<Title>ComUAM</Title>
			</Section>
			<Section align="end">
				{#if $firebaseUser}
					<Button color="secondary" variant="raised" on:click={logout}>Cerrar sesión</Button>
				{:else}
					<a href="/login">
						<Button color="secondary" variant="raised">Iniciar sesión</Button>
					</a>
				{/if}
			</Section>
		</Row>
	</TopAppBar>
	<AutoAdjust {topAppBar} style="height: 100%">
		<slot />
	</AutoAdjust>
</AppContent>

<style>
	/* Hide everything above this component. */
	:global(#smui-app),
	:global(body),
	:global(html) {
		display: block !important;
		height: auto !important;
		width: auto !important;
		position: static !important;
	}
</style>
