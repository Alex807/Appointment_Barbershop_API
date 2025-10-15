import React from 'react';
import Navbar from '../components/Navbar';
import Home from '../components/Home';
import BarbershopCarousel from '../components/BarbershopCarousel';
import '../styles/Home.css';

const HomePage = () => {
  return (
    <div className="homepage">
      <Navbar />
      <Home />
      <BarbershopCarousel />
    </div>
  );
};

export default HomePage;