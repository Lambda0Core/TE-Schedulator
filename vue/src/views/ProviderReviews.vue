<template>
  <div>
    <review-card
      v-for="review in reviews"
      :key="review.reviewId"
      :review="review"
    />
  </div>
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
      provider: {},
    };
  },
  computed: {
    getCurrent() {
      return this.$store.state.currentUser;
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
    UserDetailsService.getCurrent().then((response) => {
      console.log(response.data);
      this.provider = response.data;
        this.getReviewsForProvider();
    });
  
  },
};
</script>


<style scoped>
</style>