<template>

  <div class="chat-window">
    <MessageList id="MG" :messages="messageView" />
    <MessageInput @sendMessage="handleSendMessage" />
  </div>
</template>

<script>
import MessageList from './MessageList.vue';
import MessageInput from './MessageInput.vue';
import axios from "axios";

let client
export default {
  components: {
    MessageList,
    MessageInput
  },
  data() {
    return {
      LoginID:'',
      LoginName:'',
      user:{},
      messages: [],
      messageView:[],
      fromUser:'',
      toUser:'',
      unRead:{},
      Friends:[],
    };
  },

  created() {
    this.LoginID = this.$route.query.LoginID;
    console.log(this.LoginID);

    axios({
      method: "POST",
      url: "/apd/link?login_userid="+this.LoginID,
    })
        .then(response=>{
          console.log(response.data);
          this.LoginName = response.data.user_name;
          console.log(this.LoginName);
        })
        .catch(error => {
          // 处理登录失败逻辑
          console.error(error);
        })

    // axios({
    //   method: "POST",
    //   url: "/apd/link/friends?id="+this.LoginID,
    // })
    //     .then(response=>{
    //       response.forEach(element => {
    //         this.Friends += element;
    //       })
    //       console.log(this.Friends);
    //     })
    //     .catch(error=>{
    //       console.error(error);
    //     })


  },

  mounted() {
    this.fromUser = this.LoginName;
    this.toUser = this.$store.Fri;
    console.log(this.fromUser+"::"+this.toUser);

    client = new WebSocket('ws://localhost:8088/serverSingle')
    client.onopen = () => {
      console.log('WebSocket Connection Open');

    }
    client.onclose = () => {
      console.log('WebSocket Connection Closed');
    }
    client.onmessage = (msg) => {
      if(msg.data) {
        let json = JSON.parse(msg.data);
        if(json.content && (json.send_user === this.fromUser && json.receive_user === this.toUser)
        ||json.receive_user === this.fromUser && json.send_user === this.toUser ) { //聊天信息

          this.messages.push(json);
          this.scrollToBottom() //底端滚动

        }

      }
    }

    //加载聊天消息
    this.load();


  },

  beforeUnmount() {
    if(client) {
      client.close()
    }
  },

  methods: {

    load() {

      axios.get('/Single?fromUser=' + this.fromUser + '&toUser=' + this.toUser).then(response => {
        if (response.code === 200) {
          this.messages = response.data;
          this.scrollToBottom()
        } else {
          this.$notify.error(response.message)
        }

        this.loadUnReadNums()

      })
          .catch(error => {
            // 处理登录失败逻辑
            console.log(error);
          })
      this.messages.forEach(item => {

        if(item.send_user === this.fromUser) {
          this.messageView.push({
            content: item.content,
            timestamp: new Date(),
            sender: 'me'
          });
        } else {
          this.messageView.push({
            content: item.content,
            timestamp: new Date(),
            sender: 'other'
          });
        }

      })
      
    },
    //
    // setUnReadNums() {
    //   axios.get('/Single?fromUser=' + this.fromUser + '&toUser' + this.toUser).then(response => {
    //     console.log(response);
    //     this.loadUnReadNums()
    //   })
    // },
    //
    loadUnReadNums() {
      axios.get('/Single/unReadNums?fromUser=' + this.fromUser + '&toUser' + this.toUser).then(response => {
        this.unRead = response.data;
      })
    },

    handleSendMessage(message) {
      let info = this.getMessgae(message)
      client.send(JSON.stringify(info));
      this.messageView.push({
        content: message,
        timestamp: new Date(),
        sender: 'me'
      });

    },

    getMessgae(message) {
      return {
        send_user:this.fromUser,
        receive_user:this.toUser,
        content:message,
        is_read:0
      }
    },

    scrollToBottom() {
      this.$nextTick(()=>{
        //设置聊天滚动到底部
        let imMessageBox = document.querySelector('#MG');
        imMessageBox.scrollTop = imMessageBox.scrollHeight;
        console.log('触发滚动');
      })
    },

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

.friends-list, .chat-window {
  margin: 0;
}

</style>
