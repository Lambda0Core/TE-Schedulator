<template>
  <div class="layout">
    <patient-page v-if="userType == 'patient'" />
    <provider-page v-if="userType == 'provider'" />
  </div>
</template>

<script>
import PatientPage from "../components/PatientPage.vue";
import ProviderPage from "../components/ProviderPage.vue";

export default {
  name: "home",

  data() {
    return {};
  },
  computed: {
    userType() {
      return this.$store.state.userType;
    }
  },
  components: {
    PatientPage,
    ProviderPage,
  },

  setup() {},
};
</script>




<style>
.layout {
  display: grid;
  grid-template-columns: minmax(20vw, 300px) 1fr;
  height: 100%;
  width: 100%;
}

.apt-list {
  display: grid;
  height: 100%;
  width: 100%;
}
</style>