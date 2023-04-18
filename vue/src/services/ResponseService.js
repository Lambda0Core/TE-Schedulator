import axios from 'axios';

export default {

  list() {
    return axios.get(`/response`)
  },
<<<<<<< HEAD
  getById(id) {
    return axios.get(`/response/${id}`)
  },
  getByIdDetails() {
    return axios.get(`/response`)
  }
=======
  create(response) {
   
    return axios.post('/response', response)
  },
  get(id) {
    return axios.get(`review/response/${id}`)
  },

>>>>>>> 8f10f2c975a4fb401dfedda14d5c08dce71359df
}
