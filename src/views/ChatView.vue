<template>
  <div class="chat-view">
    <ChatWindow />
  </div>
</template>

<script>
import ChatWindow from '../components/ChatWindow.vue';

export default {
  components: {
    ChatWindow
  }
};
</script>

<style>
body {
  background-image: url("https://ts1.cn.mm.bing.net/th/id/R-C.00c281ad4920b9699ae18450eec18d70?rik=ypBNmHnhUwopoQ&riu=http%3a%2f%2fimg.pptjia.com%2fimage%2f20191127%2fc208c1006f45347f7b2b602baf3a2ed3.JPG&ehk=w6I%2fqsHWrsIiFYbO%2fg37RPRRjB1dXzfrEKcI0wsa8Qg%3d&risl=&pid=ImgRaw&r=0");

}
.chat-view {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
