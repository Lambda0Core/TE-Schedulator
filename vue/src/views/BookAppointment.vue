<template>
  <div>
    <appointment-form v-if="mode == 'form'" :appointmentDateTime="dateTime"/>
    <date-time-picker v-show="mode == 'datetime'" @submitDateTime="handleSubmitDateTime"/>
  </div>
</template>

<script>
import AppointmentForm from '../components/AppointmentForm.vue';
import DateTimePicker from "../components/DateTimePicker.vue";
export default {
  data() {
    return {
      mode: "datetime",
      dateTime: ""
    };
  },
  methods: {
    handleSubmitDateTime(data) {
      this.dateTime = data.message;
      this.mode = "form";
    }
  },
  components: {
    DateTimePicker,
    AppointmentForm,
  },
};
</script>

<style>
</style>