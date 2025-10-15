import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../styles/Carousel.css';

const BarbershopCarousel = () => {
  const [barbershops, setBarbershops] = useState([]);
  const [currentIndex, setCurrentIndex] = useState(0);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchBarbershops();
  }, []);

  const fetchBarbershops = async () => {
    try {
      const response = await axios.get('http://localhost:8080/barbershops');
      setBarbershops(response.data);
      setLoading(false);
    } catch (error) {
      console.error('Error fetching barbershops:', error);
      // Fallback data for development
      setBarbershops([
        { id: 1, name: 'Classic Cuts', city: 'Bucharest', street: 'Calea Victoriei 15', phone: '0212345678' },
        { id: 2, name: 'Modern Style', city: 'Cluj-Napoca', street: 'Strada Memorandumului 28', phone: '0264123456' },
        { id: 3, name: 'Gentlemen\'s Corner', city: 'Timisoara', street: 'Bulevardul Revolutiei 7', phone: '0256789012' },
      ]);
      setLoading(false);
    }
  };

  const nextSlide = () => {
    setCurrentIndex((prevIndex) => 
      prevIndex === barbershops.length - 1 ? 0 : prevIndex + 1
    );
  };

  const prevSlide = () => {
    setCurrentIndex((prevIndex) => 
      prevIndex === 0 ? barbershops.length - 1 : prevIndex - 1
    );
  };

  const goToSlide = (index) => {
    setCurrentIndex(index);
  };

  if (loading) {
    return (
      <section className="carousel-section">
        <div className="container">
          <h2 className="section-title">Our Barbershops</h2>
          <div className="loading-spinner">Loading...</div>
        </div>
      </section>
    );
  }

  return (
    <section className="carousel-section">
      <div className="container">
        <h2 className="section-title">Our Barbershops</h2>
        
        <div className="carousel-container">
          <button className="carousel-btn prev-btn" onClick={prevSlide}>
            <i className="bi bi-chevron-left"></i>
          </button>

          <div className="carousel-wrapper">
            <div 
              className="carousel-track"
              style={{ transform: `translateX(-${currentIndex * 100}%)` }}
            >
              {barbershops.map((barbershop) => (
                <div key={barbershop.id} className="carousel-slide">
                  <div className="barbershop-card">
                    <div className="card-image">
                      <div className="barbershop-icon">💈</div>
                    </div>
                    <div className="card-content">
                      <h3 className="barbershop-name">{barbershop.name}</h3>
                      <p className="barbershop-location">
                        <i className="bi bi-geo-alt"></i>
                        {barbershop.street}, {barbershop.city}
                      </p>
                      <p className="barbershop-phone">
                        <i className="bi bi-telephone"></i>
                        {barbershop.phone}
                      </p>
                      <button className="btn btn-primary book-btn">
                        Book Appointment
                      </button>
                    </div>
                  </div>
                </div>
              ))}
            </div>
          </div>

          <button className="carousel-btn next-btn" onClick={nextSlide}>
            <i className="bi bi-chevron-right"></i>
          </button>
        </div>

        {/* Carousel Indicators */}
        <div className="carousel-indicators">
          {barbershops.map((_, index) => (
            <button
              key={index}
              className={`indicator ${index === currentIndex ? 'active' : ''}`}
              onClick={() => goToSlide(index)}
            />
          ))}
        </div>
      </div>
    </section>
  );
};

export default BarbershopCarousel;