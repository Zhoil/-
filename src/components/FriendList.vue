<template>
  <div class="friend-list">
    <h2>Friends</h2>
    <ul>
      <li v-for="(friend, index) in friends" :key="index" @click="selectFriend(friend)">
        {{ friend.name }}
      </li>
    </ul>
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

export default {
  components: {CustomAlert},
  data() {
    return {
      friends: [
        { name: 'Alice' },
        { name: 'Bob' },
        { name: 'Charlie' },
        { name: 'David' },
        { name: 'David' }
      ],
      alertVisible: false,
      alertTitle: '',
      alertMessage: '',
      loading: false,
      loadingTime: 1100 // 设置加载时间
    };
  },
  methods: {
    selectFriend(friend) {
      this.showAlert('Loading', '', true);
      setTimeout(() => {
        this.updateAlert('Success', friend.name, false);
      }, this.loadingTime);

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
  width: 250px;
  border-right: 1px solid #ccc;
  padding: 10px;
  background-color: #fff;
  max-height: fit-content;
  overflow-y: auto; /* 添加垂直滚动 */
}
.friend-list h2 {
  margin-top: 0;
}
.friend-list ul {
  list-style: none;
  padding: 0;
}
.friend-list li {
  padding: 10px 0;
  cursor: pointer;
}
.friend-list li:hover {
  background-color: #f0f0f0;
}
</style>
