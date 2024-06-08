import { createApp } from 'vue'
import App from './App.vue'

import axios from 'axios';
import router from "@/router/index.js";
import { createPinia } from 'pinia'

axios.defaults.baseURL = 'http://127.0.0.1:8088';

const app = createApp(App);

app.use(router,createPinia()).mount('#app');

