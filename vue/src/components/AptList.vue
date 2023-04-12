<template>
  <div>
    <h1>Upcoming Appointments</h1>
    <div class="list" >
      <div v-for="appointment in appointments" :key="appointment.id">
        <apt-card :appointment="appointment" />
      </div>
    </div>
  </div>
</template>

<script>
import AptService from "../services/AptService.js";
import AptCard from "./AptCard.vue";

export default {
  name: "apt-list",
  data() {
    return {
      appointments: []
    };
  },
  methods: {
    getAppointments() {
      AptService.getPatientId(3001).then((response) => {
        console.log(response.data);
        this.appointments = response.data;
      });
    },
  },
  created() {
    this.getAppointments();
  },
  components: {
    AptCard
  }
};
</script>

<style scoped>
h1 {
  margin-left: 3rem;
  margin-top: 3rem;
  color: var(--primary600);
}
.box {
  width:fit-content;
  padding: 1rem 2rem;
  border: 1px black solid;
}
.list {
  margin: 3rem;
  margin-right: 15rem;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr;
  height: fit-content;
  grid-gap: 3rem;
}
</style>
