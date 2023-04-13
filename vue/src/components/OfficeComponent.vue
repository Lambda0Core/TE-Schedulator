<template>
  <div>
    <h1>List of Offices</h1>
    <div
      class="office-container"
      v-for="office in offices"
      v-bind:key="office.id"
    >
      <h2>{{ office.name }}</h2>
      <p class="full-address">
        {{ office.address }} {{ office.cityName }} {{ office.stateAcronym }}
      </p>
      <p class="phone">{{ office.phoneNumber }}</p>
      <div class="hours">{{ office.openTime }} to {{ office.closeTime }}</div>
    </div>
  </div>
</template>

<script>
import OfficeService from "../services/OfficeService";

export default {
  name: "office-component",

  data() {
    return {
      offices: [],
    };
  },
  methods: {
      list() {
          OfficeService.list().then((response) => {
              console.log(response.data);
              this.offices = response.data;
          })
      }
  },
  created() {
    this.list();
    
  },
};
</script>

<style scoped>
.office-container {
  color: var(--primary800);
  padding: 1rem 3rem;
  /* width: auto; */
  max-width: 50%;
  height: 225px;
  border: 3px var(--primary600) solid;
  border-radius: 1rem;
  box-shadow: 15px 15px var(--primary200);
  margin-bottom: 2rem;
}
.office-container h2, .office-container .phone, .office-container .hours, .office-container .full-address  {
    text-align: left;
}

</style>