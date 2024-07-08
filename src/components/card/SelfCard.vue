<template>

  <div v-if="SelfVis" id="main">
    <div class="card"></div>
    <div class="img"></div>
    <div class="article"><p>THE STORY</p></div>
    <div class="block"></div>
    <div class="headline" :data-content="content"><h1>{{ title }}</h1>by {{ name }} </div>
    <div class="para" contenteditable="true" ><p>{{ TextContent }}</p></div>
    <div id="dot"></div>

    <div class="modal-footer">
      <button @click="closeCard">Back</button>
    </div>

  </div>

</template>

<script>
export default {
  name: 'SelfCard',
  props: {

    name: {
      type: String,
      default: 'Alert'
    },
    TextContent: {
      type: String,
      required: true
    },
    title: {
      type: String,
      default: 'Alert'
    }

  },

  created() {
    this.content = this.$route.query.LoginID;
  },

  data() {
    return {
      content: '',
      SelfVis: true,
    };
  },
  methods: {

    closeCard() {
      this.SelfVis = !this.SelfVis;
      this.$emit('close');
    }

  },
  watch: {
    content(newValue) {
      document.documentElement.style.setProperty('--content', `"${newValue}"`);
    }
  },

  mounted() {
    document.documentElement.style.setProperty('--content', `"${this.content}"`);
  }
};

</script>

<style scoped>

.modal-footer {
  text-align: right;
}

.modal-footer button {
  padding: 10px 20px;
  border: none;
  background-color: #007bff;
  color: white;
  border-radius: 5px;
  cursor: pointer;
}

.modal-footer button:hover {
  background-color: #0056b3;
}

html, body {
  overflow: hidden;
  background: #CCB7B0;
}
#main {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateX(-50%) translateY(-50%);
  z-index: 2;
  animation: fadeIn 1.5s ease-in;
}

.card {
  height: 550px;
  width: 900px;
  background: #FFFFFF;
}
.img {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateX(-100%) translateY(-50%);
  height: 550px;
  width: 450px;
  background-image: url(https://www.retrorenovation.com/wp-content/uploads/2014/09/retro-botanical-barkcloth22.jpg
  );
  background-size: contain;
  background-repeat: repeat;
}
.headline {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateX(100%) translateY(-150%);
  text-align: center;
  font-family: 'Playfair Display SC', serif;
}
.para {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateX(20%) translateY(-20%);
  text-align: center;
  font-family: 'Playfair Display', serif;
  font-size: 20px;
}
#dot {
  position: absolute;
  height: 100px;
  width: 200px;
  top: 43%;
  left: 50%;
  transform: translateX(140%) translateY(200%);
  background-image: url(http://www.appladesign.net/domains/create/documents/dots_266.png);
  background-size: contain;
  background-repeat: repeat;
  z-index: 2;
}
#dot:before {
  content: "";
  position: absolute;
  height: 200px;
  width: 100px;
  top: 50%;
  left: 50%;
  transform: translateX(-850%) translateY(-280%);
  background-image: url(http://www.appladesign.net/domains/create/documents/dots_266.png);
  background-size: contain;
  background-repeat: repeat;
}
.article {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateX(35%) translateY(-510%);
  text-align: center;
  font-family: 'Playfair Display SC', serif;
}
.article:before {
  content: "NEXT";
  position: absolute;
  height: 200px;
  width: 100px;
  top: 50%;
  left: 50%;
  transform: translateX(-75%) translateY(240%);
}
.article:after {
  content: var(--content);
  position: absolute;
  height: 200px;
  width: 100px;
  top: 50%;
  left: 50%;
  transform: translateX(280%) translateY(-5%);
  font-weight: bold;
}
.block {
  background: grey;
  opacity: .5;
  position: absolute;
  height: 5px;
  width: 200px;
  top: 5%;
  left: 65%;
}
.block:before {
  content: "";
  background: grey;
  opacity: .5;
  position: absolute;
  height: 5px;
  width: 80px;
  top: 500px;
  left: -145px;
}
/* Keyframes */

@keyframes fadeIn {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}

</style>