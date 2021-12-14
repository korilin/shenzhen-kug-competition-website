import { createStore } from "vuex";

const store = createStore({
    state() {
        return {
            user: null,
            seminarRecords: null,
            seminarNow: null,
        };
    },
    mutations: {
        updateSeminarRecords(state, seminars) {
            state.seminarRecords = seminars;
        },
        updateSeminarNow(state, seminar) {
            state.seminarNow = seminar;
        },
    },
});

export default store;
