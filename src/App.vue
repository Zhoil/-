<!-- App.vue -->
<template>
  <div id="app">
<!--    <transition name="fade" mode="out-in">-->
<!--      <router-view v-if="!loading" key="$route.fullPath"></router-view>-->
<!--    </transition>-->
    <transition name="fade" mode="out-in">
      <router-view v-if="!loading" key="$route.fullPath"></router-view>
    </transition>
    <ThreeBody v-if="loading" />
  </div>
</template>

<script>
import ThreeBody from "./components/AlertAll/VueSlot.vue";

export default {
  name: "App",
  components: {
    ThreeBody,
  },


  data() {
    return {
      loading: false,
    };
  },

  methods: {
    showLoadingEffect() {
      this.loading = true;
      setTimeout(() => {
        this.loading = false;
      }, 2000); // 设置加载效果显示的时间
    },
  },

  // created() {
  //   this.$router.beforeEach((to, from, next) => {
  //     this.loading = true; // 显示加载效果
  //     next();
  //   });
  //
  //   this.$router.afterEach(() => {
  //     setTimeout(() => {
  //       this.loading = false; // 隐藏加载效果
  //     }, 1000); // 设置加载效果显示的时间
  //   });
  // },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}
.fade-enter-active, .fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to {
  opacity: 0;
}
</style>
