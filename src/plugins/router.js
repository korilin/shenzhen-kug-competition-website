import HomePage from "../pages/HomePage.vue";
import AuthPage from "../pages/AuthPage.vue";
import Seminars from "../pages/Seminars.vue";
import Conquerors from "../pages/Conquerors.vue";
import NotFound from "../pages/404.vue"
import { createRouter, createWebHistory } from "vue-router";

const routes = [
    { path: "/auth", component: AuthPage },
    { path: "/", component: HomePage },
    { path: "/seminars", component: Seminars },
    { path: "/seminar", component: Seminars },
    { path: "/conquerors", component: Conquerors },
    { path: "/:pathMatch(.*)", component: NotFound }
];

const router = createRouter({
    // 4. Provide the history implementation to use. We are using the hash history for simplicity here.
    history: createWebHistory(),
    routes, // short for `routes: routes`
});

export default router;
