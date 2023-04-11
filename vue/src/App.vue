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
  --primary200: #daffe9;
  --primary400: #47d7ac;
  --primary600: #268598;
  --primary800: #053484;
}

</style>

