import type { LayoutLoad } from './$types';
import { browser } from '$app/environment';
import { currentCommunityId } from '$lib/store';

export const load: LayoutLoad = ({ url }) => {
	let communityId: number | null = null;
	if (browser) communityId = Number(url.searchParams.get('id')) || null;
	currentCommunityId.set(communityId);
};
