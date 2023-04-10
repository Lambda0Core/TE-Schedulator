<template>
  <a href="element.link">{{ element.title }}</a>
</template>

<script>
export default {
    name: "sidebar-element",
    props: ["element"]
}
</script>

<style scoped>
a {
  display: inline-block;
  font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  color: #053484;
  font-size: 2rem;
  text-decoration: none;
  margin: 1.5rem;
  font-weight: 400;
}
</style>