<template>
  <div class="layout">
    <div>
    <apt-list />
    </div>   
  </div>
</template>

<script>
import AptList from '../components/AptList.vue';


export default {
  name: "PatientPage",


  components: {
    AptList,
    
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