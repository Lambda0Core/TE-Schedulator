import axios from 'axios';

export default {
    
  list() {
    return axios.get('/office');
  },

  get(id) {
    return axios.get(`/office/${id}`);
  },
// add method on back-end
  getOfficeByDetailsId(detailsId) {
    return axios.get(`details/office/${detailsId}`);
  },
// add method on back-end
  updateOfficeByDetailsId(detailsId) {
    return axios.put(`details/office/${detailsId}`);
  }
}