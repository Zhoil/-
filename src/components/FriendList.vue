<template>
  <div class="friend-list">
    <h2>Friends List</h2>
    <ul>
      <li v-for="(friend, index) in friends" :key="index" @click="selectFriend(friend)">
        {{ friend.name }}
      </li>
    </ul>

    <div class="InputContainer">
      <input placeholder="Search.." id="input" class="input" name="text" type="text" v-model="searchText">
      <input class="button--submit" value="Subscribe" type="submit" @click="subscribeButton">
    </div>

  </div>
  <CustomAlert
      v-if="alertVisible"
      :title="alertTitle"
      :message="alertMessage"
      :loading="loading"
      @close="alertVisible = false"
  />
</template>

<script>
import CustomAlert from "@/components/CustomAlert.vue";
import axios from "axios";

export default {
  components: {CustomAlert},
  data() {
    return {
      friends: [
        { name: 'Alice' },
        { name: 'Bob' },
        { name: 'Charlie' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' },
        { name: 'David' }
      ],
      searchText:'',
      alertVisible: false,
      alertTitle: '',
      alertMessage: '',
      loading: false,
      loadingTime: 600 // 设置加载时间
    };
  },
  methods: {
    // selectFriend(friend) {
    //   this.showAlert('Loading', '', true);
    //   setTimeout(() => {
    //     this.updateAlert('Success', friend.name, false);
    //   }, this.loadingTime);
    //
    // },
    subscribeButton(){
      if (this.searchText) {
        this.showAlert('Loading', '', true);

        setTimeout(() => {
          axios.get(`http://127.0.0.1:8088/api/login/${this.searchText}`)
              .then(response => {
                if (response.data === 'OK') {
                  this.updateAlert('Success', 'Subscribed successfully', false);
                } else {
                  this.updateAlert('Error', 'No searching user', false);
                }
              })
              .catch(error => {
                this.updateAlert('Error', `There was an error! ${error}`, false);
                console.error('There was an error!', error);
              });
        }, this.loadingTime);
      } else {
        this.showAlert('Error', 'Please enter text to subscribe.', false);
      }
    },
    showAlert(title, message, loading) {
      this.alertTitle = title;
      this.alertMessage = message;
      this.loading = loading;
      this.alertVisible = true;
    },
    updateAlert(title, message, loading) {
      this.alertTitle = title;
      this.alertMessage = message;
      this.loading = loading;
    },
  }
};
</script>

<style>
.friend-list {
  opacity: 0.7;
  width: 320px;
  border-right: 1px solid #ccc;
  padding: 10px;
  background-color: #fff;

}
.friend-list h2 {
  color: #007bff;
  border-bottom: 1px solid #45a049;
  margin-top: 0;
}
.friend-list ul {
  list-style: none;
  padding: 0;
  max-height: 75.8vh;
  overflow-y: auto; /* 添加垂直滚动 */
}
.friend-list li {
  padding: 10px 0;
  display: flex;
  margin-bottom: 18px;
  background-color: darkseagreen;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  animation: slideIn 1.0s ease;
}
.friend-list li:hover {
  background-color: #f0f0f0;
}

/* *************************************** */

.button--submit {
  min-height: 50px;
  padding: .5em 1em;
  border: none;
  border-radius: 0 6px 6px 0;
  background-color: #5e4dcd;
  color: #fff;
  font-size: 15px;
  cursor: pointer;
  transition: background-color .3s ease-in-out;
}
.button--submit:hover {
  background-color: #5e5dcd;
}
.InputContainer {
  margin-bottom: 9px;
  animation: slideIn 1.0s ease;

  z-index: 1;
  position: sticky;
  width: 314px;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  background: linear-gradient(to bottom,rgb(227, 213, 255),rgb(255, 231, 231));
  border-radius: 30px;
  overflow: hidden;
  cursor: pointer;
  box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.075);
}

.input {
  width: 200px;
  height: 40px;
  border: none;
  outline: none;
  caret-color: rgb(255, 81, 0);
  background-color: rgb(255, 255, 255);
  border-radius: 30px;
  padding-left: 15px;
  letter-spacing: 0.8px;
  color: rgb(19, 19, 19);
  font-size: 13.4px;
}

/* *************************************** */

</style>
