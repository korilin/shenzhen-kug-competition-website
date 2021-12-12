import axios from "axios";
import { ElMessage } from "element-plus";
import "element-plus/dist/index.css";

axios.interceptors.request.use(
    (config) => {
        return config;
    },
    (error) => {
        console.log(error);
        ElMessage.error("网络请求超时");
        return Promise.resolve(err);
    }
);

axios.interceptors.response.use(
    (response) => {
        console.log(response);
        return response;
    },
    (error) => {
        console.log(error);
        ElMessage.error(reason);
        return Promise.resolve(error);
    }
);

class HttpTool {
    get(url) {
        return axios.get(url);
    }

    post(url, data) {
        return axios.post(url, data);
    }
}

const httpTool = new HttpTool();

export default httpTool;
