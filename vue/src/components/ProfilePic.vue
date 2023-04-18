<template>
  <div class="photo">
    <img :src="require(`../../img/profile/${filename}`)" alt="Doctor Photo" />
  </div>
</template>

<script>
export default {
  name: "profilePic",
  data() {
    return {
      filename: "",
    };
  },
  props: ["providerId"],
  created() {
    switch (this.providerId) {
      case 4000:
        this.filename = "Profile (16).png";
        break;
      case 4001:
        this.filename = "Profile (14).png";
        break;
      case 4002:
        this.filename = "Profile (12).png";
        break;
      case 4003:
        this.filename = "Profile (17).png";
        break;
      case 2001:
        this.filename = "Profile (10).png";
        break;
    }
  },
};
</script>

<style scoped>
img {
  height: 3rem;
  width: 3rem;
  border-radius: 5rem;
}
</style>