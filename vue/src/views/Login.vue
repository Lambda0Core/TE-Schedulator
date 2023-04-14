<template> 
  <div id="login">
   <div>
    <form @submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div id="signInButton">
      <button type="submit">Sign in</button>
      </div>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
    </div>
  </div>
</template>

<script>

import authService from "../services/AuthService";


export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            console.log("LoginResponseDTO:");
            console.log(response.data);
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            if (response.data.provider) {
              console.log("Type = Provider");
              this.$store.commit("SET_USER_TYPE", "provider");
            } else {
              console.log("Type = Patient");
              this.$store.commit("SET_USER_TYPE", "patient");
            }
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

.form-input-group {
  justify-content: center;
  margin-bottom: 1rem;
}
input{
 justify-content: center; 
   width: 200px;
  height: 20px;
  font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif
}
label {
  margin-right: 0.5rem;
  display: block;
  text-align: center;
  color: var(--primary800);
  font: bold;
 
}
h1{
  color: var(--primary800);
  font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif
}
#login{
  display: flex;
  justify-content: center;  
  height: 100vh;
  
}
form{
  height: fit-content;
   
}
button{
  justify-content: center;
  width: 100px;
  height: 30px;
  border-radius: 6px;
  font-size: 16px;
  background-color:  var(--primary400);
  color: var(--primary800);
  border: 3px solid var(--primary800);
  transition-duration: 0.4s;
}
button:hover {
  background-color: var(--primary800);
  border: 3px solid var(--primary400);
  color: white;
}
#signInButton{
  display: flex;
  justify-content: center;
  width: 100%;
  align-items: center;
  
}

p{
  justify-content: center;
  
}
</style>