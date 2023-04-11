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
.container {
  margin: 0;
  display: grid;
  grid-template-columns: 4rem 1fr;
}
.text {
  display: inline-block;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
  color: white;
  font-size: 1.5rem;
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
  height: 2rem;
  width: 2rem;
}
</style>