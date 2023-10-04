<script lang="ts">
	import { currentCommunity } from '$lib/store';
	import { marked } from 'marked';
	import Card from '@smui/card';

	$: description = marked($currentCommunity?.descricion ?? '');
</script>

<div class="comunidad-home">
	<Card class="description">
		{@html description}
	</Card>
</div>

<style lang="sass">
    .comunidad-home :global(.description)
        padding: 1rem
        margin: 1rem
</style>
