<template>
  <div class="list">
      <!-- v-for that lists ProviderListElements -->
      <provider-list-element />
  </div>
</template>

<script>
import ProviderListElement from './ProviderListElement.vue'
export default {
  components: { ProviderListElement },
    name: "ProviderList",
}
</script>

<style scoped>
.list {
    margin: 3rem;
    display: flex;
    flex-direction: column;
}
</style>