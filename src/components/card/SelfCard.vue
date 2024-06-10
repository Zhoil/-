<template>

  <div v-if="SelfVis" id="main">
    <div class="card"></div>
    <div class="img"></div>
    <div class="article"><p>THE STORY</p></div>
    <div class="block"></div>
    <div class="headline"><h1>THE NOD</h1>by Kayo Chingonyi </div>
    <div class="para"><p>When we’re strangers that pass each other / in the street, it will come<br> down to this tilt / of the head — acknowledging another / version of<br> events set in a new-build / years from now, a mess of a place filled / with<br> books and records, our kids thick as thieves / redefining all notions of<br> mischief. <br>
      Perhaps our paths will cross in a city / of seven hills as the light draws<br> your face / out from the bliss of anonymity. / Maybe you’ll be stroking the<br> goose-down nape / of a small child with eyes the exact shade / of those I<br> met across a room at the startof this pain-in-the-heart, this febrile<br> dance. </p></div>
    <div id="dot"></div>

    <div class="modal-footer">
      <button @click="closeCard">Back</button>
    </div>

  </div>

</template>

<script>
export default {
  name: 'SelfCard',
  data() {
    return {
      SelfVis: true
    };
  },
  methods: {
    closeCard() {
      this.SelfVis = false;
      this.$emit('close');
    }
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
  z-index: 1;
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
  left: 44%;
  transform: translateX(20%) translateY(-20%);
  text-align: center;
  font-family: 'Playfair Display', serif;
  font-size: 10px;
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
  content: "2437537088";
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