<template>
  <div class="container">
    <h2>Book an Appointment</h2>
    <div class="form-element">
        <label>Provider:</label>
        <div>{{ $route.params.providerName }}</div>
        
        <label>Date:</label>
        <div>{{ appointmentDateTime }}</div>
        <div>{{ $route.params.date }}</div>

      <label for="name">Appointment Type:</label>
            <select id="name" v-model="newAppointment.name">
          <option value="check-up">Wellness Check-Up</option>
          <option value="follow-up">Follow-Up</option>
          <option value="symptoms">Specific Symptoms</option>
          <option value="vaccination">Vaccination</option>
          <option value="other">Other</option>
      </select>
      <label for="agenda">Appointment Agenda:</label>
      <textarea id="agenda" v-model="newAppointment.agenda"></textarea>
    </div>
    <div class="button-container">
      <button class="submit-button" @click="submitAppointment">Book</button>
      <button class="cancel-button" v-on:click="onCancel()" type="button">
        Cancel
      </button>
    </div>
  </div>
</template>

<script>
import AptService from '../services/AptService';
import { format } from "date-fns";

export default {
  name: "appointmentForm",
  props: ["appointmentDateTime"],
  data() {
    return {
      newAppointment: {
        status: "Ongoing",
        name: "",
        agenda: "",
        providerId: 2001,
        date: ""
      },
    };
  },
  computed: {
    formattedDateTime() {
      return format(this.appointmentDateTime, );
    }
  },
  methods: {
    submitAppointment() {
      this.newAppointment.date = this.appointmentDateTime;
      AptService.create(this.newAppointment)
        .then(() => {
            
        })
        .catch((error) => {
            // TODO: Add error message
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  background-color: #fff;
  padding: 20px;
  border-radius: 4px;
  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.2);
  margin-bottom: 20px;
  max-width: 600px;
  margin: auto;
  padding: 20px;
}

h2 {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
}

.form-element {
  margin-bottom: 20px;
}

label {
  font-size: 16px;
  font-weight: bold;
  margin-right: 20px;
}

input[type="text"],
select,
textarea {
  font-size: 16px;
  padding: 8px;
  border-radius: 4px;
  border: 1px solid #ddd;
  width: 100%;
  box-sizing: border-box;
  margin-top: 5px;
}

textarea {
  height: 150px;
}

button {
  font-size: 16px;
  padding: 10px 20px;
  border-radius: 4px;
  border: none;
  cursor: pointer;
}
.button-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
  padding: 0 10px;
}
.submit-button {
  background-color: #268598;
  color: #111;
  font-weight: bold;
  margin-left: 10px;
  width: 20%;
  justify-content: center;
}

.submit-button:hover {
  background-color: #daffe9;
}

.cancel-button {
  background-color: #ddd;
  color: #333;
  width: 20%;
}
.cancel-button:hover {
  background-color: #daffe9;
  margin-left: 10px;
}
label {
  margin-top: 4rem;
}
</style>