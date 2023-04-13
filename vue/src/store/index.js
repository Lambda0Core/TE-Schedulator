import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    userType: 'patient',
    patientSidebarOptions: [
      {
        title: "Home",
        icon: "heart-pulse-solid.svg",
        link: "/"
      },
      {
        title: "Appointments",
        icon: "calendar-regular.svg",
        link: "appointments"
      },
      {
        title: "Find a Provider",
        icon: "briefcase-medical-solid.svg",
        link: "find-a-provider"
      },
      {
        title: "My Doctors",
        icon: "user-doctor-solid.svg",
        link: "my-doctors"
      }
    ],
    providerSidebarOptions: [
      {
        title: "Schedule",
        icon: "calendar-regular.svg",
        link: "provider-calendar"
      },
      {
        title: "Patients",
        icon: "heart-pulse-solid.svg",
        link: "provider-mypatients"
      },
      {
        title: "Reviews",
        icon: "star-solid.svg",
        link: "provider-reviews"
      },
      {
        title: "Office",
        icon: "hospital-solid.svg",
        link: "provider-office"
      }
    ],
    content: ""
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    SET_USER_TYPE(state, type) {
      state.userType = type;
      localStorage.setItem('user-type',JSON.stringify(type));
    },
    SET_CONTENT_PAGE(state, contentName) {
      state.content = contentName;
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    }
  }
})
