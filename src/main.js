import { createApp } from "vue";
import App from "./App.vue";
import router from "./utils/router";
import { Timer, Notebook, VideoPlay, Tickets } from "@element-plus/icons-vue";

import mockjs from "./utils/mock";

const app = createApp(App);

app.use(router);
app.component('timer', Timer);
app.component('notebook', Notebook);
app.component('video-play', VideoPlay);
app.component('tickets', Tickets);
app.mount("#app");
