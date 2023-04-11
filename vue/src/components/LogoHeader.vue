<template> 
<div class="logoHeader">
  <router-link v-bind:to="{ name: 'home' }">
  <img class="logo" src="../../img/Logo.png" alt="logo" >
  <img class="name" src="../../img/name.png" alt="name">
  </router-link>
  <router-link id="logout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
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
    border-bottom: #47d7ac 0.5rem solid;
    padding-bottom: 1rem;
}
.logo{
  height: 150px;
}
.name{
  height: 100px;
}
#logout {
  
}
</style>
