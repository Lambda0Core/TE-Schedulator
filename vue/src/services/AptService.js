import axios from 'axios';

export default {
    
  list() {
    return axios.get('/appointment');
  },

  get(id) {
    return axios.get(`/appointment/${id}`);
  },

  getAppointmentsByPatientId(userId) {
    return axios.get(`patient/appointment/${userId}`);
  },

  getAppointmentsByProviderId(providerId) {
    return axios.get(`patient/appointment/${providerId}`);
  },

  create(id) {
    return axios.put(`/appointment/${id}`);
  }


}