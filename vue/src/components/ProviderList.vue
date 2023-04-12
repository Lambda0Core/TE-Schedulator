<template>
  <div class="list">
      <!-- v-for that lists ProviderListElements -->
      Test
      <provider-card />
  </div>
</template>

<script>
import ProviderCard from './ProviderCard.vue'
export default {
  name: "ProviderList",
  components: { 
    ProviderCard 
  },
}
</script>

<style scoped>
.list {
    margin: 3rem;
    display: flex;
    flex-direction: column;
}
</style>