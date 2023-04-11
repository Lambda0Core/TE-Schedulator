<template>
  <div class="layout">
    <sidebar :sidebarOptions="options" />
  </div>
</template>

<script>


import sidebar from "../components/SidebarComponent.vue";

// import AptService from "../services/AptService";

export default {
  name: "PatientPage",

  data() {
    return {
      options: [
        {
          title: "Upcoming Appointments",
          icon: "calendar-regular.svg",
          link: "/"
        },
        {
          title: "Find a Provider (MAINTENANCE)",
          icon: "briefcase-medical-solid.svg",
          link: ""
        },
        {
          title: "My Doctors (MAINTENANCE)",
          icon: "user-doctor-solid.svg",
          link: ""
        }
      ]
    }
  },
  components: {
    sidebar,
  },

  setup() {},
};
</script>




<style>
.layout {
  display: grid;
  grid-template-columns: minmax(20vw, 300px) 1fr;
  height: 100%;
  width: 100%;
}
</style>