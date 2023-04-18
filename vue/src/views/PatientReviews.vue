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

export default {
  components: {
    reviewCard,
  },
  name: "PatientReviews",
  data() {
    return {
      reviews: [],
      
    };
  },
  

  methods: {
    getReviews() {
     
      reviewService.list().then((response) => {
        console.log(response.data);
        this.reviews = response.data;
      });
    },
  },
  created() {
   this.getReviews();
  
  },
};
</script>


<style scoped>
</style>