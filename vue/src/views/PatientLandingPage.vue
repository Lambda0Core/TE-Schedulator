<template>
  <div class="layout">
    <div>
      <apt-list v-if="this.$store.state.content=='patient-appointments'" />
    </div>   
    <div>
      
      <provider-list  v-if="this.$store.state.content=='patient-providerlist'" />
    </div>   
  </div>
</template>

<script>
import AptList from '../components/AptList.vue';
import ProviderList from '../components/ProviderList.vue';


export default {
  name: "PatientPage",


  components: {
    AptList,
    ProviderList
  },

};
</script>


<style scoped>
.layout {
  
  grid-template-columns: fit-content 1fr;
  height: 100%;
  width: 100%;
}
</style>