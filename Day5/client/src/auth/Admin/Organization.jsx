import { useState } from "react";
import DashboardNavbar from "./DashboardNavbar"
import Sidebar from "./Sidebar"
import PendingOrg from "./PendingOrg";
import ApprovedOrg from "./ApprovedOrg";
const Organization = () => {
  const [showSidebar, setShowSidebar] = useState(true);
  const [showContent, setShowContent] = useState('pending');
  return (
    <div className="flex flex-col">
      <DashboardNavbar setShowSidebar={setShowSidebar} showSidebar={showSidebar} />
      <div className="flex flex-col bg-bgGray min-h-screen">
        <Sidebar showSidebar={showSidebar} />
        <p className="ml-32 mt-24 mb-6 text-xl font-black font-nutnitoSans">Organization</p>
        <div className="pl-32  min-h-full w-full relative top-0 ">
          <div className="font-nutnitoSans flex justify-between items-center text-lg">
            <ul className="flex items-center">
              <li onClick={() => setShowContent('pending')} className={` ${showContent === 'pending' ? "bg-blue" : "bg-gray bg-opacity-40"} px-5 py-1 mx-3 rounded-xl cursor-pointer`}>
                Pending
              </li>
              <li onClick={() => setShowContent('approved')} className={` ${showContent === 'approved' ? "bg-blue" : "bg-gray bg-opacity-40"} px-5 py-1 mx-3 rounded-xl cursor-pointer`}>
                Approved
              </li>
            </ul>
            <div className="pr-10">
              <button>Add Organization</button>
            </div>
          </div>
          {showContent === 'pending' ?
            <PendingOrg /> : <ApprovedOrg />
          }
        </div>
      </div>
    </div>
  )
}

export default Organization