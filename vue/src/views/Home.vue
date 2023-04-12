<template>
  <div class="layout">
   <patient-page />
  </div>
  
</template>

<script>

import PatientPage from "../components/PatientPage.vue";

export default {
  name: "home",

  data() {
    return {
    }
  },
  components: {
    PatientPage
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