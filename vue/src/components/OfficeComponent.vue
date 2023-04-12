<template>
  <!-- <div class="office-container">
    <h2>{{ office.name }}</h2>
    <p class="full-address">
      {{ office.address }} {{ office.cityName }} {{ office.stateAcronym }}
    </p>
    <p class="phone">{{ office.phoneNumber }}</p>
    <div class="hours">{{ office.openTime }} {{ office.closeTime }}</div>
  </div> -->
  <div>
      <h1>List of Offices</h1>
      <div class="office" v-for="office in offices" v-bind:key="office.id" >
          <router-link v-bind:to="{ name: 'office', params: { id: office.id } }">
              {{ office.name }} {{ office.address }}
          </router-link>
      </div>

  </div>
</template>

<script>
import OfficeService from '../services/OfficeService'

export default {
    name: 'office-component',
    // props: ["office"],
    data() {
        return {
            offices: [],
        };
    },
    created() {
        OfficeService.list().then(response => {
            this.offices = response.data;
        });
    }
};
</script>

<style scoped>
.office-container {
    border: 3px var(--primary600) solid;
    padding: 10px;
    margin-bottom: 10px;
}

</style>