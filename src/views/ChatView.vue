<template>
  <div class="chat-view">
    <FriendList class="friends-list"/>
    <ChatWindow class="chats-window"/>
  </div>
</template>

<script>
import ChatWindow from '../components/chatwindow/ChatWindow.vue';
import FriendList from "@/components/FriendList.vue";

export default {
  components: {
    FriendList,
    ChatWindow
  }
};
</script>

<style>
body {
  background-image: url("https://pic3.zhimg.com/v2-00a377c955d03af65b7e31bda6e8b5a1_r.jpg?source=1940ef5c");
}

.chat-view {
  display: flex;
  justify-content: center;
  align-items: flex-start;

}

.friends-list, .chats-window {
  margin: 0;
}
</style>
