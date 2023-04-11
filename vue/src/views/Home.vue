<template>
  <div class="layout">
    <sidebar :sidebarOptions="options" />
    <div class="apt-list">Appointment List Goes Here
      <aptlist/>
    </div>
  </div>
  
</template>

<script>

import sidebar from "../components/SidebarComponent.vue";
import aptlist from "../components/AptList.vue";

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
    aptlist
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

.apt-list {
  display: grid;
  height: 100%;
  width: 100%;
}
</style>