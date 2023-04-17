<template>
  <review-card :providerId="providerId" />
</template>

<script>
import reviewCard from "../components/ReviewCard.vue";
import UserDetailsService from "../services/UserDetailsService.js";
import reviewService from "../services/ReviewService.js";

export default {
  components: {
    reviewCard,
  },
  name: "ProviderReviews",
  data() {
    return {
      reviews: [],
    };
  },
  computed: {
    getCurrent() {
      return this.$store.state.currentUser;
    },
  },

   methods: {
    getReviewsForProvider() {
      reviewService
        .getReviewsByProviderId(this.provider.userId)
        .then((response) => {
          console.log(response.data);
          this.reviews = response.data;
        });
    },
  },
  created() {
    this.providerId = UserDetailsService.getProviderId();
    
  },
};
</script>


<style scoped>
</style>