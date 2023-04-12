<template>
  <div class="list">
    <!-- v-for that lists ProviderListElements -->
    <h1>Local Providers</h1>
    Test
     <div v-for="provider in providers" :key="provider.id">
    <provider-card :provider="provider" />
     </div>
  </div>
</template>

<script>
import ProviderService from "../services/ProviderService.js";
import ProviderCard from "./ProviderCard.vue";

export default {
  name: "ProviderList",

  components: {
    ProviderCard,
  },
  data() {
    return {
      providers: [],
    };
  },
  methods: {
    getProviders() {
      ProviderService.list()
      .then((response)=>{
        console.log(response.data);
        this.providers = response.data;
      });
    },
  },
  created() {
    this.getProviders();
  },
};
</script>

<style scoped>
h1 {
  margin-left: 3rem;
  margin-top: 3rem;
  color: var(--primary600);
}
.box {
  width: fit-content;
  padding: 1rem 2rem;
  border: 1px black solid;
}
.list {
  margin: 3rem;
  margin-right: 15rem;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr;
  height: fit-content;
  grid-gap: 3rem;
}
</style>