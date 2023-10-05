<script lang="ts">
	import { Icon } from '@smui/common';

	export let content: string;
	export let author: string;
</script>

<div class="chat-message">
	<Icon class="material-icons">account_circle</Icon>
	<strong>{author}:</strong>
	{content}
</div>

<style lang="sass">
.chat-message
    display: flex
    justify-content: flex-start
    align-items: center
    padding: 0.5rem
    gap: 0.2rem
</style>
