<template>
  <div id="register" class="text-center">
    <form @submit.prevent="register">
      <h1>Create Account</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input
          type="text"
          id="username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Confirm Password</label>
        <input
          type="password"
          id="confirmPassword"
          v-model="user.confirmPassword"
          required
        />
      </div>
      <div class="form-input-group">
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" v-model="user.firstName" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Last Name</label>
        <input type="text" id="lastName" v-model="user.lastName" required />
      </div>
      <div id="selectBox">
        <label for="userType">User Type</label>
        <select id="userType" v-model="user.title">
          <option value="Patient">Patient</option>
          <option value="Provider">Provider</option>
        </select>
        <div v-if="user.title === 'Provider'">
          <label for="office">Office</label>
          <select id="office" v-model="user.office">
            <option
              v-for="office in offices"
              :key="office.id"
              :value="office.id"
            >
              {{ office.name }}
            </option>
          </select>
        </div>
      </div>
      <div id="registerButton">
        <button type="submit">Create Account</button>
      </div>

      <p>
        <router-link :to="{ name: 'login' }"
          >Already have an account? Log in.</router-link
        >
      </p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
import officeService from "../services/OfficeService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        firstName: "",
        lastName: "",
        confirmPassword: "",
        role: "user",
        title: "",
        officeId: 1000,
      },
      offices: [],
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },

    officeList() {
      officeService.list().then((response) => {
        console.log(response.data);
        this.offices = response.data;
      });
    },
  },
  created() {
    this.officeList();
  },
};
</script>

<style scoped>
h1 {
  color: var(--primary800);
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
}
.form-input-group {
  margin-bottom: 1rem;
}
input {
  justify-content: center;
  width: 200px;
  height: 20px;
  font-family: Cambria, Cochin, Georgia, Times, "Times New Roman", serif;
}
label {
  margin-right: 0.5rem;
  display: block;
  text-align: center;
  color: var(--primary800);
  font: bold;
}
form {
  height: fit-content;
}

button {
  justify-content: center;
  width: 150px;
  height: 30px;
  border-radius: 6px;
  font-size: 16px;
  background-color: var(--primary400);
  color: var(--primary800);
  border: 3px solid var(--primary800);
  transition-duration: 0.4s;
}
button:hover {
  background-color: var(--primary800);
  border: 3px solid var(--primary400);
  color: white;
}
#register {
  display: flex;
  justify-content: center;
  height: 100vh;
}
#registerButton {
  display: flex;
  justify-content: center;
  width: 100%;
  align-items: center;
}
.selectBox {
  display: flex;
  justify-content: center;
}
select {
  justify-content: center;
  align-items: center;
  font-size: 16px;
  width: 150px;
  height: 25px;
  margin-bottom: 1rem;
}
</style>
