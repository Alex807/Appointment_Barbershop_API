import "./App.css";
import React from "react";
import Home from "./components/Home";
import Navbar from "./components/Navbar";
import AddBarbershop from "./components/AddBarbershop";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/users/" element={<AddBarbershop />} />   
        </Routes>
      </BrowserRouter>
  );
}

export default App;
