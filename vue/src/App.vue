<template>
  <div id="app">
    <logo-header/>
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

