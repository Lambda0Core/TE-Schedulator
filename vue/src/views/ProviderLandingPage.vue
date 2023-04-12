<template>
  <div class="layout">
    <sidebar :sidebarOptions="options" />
    <div></div>
  </div>
</template>

<script>
import sidebar from "../components/SidebarComponent.vue";

export default {
  name: "ProviderPage",

  data() {
    return {
      options: this.$store.state.providerSidebarOptions
    }
  },
  components: {
    sidebar,
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