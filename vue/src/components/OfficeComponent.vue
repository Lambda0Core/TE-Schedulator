<template>
  <div class="office-container">
    <h2>{{ office.name }}</h2>
    <p class="full-address">
      {{ office.address }} {{ office.cityName }} {{ office.stateAcronym }}
    </p>
    <p class="phone">{{ office.phoneNumber }}</p>
    <div class="hours">{{ office.openTime }} {{ office.closeTime }}</div>
  </div>
</template>

<script>
export default {
    name: 'office-component',
    props: ["office"],

};
</script>

<style scoped>
.office-container {
    border: 3px var(--primary600) solid;
    padding: 10px;
    margin-bottom: 10px;
}

</style>