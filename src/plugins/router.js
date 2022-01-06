import HomePage from "../pages/HomePage.vue";
import AuthPage from "../pages/AuthPage.vue";
import Policies from "../pages/Policies.vue"
import Seminars from "../pages/seminar/Seminars.vue";
import Conquerors from "../pages/conquerors/Conquerors.vue";
import Playground from "../pages/conquerors/Playground.vue";
import NotFound from "../pages/404.vue"
import { createRouter, createWebHistory } from "vue-router";

const routes = [
    { path: "/auth", component: AuthPage },
    { path: "/", component: HomePage },
    { path: "/policies", component: Policies },
    { path: "/seminars", component: Seminars },
    { path: "/playground", component: Playground },
    { path: "/conquerors", component: Conquerors },
    { path: "/:pathMatch(.*)", component: NotFound }
];

const router = createRouter({
    // 4. Provide the history implementation to use. We are using the hash history for simplicity here.
    history: createWebHistory(),
    routes, // short for `routes: routes`
});

export default router;
