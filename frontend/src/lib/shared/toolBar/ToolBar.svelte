<TopAppBar bind:this={topAppBar} variant="standard">
    <Row>
      <Section>
        <IconButton class="material-icons">menu</IconButton>
        <Title>ComUAM</Title>
      </Section>
    </Row>
  </TopAppBar>
  <AutoAdjust {topAppBar}>
    
  </AutoAdjust>
  
  <script lang="ts">
    import TopAppBar, {
      Row,
      Section,
      Title,
      AutoAdjust,
    } from '@smui/top-app-bar';
    import IconButton from '@smui/icon-button';
  
    let topAppBar: TopAppBar;
  </script>
  
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