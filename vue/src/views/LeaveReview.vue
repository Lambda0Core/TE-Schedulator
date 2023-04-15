<template>
  <div class="container">
    <h2>Leave a Review</h2>
    <div class="rating">
      <span @click="rate(1)" :class="{ active: rating >= 1 }">&#9733;</span>
      <span @click="rate(2)" :class="{ active: rating >= 2 }">&#9733;</span>
      <span @click="rate(3)" :class="{ active: rating >= 3 }">&#9733;</span>
      <span @click="rate(4)" :class="{ active: rating >= 4 }">&#9733;</span>
      <span @click="rate(5)" :class="{ active: rating >= 5 }">&#9733;</span>
    </div>
    <div class="form-group">
      <label for="header">Header</label>
      <input type="text" class="form-control" id="header" v-model="header">
    </div>
    <div class="form-group">
      <label for="message">Message</label>
      <textarea class="form-control" id="message" v-model="message"></textarea>
    </div>
    <button class="btn btn-primary" @click="submitReview">Submit</button>
  </div>
</template>

<script>
export default {
  name: "leave-review",
  data() {
    return {
      rating: 0,
      header: "",
      message: "",
    };
  },
  methods: {
    rate: function (index) {
      this.rating = index;
    },
    submitReview: function () {
      // Submit review to backend
      console.log(
        `Rating: ${this.rating}, Header: ${this.header}, Message: ${this.message}`
      );
      // Redirect to provider page
      this.$router.push(`/provider/${this.providerId}`);
    },
  },
  computed: {
    providerId: function () {
      // Get provider id from route parameters
      return this.$route.params.id;
    },
  },
};
</script>