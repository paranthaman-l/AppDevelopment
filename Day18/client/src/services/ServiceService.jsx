import { serviceApi } from "../apis/axios";

class ServiceService {
    getAllServices = () => serviceApi.get('/getAll');

    addService = (service,vid) => serviceApi.post('/postService', service,{params:{vid}});

    putService = (service) => serviceApi.put('/putService?vid='+localStorage.getItem("id"), service);

    deleteService = (sid) => serviceApi.post('/deleteService', { params: { sid } });

    getAllVendorServices = () => serviceApi.get("/getVendorServices", {params:{vid:localStorage.getItem("id")}});
}
export default new ServiceService();