<template>
<div>
    <review-card v-for="review in reviews"
      :key="review.reviewId"
      :review="review"/>
    
</div>
    </template>

<script>

import reviewCard from "../components/ReviewCard.vue";

import reviewService from "../services/ReviewService.js";
import UserDetailsService from '../services/UserDetailsService';

export default {
  components: {
    reviewCard,
  },
  name: "PatientReviews",
  data() {
    return {
      reviews: [],
      provider: {},
    };
  },
  computed: {
      get() {
          return this.$store.state.providers;
      },
  },
  

  methods: {
    
    getReviewsForProvider() {
     
      reviewService.listProviderReviews(this.provider.id).then((response) => {
        console.log(response.data);
        this.reviews = response.data;
      });
    },
  },
  created() {
      UserDetailsService.get(this.$route.params.providerId).then((response) => {
          console.log(response.data);
          this.provider = response.data;
          this.getReviewsForProvider();
      });
  
    
  },
};
</script>


<style scoped>
</style>