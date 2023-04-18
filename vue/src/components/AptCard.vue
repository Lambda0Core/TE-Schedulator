<template>
  <div class="container">
    <p class="date">{{ formattedDate }}</p>
    <div class="identity">
      <profile-pic :providerId="this.appointment.detailsId" />
      <h3>
        Dr. {{ appointment.providerFirstName }}
        {{ appointment.providerLastName }}
      </h3>
    </div>
    <h2>{{ appointment.name }}</h2>
    <p class="agenda">{{ appointment.agenda }}</p>
  </div>
</template>

<script>
import ProfilePic from "../components/ProfilePic.vue";
import { format } from "date-fns";
export default {
  name: "apt-card",
  props: ["appointment"],
  computed: {
    formattedDate() {
      const aptDate = new Date(this.appointment.date)
      return format(aptDate,'MMMM dd, yyyy h:mm a' );
    }
  },
  components: {
    ProfilePic,
  },
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
  height: 275px;
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
  margin: 0;
  margin-top: 0.75rem;
  margin-bottom: 0.5rem;
  font-size: 1.5rem;
  color: var(--primary800);
  display: inline-block;
}
h3 {
  margin: 0;
  color: var(--primary600);
  font-size: 1.25rem;
  display: inline-block;
}
.date {
  position: relative;
  font-weight: bold;
  font-size: 1.5rem;
  margin-top: 1rem;
  margin-bottom: 2rem;

}
.date:before {
  z-index: -1;
  content: " ";
  display: block;
  height: 90%;
  width: 100%;
  margin-left: -3px;
  margin-right: -3px;
  position: absolute;
  background: var(--primary200);
  top: -1px;
  left: -1px;
  padding: 10px 3px 3px 10px;
}
.agenda {
  color: var(--neutral800);
  margin-top: 0;
  text-overflow: ellipsis;
}
</style>