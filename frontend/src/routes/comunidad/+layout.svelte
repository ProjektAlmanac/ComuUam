<script lang="ts">
	import Tab, { Label } from '@smui/tab';
	import TabBar from '@smui/tab-bar';
	import { page } from '$app/stores';
	import { currentCommunityId } from '$lib/store';
	import { goto } from '$app/navigation';

	interface TabEntry {
		label: string;
		path: string;
	}

	const tabs: TabEntry[] = [
		{
			label: 'Inicio',
			path: `/comunidad`
		},
		{
			label: 'Chat',
			path: `/comunidad/chat`
		},
		{
			label: 'Anuncios',
			path: `/comunidad/anuncios`
		},
		{
			label: 'Eventos',
			path: `/comunidad/eventos`
		}
	];

	const key = (tab: TabEntry) => tab.path;

	let active = tabs.find((tab) => tab.path === $page.url.pathname);

	function navigate(tab: TabEntry) {
		const path = tab.path + '?id=' + $currentCommunityId;
		goto(path);
	}
</script>

<div class="tab-container">
	<TabBar {tabs} let:tab bind:active {key}>
		<Tab {tab} on:click={() => navigate(tab)}>
			<Label>{tab.label}</Label>
		</Tab>
	</TabBar>

	<slot />
</div>

<style lang="sass">
    .tab-container
        height: 100%
        display: grid
        grid-template-rows: auto 1fr
</style>
