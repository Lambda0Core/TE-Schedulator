<template>
  <div>
    <h1>List of Offices</h1>
    <div class="office-container">
     
       <office-card :office="office" />
    
    
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
      office: {},
    };
  },
  methods: {
      getOfficeByDetails(detailsId) {
        
          OfficeService.getOfficeByDetailsId(detailsId).then((response) => {
              console.log(response.data);
              this.office = response.data;
          });
      }
  },
  created() {
    this.getOfficeByDetails();
    
  },
};
</script>

<style scoped>

</style>