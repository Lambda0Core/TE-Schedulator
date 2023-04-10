<template> 
<div class="logoHeader">
  <router-link v-bind:to="{ name: 'home' }">
  <img class="logo" src="../../img/Logo.png" alt="logo" >
  </router-link>
  <img class="name" src="../../img/name.png" alt="name">
  </div>

</template>

<script>
export default {
  name: "logo-header"

}
</script>

<style>
.logoHeader{
    display: flex;
    align-items: center;

}
.logo{
  height: 150px;
}
.name{
  height: 100px;
}
</style>
