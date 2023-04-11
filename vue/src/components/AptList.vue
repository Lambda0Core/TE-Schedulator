<template>
  <div class="Apt-list">
    <table>
      <tbody>
        <tr v-for="apt in this.$store.state.apt" v-bind:key="apt.id">
          <td width="80%">
            <router-link
              v-bind:to="{ name: 'Home', params: { id: apt.id } }"
            >{{ topic.title }}</router-link>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import AptService from "../services/AptService.js";

export default {
  name: "apt-list",
  methods: {
    get() {
    AptService
    this.getTopics();
        }
      }
  }
</script>