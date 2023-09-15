import React from 'react'
import { useNavigate } from 'react-router-dom'
import HomeNavbar from '../component/HomeNavbar';
const Home = () => {
  const navigate = useNavigate();
  return (
    <div>
      <HomeNavbar />
      <p className='text-'>HOME</p>

      <button onClick={() => navigate('/login')}>
        Logout
      </button>
    </div>
  )
}

export default Home