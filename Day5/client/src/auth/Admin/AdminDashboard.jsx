import { useState } from "react";
import DashboardNavbar from "./DashboardNavbar"
import Sidebar from "./Sidebar"
import {FcOrganization,FcShop} from 'react-icons/fc'
import {FaFileContract} from 'react-icons/fa'
import {TbNotes} from 'react-icons/tb'
const AdminDashboard = () => {
  const [showSidebar, setShowSidebar] = useState(true);
  return (
    <div className="flex flex-col">
      <DashboardNavbar setShowSidebar={setShowSidebar} showSidebar={showSidebar} />
      <div className="flex flex-col bg-bgGray min-h-screen">
        <Sidebar showSidebar={showSidebar} />
        <p className="ml-32 mt-24 mb-6 text-xl font-black font-nutnitoSans">Dashboard</p>
        <div className="pl-32 grid grid-flow-row w-full gap-4 grid-cols-3 min-h-full relative top-0 ">
          <div className="flex justify-between items-center h-40 w-96 font-nutnitoSans shadow-md hover:-translate-y-2 transition-all  delay-100 ease-in-out rounded-xl bg-white">
            <div className="">
              <p className="text-xl font-bold ml-16 mb-4 mx-4">Total Organizations</p>
              <p className="text-4xl text-start mx-8">1200</p>
            </div>
            <div className="">
              <FcOrganization className="text-7xl mr-10"/>
            </div>
          </div>
          <div className="flex justify-between items-center h-40 w-96 font-nutnitoSans shadow-md hover:-translate-y-2 transition-all  delay-100 ease-in-out rounded-xl bg-white">
            <div className="">
              <p className="text-xl font-bold ml-16 mb-4 mx-4">Total Vendors</p>
              <p className="text-4xl text-start mx-8">12000</p>
            </div>
            <div className="">
              <FcShop className="text-7xl mr-10"/>
            </div>
          </div>
          <div className="flex justify-between items-center h-40 w-96 font-nutnitoSans shadow-md hover:-translate-y-2 transition-all  delay-100 ease-in-out rounded-xl bg-white">
            <div className="">
              <p className="text-xl font-bold ml-16 mb-4 mx-4">Total Contracts</p>
              <p className="text-4xl text-start mx-8">120000</p>
            </div>
            <div className="">
              <FaFileContract className="text-7xl mr-10"/>
            </div>
          </div>
          <div className="flex justify-between items-center h-40 w-96 font-nutnitoSans shadow-md hover:-translate-y-2 transition-all  delay-100 ease-in-out rounded-xl bg-white">
            <div className="">
              <p className="text-xl font-bold ml-16 mb-4 mx-4">Total Complaint</p>
              <p className="text-4xl text-start mx-8">0</p>
            </div>
            <div className="">
              <TbNotes className="text-7xl mr-10"/>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default AdminDashboard