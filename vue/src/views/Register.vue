<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <div id="registerButton">
      <button type="submit">Create Account</button>
      </div>
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
h1{
  color: #053484;
  font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif
}
.form-input-group {
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
  color: #053484;
  font: bold;  
}
form{
  height: fit-content;
 }

button{
  justify-content: center;
  width: 150px;
  height: 30px;
  border-radius: 6px;
  font-size: 16px;
  background-color:  #47d7ac;
  color: #053484;
  border: 3px solid #053484;
  transition-duration: 0.4s;
}
button:hover {
  background-color: #053484;
  border: 3px solid #47d7ac;
  color: white;
}
#register{
  display: flex;
  justify-content: center;  
  height: 100vh;
}
#registerButton{
  display: flex;
  justify-content: center;
  width: 100%;
  align-items: center;
  
}
</style>
