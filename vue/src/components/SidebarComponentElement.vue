<template>
  <router-link class="container" v-bind:to="element.link">
    <div class="img-container"><img :src="require(`../../public/icon/${element.icon}`)" alt="" /></div>
    <div class="text">{{ element.title }}</div>
  </router-link>
</template>

<script>
export default {
  name: "sidebar-element",
  props: ["element"],
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Open+Sans&display=swap');

.container {
  margin: 0;
  display: grid;
  grid-template-columns: 4rem 1fr;
}
.text {
  display: inline-block;
  font-family: 'Open Sans', sans-serif;
  color: #daffe9;
  font-size: 1.7rem;
  margin: 1.5rem 0.5rem;
}
a {
  
  text-decoration: none;
}
.img-container {
  display: flex;
  align-items: center;
  justify-content: center;
}
img {
  height: 1.5rem;
  width: 1.5rem;
}
</style>