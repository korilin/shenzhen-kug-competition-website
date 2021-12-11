import HomePage from "../pages/HomePage.vue";
import AuthPage from "../pages/AuthPage.vue";
import SeminarPage from "../pages/SeminarPage.vue";
import Competitions from "../pages/Competitions.vue";
import { createRouter, createWebHistory } from "vue-router";

const routes = [
    { path: "/auth", component: AuthPage },
    { path: "/", component: HomePage },
    { path: "/seminar", component: SeminarPage },
    { path: "/competitions", component: Competitions },
];

const router = createRouter({
    // 4. Provide the history implementation to use. We are using the hash history for simplicity here.
    history: createWebHistory(),
    routes, // short for `routes: routes`
});

export default router;
