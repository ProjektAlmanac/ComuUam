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
<AppContent style="height: 100%">
	<TopAppBar bind:this={topAppBar} variant="fixed">
		<Row>
			<Section>
				<IconButton on:click={openDrawer} class="material-icons">menu</IconButton>
				<Title>ComUAM</Title>
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
