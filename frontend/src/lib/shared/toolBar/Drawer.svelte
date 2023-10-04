<script lang="ts">
	import Drawer, { AppContent, Content, Header, Title, Subtitle, Scrim } from '@smui/drawer';
	import List, { Item, Text, Graphic, Separator, Subheader } from '@smui/list';
	import { page } from '$app/stores';

	export let open = false;

	$: active = $page.url.pathname;
	$: console.log(active);

	function setActive(name: string) {
		active = name;
		open = false;
	}
</script>

<Drawer variant="modal" bind:open on:blur={() => console.log('click')}>
	<Header>
		<Title>ComuUam</Title>
	</Header>
	<Content>
		<List>
			<Item href="/" on:click={() => setActive('/')} activated={active === '/'}>
				<Graphic class="material-icons" aria-hidden="true">home</Graphic>
				<Text>Inicio</Text>
			</Item>
			<Item
				href="/mis-comunidades"
				on:click={() => setActive('/mis-comunidades')}
				activated={active === '/mis-comunidades'}
			>
				<Graphic class="material-icons" aria-hidden="true">star</Graphic>
				<Text>Mis comunidades</Text>
			</Item>
		</List>
	</Content>
</Drawer>
