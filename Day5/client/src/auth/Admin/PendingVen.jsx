import { useEffect, useState } from "react"
import AdminService from "../../services/AdminService";

const PendingVen = () => {
  const [pendingVendors, setPendingVendors] = useState([]);
  useEffect(() => {
    const getPendingVendors = async () => {
      await AdminService.GetPendingVendors().then((res) => {
        const response = res.data;
        setPendingVendors(response.data);
        console.log(response.data);
      }).catch((err) => { console.log(err); })
    }
    getPendingVendors();
  }, [])

  return (
    <div>
      {pendingVendors?.map((vendor) => {
        return (
          <div key={vendor.vid} className="">
            <p>{vendor.firstName}</p>
          </div>
        )
      })}
    </div>
  )
}

export default PendingVen