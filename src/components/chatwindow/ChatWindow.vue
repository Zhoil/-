<template>
  <div class="chat-window">
    <MessageList :messages="messages" />
    <MessageInput @sendMessage="handleSendMessage" />
  </div>
</template>

<script>
import MessageList from './MessageList.vue';
import MessageInput from './MessageInput.vue';

export default {
  components: {
    MessageList,
    MessageInput
  },
  data() {
    return {
      messages: []
    };
  },
  methods: {
    handleSendMessage(message) {
      this.messages.push({
        content: message,
        timestamp: new Date(),
        sender: 'me'
      });
    }
  },
  receiveMessage(content) {
    this.messages.push({
      content: content,
      timestamp: new Date(),
      sender: 'other'
    });
  }
};
</script>

<style>

.chat-window {
  display: flex;
  flex-direction: column;
  height: 90vh;
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  border: 1px solid #ccc;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

</style>
