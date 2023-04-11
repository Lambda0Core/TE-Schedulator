<template>
  <div class="container">
      <h2>{{ appointment.name }}</h2>
      <div class="identity">
        <div class="img"/>
        <h3>Dr. {{ appointment.providerFirstName }} {{ appointment.providerLastName }}</h3>
      </div>
      <p class="agenda">{{ appointment.agenda }}</p>
      <p class="date">{{ appointment.date }}</p>
  </div>
</template>

<script>
export default {
    name: 'apt-card',
    props: ["appointment"],
}
</script>

<style scoped>
.container {
    color: var(--primary800);
    padding: 1rem 3rem;
    width: fit-content;
    border: 3px var(--primary600) solid;
    border-radius: 1rem;
    box-shadow: 15px 15px var(--primary200);
}
.identity {
    display: flex;
    align-items: center;
    grid-gap: 0.5rem;
}
.img {
    display: inline-block;
    width: 2rem;
    height: 2rem;
    border: 1px var(--primary600) solid;
    border-radius: 3rem;
}
h3 {
    margin: 0;
    font-size: 2rem;
    display: inline-block;   
}
</style>