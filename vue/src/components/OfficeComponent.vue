<template>
  <div>
    <h1>List of Offices</h1>
    <div
      class="office-container"
      v-for="office in offices"
      v-bind:key="office.id"
    >
      <router-link v-bind:to="{ name: 'office' }">
        <h2>{{ office.name }}</h2>
        <p class="full-address">
          {{ office.address }} {{ office.cityName }} {{ office.stateAcronym }}
        </p>
        <p class="phone">{{ office.phoneNumber }}</p>
        <div class="hours">{{ office.openTime }} to {{ office.closeTime }}</div>
      </router-link>
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
  created() {
    OfficeService.list().then((response) => {
      this.offices = response.data;
    });
  },
};
</script>

<style scoped>
.office-container {
  color: var(--primary800);
    padding: 1rem 3rem;
    width: auto;
    height: 225px;
    border: 3px var(--primary600) solid;
    border-radius: 1rem;
    box-shadow: 15px 15px var(--primary200);
}
.full-address {
    display: flex;
    align-items: center;
    grid-gap: 0.5rem;
    font-size: 1.25rem;
    display: inline-block; 
}
.phone {
    display: flex;
    align-items: center;
    grid-gap: 0.5rem;
    font-size: 1.25rem;
     
}
.hours {
    margin: 0;
    font-size: 1.5rem;
    
}
</style>