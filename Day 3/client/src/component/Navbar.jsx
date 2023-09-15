import React, { useEffect, useState } from 'react'

const Navbar = () => {
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
    <div
      className={`navbar bg-black flex justify-between items-center fixed w-full top-0 z-50 h-16 px-3 duration-500 border-b`}
    >
    </div>
  )
}

export default Navbar