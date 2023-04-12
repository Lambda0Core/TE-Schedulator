<template>
  <div class="list">
      <!-- v-for that lists ProviderListElements -->
      <provider-card />
  </div>
</template>

<script>
import ProviderCard from './ProviderCard.vue'
export default {
  components: { 
    ProviderCard },
    name: "ProviderCard",
}
</script>

<style scoped>
.list {
    margin: 3rem;
    display: flex;
    flex-direction: column;
}
</style>