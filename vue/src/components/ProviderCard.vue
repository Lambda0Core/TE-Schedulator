<template>
  <div class="container">
    <div class="identity">
     
      <h2 class = "fullname">Dr. {{ provider.firstName }} {{ provider.lastName }}</h2>
      </div>
      <h3>
        {{ office.name }}
         </h3>
      <p> Located at: {{ office.address }} {{ office.cityName }}
        {{ office.stateAcronym }}</p>
      <p>Office Hours: {{ office.openTime }} to {{ office.closeTime }}</p>
      <p class="phone">Phone Number: {{ office.phoneNumber }}</p>

      
    <div class ="button-container">
    <div class="button">
      <router-link
        :to="{ name: 'leave-reviews', params: { providerId: provider.id, providerName: provider.firstName + ' ' + provider.lastName } }"
        class="review-link">Leave a review</router-link
      >
    </div>
    <div class="button">
      <router-link
        :to="{ name: 'book-appointment', params: { providerId: provider.id, providerName: provider.firstName + ' ' + provider.lastName } }"
        class="appointment">Book Appointment</router-link
      >
    </div>
    </div>
  </div>
</template>

<script>
import officeService from "../services/OfficeService";

export default {
  name: "provider-card",
  props: ["provider"],
  data() {
    return {
      office: {},
    };
  },
  created() {
    this.getOffice();
  },
  methods: {
    getOffice() {
      officeService.get(this.provider.officeId).then((response) => {
        console.log(response.data);
        this.office = response.data;
      });
    },
    leaveReview() {
      this.$router.push({
        name: "leave-review",
        params: { providerName: this.provider.name },
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
.identity{
  display: flex;
  align-items: center;
}

.fullname {
  flex: 1 1 auto;
  
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
  font-size: 1.4rem;
  display: inline-block;
}
h3 {
  margin: 0;
  font-size: 1.15rem;
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
.review-link {
  font-size: 1rem;
  color: var(--primary200);
  background-color: var(--primary400);
  border-radius: 0.5rem;
  padding: 5px 15px;  
  cursor: pointer;
}
.review-link:hover {
  background-color: var(--primary600);
}
.appointment {
  font-size: 1rem;
  color: var(--primary200);
  background-color: var(--primary400);
  border-radius: 0.5rem;
  padding: 5px 15px;  
  cursor: pointer;
  
}
.appointment:hover {
  background-color: var(--primary600);
}

.button-container{
  display: flex;
  justify-content: center;
  align-items: center;
 
}
.button {
  display: flex;
    margin: 0 10px;
  }
</style>