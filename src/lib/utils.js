import axios from "axios";
import { ElMessage } from "element-plus";
import "element-plus/dist/index.css";

class HttpTool {
    get(url, params) {
        return axios.get(url, params).catch((reason) => {
            ElMessage.error(reason);
        });
    }

    post(url, data) {
        return axios.post(url, data).catch((reason) => {
            ElMessage.error(reason);
        });
    }
}

const httpTool = new HttpTool();

export { httpTool };
