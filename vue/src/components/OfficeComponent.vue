<template>
  <div>
    <!-- <h1>Office Information</h1>
    <div class="office-container">
      <div>
        <office-card :office="office" />
      </div>

      
    </div> -->
  </div>
</template>


<script>
// import OfficeService from "../services/OfficeService";
// import OfficeCard from "./OfficeCard.vue";

// export default {
//   components: { OfficeCard },
//   name: "office-component",

//   data() {
//     return {
//       office: [],
//     };
//   },
//   created() {
//     this.getOfficeByDoctor();
//   },
//   methods: {
//     getOfficeByDoctor() {
//       OfficeService.getOfficeByProvider().then((response) => {
//         console.log(response.data);
//         this.office = response.data;
//       });
//     },
    // updateOfficeInfo() {
    //   OfficeService.updateOfficeForProvider().then((response) => {
    //     console.log(response.data);
    //     this.office = response.data;
    //   });
    // },
    // updateOfficeInfo() {
    //   const officeId = this.office.id;
    //   const updatedOfficeData = {
    //     address: this.office.address,
    //     cityName: this.office.cityName,
    //     stateAcronym: this.office.stateAcronym,
    //     phoneNumber: this.office.phoneNumber,
    //     openTime: this.office.openTime,
    //     closeTime: this.office.closeTime,
    //   };

    //   OfficeService.updateOfficeForProvider(officeId, updatedOfficeData).then(
    //     (response) => {
    //       console.log(response.data);
    //       this.office = response.data;
    //     }
    //   );
    // },
//   },
// };
</script>

<style scoped>
</style>