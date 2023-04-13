import axios from 'axios';

export default {
    
  list() {
    return axios.get('/provider');
  },

  get(id) {
    return axios.get(`/providers/${id}`);
  },



}