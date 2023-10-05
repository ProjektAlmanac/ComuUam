<script lang="ts">
	import { currentCommunity } from '$lib/store';
	import { marked } from 'marked';
	import Paper from '@smui/paper';

	$: description = marked($currentCommunity?.descricion ?? '');
</script>

<div class="comunidad-home">
	<Paper class="description">
		{@html description}
	</Paper>
</div>

<style lang="sass">
    .comunidad-home :global(.description)
        padding: 1rem
        margin: 1rem
</style>
