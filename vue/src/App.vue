<template>
  <div id="app">
    <logo-header/>
    <div id="nav">      
      
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>
<script>
import logoHeader from "./components/LogoHeader.vue";

export default ({
  components:{
    logoHeader,
  },
  
  setup() {
    
  },
})
</script>
<style>
#app{
  width: 100vw;
  height: 100vh;
}

</style>

