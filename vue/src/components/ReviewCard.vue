<template>
  <div class="container">
    <div class="identity">
      <div class="img" />
      <h3>
         {{ review.title }}
        </h3>
        <h2>
          Office Location 
          {{review.desc}}          
        </h2>
        <p>
         Rating: {{provider.rating}}
        </p>
    </div>
    
  </div>
</template>

<script>
import reviewService from "../services/ReviewService";

export default {
  name: "review-card",
  props: ["review"],
 data() {
    return {      
      reviews:[],
      };
  },
created() {
      this.getReviewsForProvider(this.providerId);
    },
methods:{
  
      getReviewsForProvider() {
      reviewService.getReviewsByProviderId(this.provider.id).then((response) => {
        console.log(response.data);
        this.reviews = response.data;
      });
    },

    
}
};
</script>

<style scoped>
.container {
  color: var(--primary800);
  padding: 1rem 3rem;
  width: auto;
  height: 225px;
  border: 3px var(--primary600) solid;
  border-radius: 1rem;
  box-shadow: 15px 15px var(--primary200);
}
.identity {
  display: flex;
  align-items: center;
  grid-gap: 0.5rem;
}
.img {
  display: inline-block;
  width: 2rem;
  height: 2rem;
  border: 1px var(--primary600) solid;
  border-radius: 3rem;
}
h2 {
  font-size: 1.25rem;
  display: inline-block;
}
h3 {
  margin: 0;
  font-size: 1.5rem;
  display: inline-block;
}
.date {
  font-size: 1.5rem;
  margin-top: 1rem;
  margin-bottom: 1rem;
}
.office {
  color: var(--primary600);
  margin-top: 0;
}
</style>