import Keycloak from "keycloak-js";
/**
 * Provides utility functions.
 * @module
 */

 const _MS_PER_DAY : number = 1000 * 60 * 60 * 24;
 const MONTH_IN_DAYS : number = 30.417;
 const SEMESTER_IN_MONTHS : number = 6;
 
 /**
  * Create the HTTP request headers with the given user instance.
  * @param {Object} user - User instance.
  * @return {{headers: {Authorization: string}}} The appropriate HTTP request headers.
  */
 function getRequestHeaders(user : Keycloak.KeycloakInstance) {
     return {
         headers: {
             Authorization: 'Bearer ' + user.token
         }
     };
 }
 
 /**
  * Calculates the current semester of the student based on the creation timestamp of the RZ account.
  * Source: https://stackoverflow.com/questions/3224834/get-difference-between-2-dates-in-javascript
  * @param {string} creationTimestamp Creation timestamp of the account.
  * @return {number}
  */
 function calculateSemester(creationTimestamp : string) {
     // Discard the time and time-zone information.
     const s = new Date(`${creationTimestamp.substring(0, 4)}-${creationTimestamp.substring(4, 6)}-${creationTimestamp.substring(6, 8)}`);
     const utc1 : number = Date.UTC(s.getFullYear(), s.getMonth(), s.getDate());
     const currentDate = new Date();
     const utc2 : number = Date.UTC(currentDate.getFullYear(), currentDate.getMonth(), currentDate.getDate());
 
     const diffInDays : number = Math.floor((utc2 - utc1) / _MS_PER_DAY);
     const diffInMonths : number = Math.floor(diffInDays / MONTH_IN_DAYS);
     return Math.floor(diffInMonths / SEMESTER_IN_MONTHS) + 1; // increment to get current semester
 }
 
 export {
     calculateSemester,
     getRequestHeaders
 };
 