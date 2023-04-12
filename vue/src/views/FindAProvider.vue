<template>
  <div class="layout">
    <div></div>
  </div>
</template>

<script>

export default {
  name: "FindAProvider",

  data() {
    return {
      options: this.$store.state.patientSidebarOptions
    }
  },

  setup() {},
};
</script>




<style scoped>
.layout {
  display: grid;
  grid-template-columns: fit-content 1fr;
  height: 100%;
  width: 100%;
}
</style>