<template>
  <div class="layout">
    <sidebar :sidebarOptions="options" />
  </div>
</template>

<script>
import sidebar from "../components/SidebarComponent.vue";

export default {
  name: "PatientPage",

  data() {
    return {
      options: [
        {
          title: "Upcoming Appointments",
          link: ""
        },
        {
          title: "Find a Provider",
          link: ""
        },
        {
          title: "My Doctors",
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
  grid-template-columns: 1fr 3.5fr;
  height: 100%;
  width: 100%;
}
</style>