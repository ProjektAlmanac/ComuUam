<script lang="ts">
	import TopAppBar, { Row, Section, Title, AutoAdjust } from '@smui/top-app-bar';
	import IconButton from '@smui/icon-button';
	import Drawer from './Drawer.svelte';
	import { Scrim, AppContent } from '@smui/drawer';

	let topAppBar: TopAppBar;

	let open = false;

	function openDrawer() {
		open = true;
	}
</script>

<Drawer bind:open />

<Scrim />
<AppContent>
	<TopAppBar bind:this={topAppBar} variant="standard">
		<Row>
			<Section>
				<IconButton on:click={openDrawer} class="material-icons">menu</IconButton>
				<Title>ComUAM</Title>
			</Section>
		</Row>
	</TopAppBar>
	<AutoAdjust {topAppBar} />
	<main>
		<slot />
	</main>
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
