import mockjs from "mockjs";
import APIs from "./apis";

const random = mockjs.Random;

// test
const mockTest = function () {
    return "mock test";
};

mockjs.mock("/mock/test", mockTest);

// get

const getSeminarRecords = function () {
    let seminars = [];
    for (let i = 10; i > 0; i--) {
        seminars.push({
            seminarId: i,
            title: "第 " + i + " 期 Thematic Seminar",
            themes: [random.ctitle()],
            description: random.sentence(30, 50),
            eventTime: new Date().getTime(),
            bilibiliUrl: random.boolean
                ? "https://www.bilibili.com/video/BV1K3411t7Uy"
                : null,
        });
    }
    return seminars;
};

const getSeminarNow = function () {
    let seminar = null;
    if (random.boolean) {
        seminar = {
            seminarId: 11,
            title: "第 11 期 Thematic Seminar",
            themes: [random.ctitle(), random.ctitle(), random.ctitle()],
            description: random.sentence(30, 50),
            eventTime: new Date().getTime(),
            bilibiliUrl: null,
        };
    }
    return seminar;
};

mockjs.mock(APIs.seminar_record, getSeminarRecords);
mockjs.mock(APIs.seminar_now, getSeminarNow);

export default mockjs;
