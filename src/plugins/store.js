import { createStore } from "vuex";

const store = createStore({
    state() {
        return {
            user: null,
            seminarRecords: [],
            seminarNow: null,
        };
    },
    mutations: {
        addSeminarRecord(state, record) {
            state.seminarRecords.push(record);
        },
    },
});

export default store;
