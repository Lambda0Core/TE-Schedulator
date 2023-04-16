import axios from 'axios';

export default {
    
  list() {
    return axios.get('/office');
  },

  get(id) {
    return axios.get(`/office/${id}`);
  },

  getOfficeByProvider() {
    return axios.get('/myOffices')
  },
  getOfficeByDetailsId(detailsId) {
    return axios.get(`details/office/${detailsId}`);
  },
  updateOfficeForProvider(office) {
    return axios.put('/updateOffice', office)
  }
// add method on back-end
  // updateOfficeByDetailsId(detailsId) {
  //   return axios.put(`details/office/${detailsId}`);
  // }
}