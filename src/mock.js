import mockjs from "mockjs";
import APIs from "./lib/apis";

const random = mockjs.Random;

// test
const mockTest = function () {
    return "mock test";
};

mockjs.mock("/mock/test", mockTest);

// get

const getSeminars = function () {
    let seminars = [];
    for (let i = 0; i < 20; i++) {
        seminars.push({
            seminarId: i,
            title: random.cparagraph(7, 15),
            description: random.cparagraph(30, 100),
            eventTime: random.date,
        });
    }
    return seminars;
};

mockjs.mock(APIs.seminar_all, getSeminars);

export default mockjs;
