<template>
  <div class="list">
    <apt-card :appointment="appointment" />
    <apt-card :appointment="appointment" />
  </div>
</template>

<script>
import AptService from "../services/AptService.js";
import AptCard from "./AptCard.vue";

export default {
  name: "apt-list",
  data() {
    return {
      appointment: {}
    };
  },
  methods: {
    getAppointments() {
      AptService.get(5001).then((response) => {
        this.appointment = response.data;
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
.box {
  width:fit-content;
  padding: 1rem 2rem;
  border: 1px black solid;
}
.list {
  margin: 3rem;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  height: fit-content;
}
</style>
