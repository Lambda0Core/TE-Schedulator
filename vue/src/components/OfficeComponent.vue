<template>
  <div>
    <h1>List of Offices</h1>
    <div class="office-container">
     <div v-for="office in offices" v-bind:key="office.id">
       <office-card :office="office" />
    </div>
    
       </div>
  </div>
</template>

<script>
import OfficeService from "../services/OfficeService";
import OfficeCard from './OfficeCard.vue';


export default {
  components: { OfficeCard },
  name: "office-component",
  

  data() {
    return {
      offices: [],
    };
  },
  methods: {
      getOfficeByDetails() {
          OfficeService.getOfficeByDetailsId().then((response) => {
              console.log(response.data);
              this.offices = response.data;
          });
      }
  },
  created() {
    this.getOfficeByDetails;
    
  },
};
</script>

<style scoped>
h1 {
  margin-left: 3rem;
  margin-top: 3rem;
  color: var(--primary600);
}
.box {
  width: fit-content;
  padding: 1rem 2rem;
  border: 1px black solid;
}
.office-container {
  margin: 3rem;
  margin-right: 15rem;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr;
  height: fit-content;
  grid-gap: 3rem;
}

</style>