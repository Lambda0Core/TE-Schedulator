<template>
  <div id="app">
    <logo-header />
    <main>
      <sidebar :sidebarOptions="options"/>
      <router-view />
    </main>
  </div>
</template>
<script>
import logoHeader from "./components/LogoHeader.vue";
import sidebar from "./components/SidebarComponent.vue";

export default {
  components: {
    logoHeader,
    sidebar,
  },
  data() {
    return {
      options: this.$store.state.patientSidebarOptions
    }
  },
  setup() {},
};
</script>
<style>
body {
  margin: 0;
}
main {
  display: grid;
  grid-template-columns: 300px 1fr;
  height: 100%;
  width: 100%;
}
#app {
  width: 100vw;
  height: 100vh;
  --primary200: #daffe9;
  --primary400: #47d7ac;
  --primary600: #268598;
  --primary800: #053484;
}
</style>

