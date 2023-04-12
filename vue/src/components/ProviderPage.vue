<template>
  <div class="layout">
    <sidebar :sidebarOptions="options" />
    <div></div>
  </div>
</template>

<script>
import sidebar from "./SidebarComponent.vue";

export default {
  name: "ProviderPage",

  data() {
    return {
      options: [
        {
          title: "Schedule",
          icon: "calendar-regular.svg",
          link: "/"
        },
        {
          title: "Patients",
          icon: "heart-pulse-solid.svg",
          link: "/mypatients"
        },
        {
          title: "Reviews",
          icon: "star-solid.svg",
          link: "/reviews"
        },
        {
          title: "Office",
          icon: "hospital-solid.svg",
          link: "/office"
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




<style scoped>
.layout {
  display: grid;
  grid-template-columns: fit-content 1fr;
  height: 100%;
  width: 100%;
}
</style>