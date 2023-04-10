<template>
  <div>
      <div id="sidebar" v-for="option in sidebarOptions" v-bind:key="option.text">
          <div>{{ option }}
      </div>
  </div>
</template>

<script>
export default {
    name: "sidebar",
    props: ['sidebarOptions']
}
</script>

<style>
#sidebar {
    display: grid;
    grid-template-columns: 1f;
    grid-auto-rows: fit-content;
}
</style>