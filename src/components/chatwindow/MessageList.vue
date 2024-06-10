<template>
  <div class="message-list">
    <div
        v-for="(message, index) in messages"
        :key="index"
        :class="['message', message.sender === 'me' ? 'sent' : 'received']"
    >
      <div class="message-content">{{ message.content }}</div>
      <div class="message-timestamp">{{ message.timestamp.toLocaleTimeString() }}</div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    messages: {
      type: Array,
      required: true
    }
  }
};
</script>

<style>
.message-list {
  flex: 1;
  overflow-y: auto;
  padding: 10px;
  background-color: #f0f0f0;
}
.message {
  margin: 10px 0;
  display: flex;
  flex-direction: column;
}
.message.sent {
  align-items: flex-end;
}
.message.received {
  align-items: flex-start;
}
.message-content {
  max-width: 60%;
  padding: 10px;
  border-radius: 10px;
  font-size: 20px;
  background-color: #e6e6e6;
}
.message.sent .message-content {
  background-color: #9fe8a0;
}
.message-timestamp {
  font-size: 0.8em;
  color: gray;
  margin-top: 5px;
}
</style>
