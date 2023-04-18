import axios from 'axios';

export default {

  list() {
    return axios.get(`/response`)
  },
  getById(id) {
    return axios.get(`/response/${id}`)
  },
  getByIdDetails() {
    return axios.get(`/response`)
  }
}
