<template>
  <div>
    <h1>Upcoming Appointments</h1>
    <div class="list">
      <apt-card v-for="appointment in appointments" :key="appointment.id" :appointment="appointment" />
    </div>
  </div>
</template>

<script>
import AptService from "../services/AptService.js";
import UserDetailsService from "../services/UserDetailsService.js";
import AptCard from "./AptCard.vue";

export default {
  name: "apt-list",
  components: {
    AptCard,
  },
  
  data() {
    return {
      patientId: 0,
      appointments: [],
    };
  },
  methods: {
    getAppointments() {
      UserDetailsService.getCurrent().then( function(response) {
        this.patientId = response.data.userId;
        AptService.getAppointmentsByPatientId(this.patientId).then( function(response) {
          debugger;
          console.log(response.data);
          this.appointments = response.data;
        }.bind(this));
      }.bind(this));
    },
  },
  created() {
    this.getAppointments();
  },
  
};
</script>

<style scoped>
h1 {
  margin-left: 3rem;
  margin-top: 3rem;
  color: var(--primary600);
}
.box {
  width: fit-content;
  padding: 1rem 2rem;
  border: 1px black solid;
}
.list {
  margin: 3rem;
  margin-right: 15rem;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  grid-auto-rows: fit-content;
  align-items: stretch;
  justify-content: stretch;
  height: fit-content;
  grid-gap: 3rem;
}
</style>
