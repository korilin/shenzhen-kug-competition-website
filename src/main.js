import { createApp } from "vue";
import App from "./App.vue";
import router from "./lib/router";

import mockjs from "./mock";

const app = createApp(App);

app.use(router);
app.mount("#app");
