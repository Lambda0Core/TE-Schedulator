import axios from 'axios';

export default {
    
  list() {
    return axios.get('/details');
  },

  get(id) {
    return axios.get(`/details/${id}`);
  },



}