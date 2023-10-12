import { adminApi } from "../apis/axios";

class AdminService {
    getAdminData = (aid) => adminApi.get('/byAid', { params: { aid } });

    updateName = (data) => adminApi.put('/updateName', data);

    updateProfile = (data) =>  adminApi.put('/updateProfile', data);

    updateBanner = (data) => adminApi.put('/updateBanner', data);

    approveVendor = (vid) => adminApi.put('/approveVendor?vid=' + vid);

    approveOrganization = (oid) => adminApi.put('/approveOrganization', { params: { oid } });

    getCount = () => adminApi.get('/getCount');

    getVendors = (verified) => adminApi.get('/getVendors', { params: { verified } });
}
export default new AdminService();