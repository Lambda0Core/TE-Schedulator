<template>
  <div>
    <div class="row-layout">
      <div class="row sticky">
        <div class="cell header label"><div>Time</div></div>
        <div class="cell header"><div>Monday</div></div>
        <div class="cell header"><div>Tuesday</div></div>
        <div class="cell header"><div>Wednesday</div></div>
        <div class="cell header"><div>Thursday</div></div>
        <div class="cell header"><div>Friday</div></div>
        <div class="cell header"><div>Saturday</div></div>
        <div class="cell header"><div>Sunday</div></div>
      </div>
      <div class="row" v-for="row in rows" v-bind:key="row">
        <div class="cell label">
          {{ row.time }}
        </div>
        <div class="cell" v-for="cell in row.cells" v-bind:key="cell">
          <div class="apt" v-show="cell.appointment">Appointment</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import OfficeService from "../services/OfficeService";
import UserDetailsService from "../services/UserDetailsService";

import { startOfWeek, addDays, getDayOfYear, getHours, getMinutes } from "date-fns";
import AptService from '../services/AptService';

export default {
  name: "calendar",
  data() {
    return {
      provider: {},
      office: {},
      appointments: {},
      rows: {}
    }
  },
  methods: {
    buildCalendarByDate(dateInput) {
      let date = startOfWeek(new Date(dateInput));
      console.log("----");
      console.log(this.provider);
      console.log(this.office);
      let openTime = this.convertTimeToInt(this.office.openTime);
      let closeTime = this.convertTimeToInt(this.office.closeTime);
      this.baseDate = date;
      const rows = [];
      for (let i = openTime; i <= closeTime; i++) {
        let newRow = {};
        newRow.time = this.getSlotAsString(i);
        newRow.cells = [];
        for (let j = 0; j < 7; j++) {
          const thisDate = addDays(date,i);
          const newCell = {};
          this.appointments.forEach( (appointment) => {
            if (getDayOfYear(appointment.date) == getDayOfYear(thisDate)
            && getHours(appointment.date) == this.parseTimeSlotHours(thisDate) &&
            getMinutes(appointment.date) == this.parseTimeSlotMinutes(thisDate)) {
              newCell.appointment = appointment;
            }
          });
          newRow.cells.push(newCell);
        }
        rows.push(newRow);
      }
      
      this.rows = rows;
    },
    convertTimeToInt(timeString) {
      const splitString = timeString.split(":");
      let time = Number(splitString[0]);
      if (timeString.includes("PM") && !splitString[0] != "12") {
        time = time + 12;
      }
      time = time * 2;
      if (!splitString[1].includes("00")) time = time + 1;
      return time;
    },
    parseTimeSlotHours(timeSlot) {
      timeSlot = timeSlot / 2;
      if (timeSlot % 1 == 0.5)
        timeSlot = timeSlot - 0.5;
      return timeSlot;
    },
    parseTimeSlotMinutes(timeSlot) {
      timeSlot = timeSlot / 2;
      if (timeSlot % 1 == 0.5)
        return 30;
      else
        return 0;
    },
    setup() {
      UserDetailsService.getCurrent().then((response) => {
        console.log("ProviderService call data: ");
        console.log(response);
        console.log(response.data);
        this.provider = response.data;
        OfficeService.get(this.provider.officeId).then((response) => {
          this.office = response.data;
          AptService.listByMonth(4, 2023).then((response) => {
            this.appointments = response.data;

            this.buildCalendarByDate(new Date(2023, 3, 16));
          });
        });
      });
    },
    getSlotAsString(slot) {
      slot = slot / 2;
      let abbreviation = "AM";
      if (slot >= 12) {
        abbreviation = "PM";
      }
      if (slot >= 13) {
        slot = slot - 12;
      }

      if (slot % 1 == 0.5) {
        slot = slot - 0.5;
        return slot + ":30 " + abbreviation;
      } else {
        return slot + ":00 " + abbreviation;
      }
    },
  },
  created() {
    this.setup();
  },
};
</script>

<style scoped>
.row-layout {
  display: flex;
  flex-direction: column;
}
.row {
  display: flex;
}
.row:nth-child(odd) {
  border-bottom: 2px solid var(--neutral400);
}
.sticky {
  position: sticky;
  top: 0px;
}
.label > div {
  font-size: 1.3rem;
  color: var(--neutral600);
}
.cell {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 3.25rem;
  border: 1px solid var(--neutral400);
}
.cell:nth-child(even) {
  background: var(--neutral200);
}
.cell:has(.apt) {
  display: block;
}
.header {
  text-align: center;
  font-size: 1.3rem;
  height: 2rem;
  color: var(--neutral800);
  background: white;
  border: none;
  border-left: 1px solid var(--neutral400);
  border-right: 1px solid var(--neutral400);
  border-bottom: 2px solid var(--neutral400);
}
.header:nth-child(even) {
  background: white;
}
.fixed {
  height: 100%;
  margin: 0;
  padding: 0;
  overflow-y: auto;
  height: 200px;
}
.borderhack {
  border: 2px solid var(--primary400);
  padding: 1rem 2rem;
}
th {
  display: none;
  position: sticky;
  top: 0px;
  padding: 0;
  font-weight: bold;
  font-size: 1.2rem;
  border: 2px solid var(--primary400);
  color: var(--primary600);
  background-color: white;
  text-align: left;
}
table {
  width: 100%;
  border-collapse: collapse;
}
td,
th {
  margin: 0;
}
td {
  padding: 0.5rem 2rem;
  font-size: 1.2rem;
  color: var(--primary600);
  border: 2px solid var(--primary400);
}
.content {
  padding: 0;
}
.apt {
  height: 100%;
  padding: 0.5rem;
  margin: 0;
  background-color: var(--primary600);
  color: var(--primary200);
  border-radius: 0.5rem;
  box-sizing: border-box;
}
.label {
  border-right-width: 3px;
}
</style>