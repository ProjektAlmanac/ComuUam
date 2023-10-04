import type { PageLoad } from './$types';
import { browser } from '$app/environment';
import { currentCommunityId } from '$lib/store';

export const load: PageLoad = ({ url }) => {
	let communityId: number | null = null;
	if (browser) communityId = url.searchParams.get('id') ?? null;
	currentCommunityId.set(communityId);
};
