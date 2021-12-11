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
    for (let i = 15; i > 0; i--) {
        seminars.push({
            seminarId: i,
            title: "第" + i + "期 Thematic Seminar",
            theme: random.ctitle(),
            description: random.sentence(30, 50),
            eventTime: new Date().getTime(),
            bilibiliUrl: "https://www.bilibili.com/video/BV1K3411t7Uy",
        });
    }
    return seminars;
};

mockjs.mock(APIs.seminar_all, getSeminars);

export default mockjs;
