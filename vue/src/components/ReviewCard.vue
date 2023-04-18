<template>
  <div class="container">
    <div class="identity">
      
      <div class="review-details">
        <div class="patient-details">
          <p class="patient-name">Patient: {{ patientDetails.firstName }} {{ patientDetails.lastName }}</p>
        </div>
        <h2 class="review-title" v-if="review">{{ review.reviewTitle }}</h2>
        <div class="review-rating">
          <p>Rating: {{ review.rating }}</p>
        </div>
        <div class="review-desc">
          <p>{{ review.reviewDesc }}</p>
        </div>
        
      </div>
    </div>
  </div>
</template>

<script>
import reviewService from "../services/ReviewService";
import userService from "../services/UserDetailsService";

export default {
  name: "review-card",
  props: ["review"],
  data() {
    return {
      reviews: [],
      patientDetails: {},
    };
  },
  created() {
    this.getReviews();
    this.getUserNamebyReview();
  },
  methods: {
    getReviews() {
      reviewService.list().then((response) => {
        console.log(response.data);
        this.reviews = response.data;
      });
    },
    getUserNamebyReview() {
      userService.getUserNamebyReview(this.review.userId).then((response) => {
        console.log(response.data);
        this.patientDetails = response.data;
      });
    },
  },
};
</script>

<style scoped>
.container {
  color: var(--primary800);
  padding: 1rem 3rem;
  width: auto;
  height: fit-content;

  border: 3px var(--primary600) solid;
  border-radius: 1rem;
  box-shadow: 15px 15px var(--primary200);
}

.identity {
  display: flex;
  align-items: center;
  grid-gap: 1rem;
}
h2{
  font-weight: bold;
}

.review-details {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin-right: 1rem;
  margin-bottom: .1rem;
}

.review-rating {
  margin-top: .1rem;
  font-size: .8rem;
  font-weight: bold;
}

.review-desc {
  font-size: 1rem;
  margin-bottom: 1rem;
}

.patient-name {
  font-size: 0.75rem;
  font-weight: bold;
}

h2 {
  font-size: 1.25rem;
  margin-top: 0;
}

.date {
  font-size: 1.5rem;
  margin-top: 1rem;
  margin-bottom: 1rem;
}
</style>