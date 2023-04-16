<template>
  <div>
    <h1>Office Information</h1>
    <div class="office-container">
      <office-card :office="office" />
      <button v-on:click="updateOfficeInfo()">Submit Office Info</button>
      <div v-for="office in offices" :key="office.id">
        <input type="checkbox" v-model="officeId" :value="office.id" />
        <div>{{ office.name }}</div>
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
      office: [],
      officeId: null,
    };
  },
  methods: {
      getOfficeByDetails(detailsId) {
        
          OfficeService.getOfficeByDetailsId(detailsId).then((response) => {
              console.log(response.data);
              this.offices = response.data;
          });
      },
      getOfficeByDoctor() {
        OfficeService.getOfficeByProvider().then((response) => {
          console.log(response.data);
          this.office = response.data;
        })
      },
      updateOfficeInfo() {
        OfficeService.updateOfficeForProvider(this.office);
      },
  },
  created() {
    this.getOfficeByDoctor();

    
  },
};
</script>

<style scoped>

</style>