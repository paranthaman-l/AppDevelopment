import Login from "./page/Login";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import SignUp from "./page/SignUp";
import Home from "./page/Home";
import Landing from "./page/Landing";
// import Navbar from "./component/Navbar";
function App() {
  return (
    <div>
      <BrowserRouter>
      {/* <Navbar/> */}
        <Routes>
          <Route path="/" element={<Landing/>} />
          <Route path="/login" element={<Login/>} />
          <Route path="/signup" element={<SignUp/>} />
          <Route path="/home" element={<Home/>} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
