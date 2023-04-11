import axios from 'axios';

export default {
    
  list() {
    return axios.get('/office');
  },

  get(id) {
    return axios.get(`/office/${id}`);
  }
}