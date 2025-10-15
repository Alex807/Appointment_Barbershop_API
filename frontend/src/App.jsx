// import "./App.css";
// import React from "react";
// import Home from "./components/Home";
// import Navbar from "./components/Navbar";
// import AddBarbershop from "./components/AddBarbershop";
// import { BrowserRouter, Routes, Route } from "react-router-dom";

// function App() {
//   return (
//       <BrowserRouter>
//         <Navbar />
//         <Routes>
//           <Route path="/" element={<Home />} />
//           <Route path="/users/" element={<AddBarbershop />} />   
//         </Routes>
//       </BrowserRouter>
//   );
// }

// export default App;

import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './pages/HomePage';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<HomePage />} />
          {/* Add other routes here */}
        </Routes>
      </div>
    </Router>
  );
}

export default App;
