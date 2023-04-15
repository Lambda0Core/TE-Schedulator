import axios from 'axios';

export default {

  list() {
    return axios.post(`/response`)
  }
}
