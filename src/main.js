import { createApp } from "vue";
import App from "./App.vue";

import { Timer, Notebook, VideoPlay, Tickets } from "@element-plus/icons-vue";

import store from "./plugins/store";
import router from "./plugins/router";

import mockjs from "./utils/mock";

const app = createApp(App);

app.use(router);
app.use(store);
app.component("timer", Timer);
app.component("notebook", Notebook);
app.component("video-play", VideoPlay);
app.component("tickets", Tickets);
app.mount("#app");