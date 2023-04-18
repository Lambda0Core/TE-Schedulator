<template>
  <div class="container">
    <div class="identity">
      <profile-pic :providerId="provider.id"/>
      <h2 class = "fullname">Dr. {{ provider.firstName }} {{ provider.lastName }}</h2>
      </div>
      <section class="office">
      <h3>
        {{ office.name }}
      </h3>
      
        <div class="office-details">
          <label>
            Located at: </label
          >
          <div class="value">{{ office.address }} {{ office.cityName }},
            {{ office.stateAcronym }}</div>
          <label
            >Office Hours: </label
          >
          <div class="value">{{ office.openTime }}-{{ office.closeTime }}</div>
          <label class="phone">Phone Number: </label>
          <div class="value">{{ office.phoneNumber }}</div>
        </div>
    </section>
    

    <div class="button-container">
      <div class="button">
        <router-link
          :to="{
            name: 'leave-reviews',
            params: {
              providerId: provider.id,
              providerName: provider.firstName + ' ' + provider.lastName,
            },
          }"
          class="review-link"
          >Leave a review</router-link
        >
      </div>
      <div class="button">
        <router-link
          :to="'book-appointment/' + this.provider.id"
          class="appointment"
          >Book Appointment</router-link
        >
      </div>
      
    <div class="button">
        <router-link
          :to="{ name: 'patient-reviews', params: { providerId: provider.id, providerName: provider.firstName + ' ' + provider.lastName } }"
          class="view-reviews">View Reviews</router-link
        >
      </div>
    </div>
    </div>
 
</template>

<script>
import officeService from "../services/OfficeService";
import ProfilePic from "../components/ProfilePic.vue";

export default {
  name: "provider-card",
  props: ["provider"],
  data() {
    return {
      office: {},
      providerId: 4001,
    };
  },
  created() {
    this.getOffice();
  },
  components: {
    ProfilePic,
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
    viewReview() {
      this.$router.push({
        name: "patient-review",
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
.identity {
  display: flex;
  align-items: center;
}

.fullname {
  margin-left: 0.5em;
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
.view-reviews,
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

.button-container {
  display: flex;
  justify-content: center;
  align-items: center;
}
.button {
  display: flex;
  margin: 0 10px;
}


section.office {
  padding: 1rem;
  background-color: var(--neutral200);
  border-radius: 1rem;
  margin-bottom: 1rem;
}

h3 {
  margin: 0;
  margin-bottom: 0.5rem;
  font-size: 1.15rem;
  display: inline-block;
}
.office-details {
  display: grid;
  grid-template-columns: 1fr 2fr;
  grid-auto-rows: fit-content;
  grid-row-gap: 0.5rem;
}
label {
  color: var(--neutral500);
}
.value {
  color: var(--primary600);
}
</style>