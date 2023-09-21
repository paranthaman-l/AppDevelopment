import { useEffect, useState } from 'react'
// import { useNavigate } from 'react-router-dom';

const Navbar = () => {
  // const navigate = useNavigate();
  // eslint-disable-next-line no-unused-vars
  const [isScroll, setIsScrolled] = useState(false);
  const onScroll = () => {
    if (window.scrollY > 2) {
      setIsScrolled(true);
    } else {
      setIsScrolled(false);
    }
    return () => window.removeEventListener("scroll", onScroll);
  };
  useEffect(() => {
    window.addEventListener("scroll", onScroll);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);
  return (
    <div className={`navbar bg-white backdrop-blur-[2px] flex justify-between items-center fixed w-full top-0 z-50 h-20 px-10 duration-500 border-b`}>
      <div className="">
          <p className='text-3xl font-poppins font-black p-0 m-0 text-indigo hover:text-blue cursor-pointer'>Delta</p>
      </div>
      <div className="">
          <div className=""></div>
          <div className="">
            
          </div>
      </div>
    </div>
  )
}

export default Navbar