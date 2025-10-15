// import React, { useEffect, useState } from "react";
// import axios from "axios";

// const Home = () => {
//   const [products, setProducts] = useState([]);
//   const [isError, setIsError] = useState(false);

//   useEffect(() => {
//     const fetchData = async () => {
//       try {
//         const response = await axios.get("http://localhost:8080/barbershops/");
//         setProducts(response.data);
//         console.log(response.data);
//       } catch (error) {
//         console.error("Error fetching data:", error);
//         setIsError(true);
//       }
//     };

//     fetchData();
//   }, []);

//   if (isError) {
//     return (
//       <h2 className="text-center" style={{ padding: "10rem" }}>
//         Something went wrong...
//       </h2>
//     );
//   }

//   return (
//     <>
//       <div className="grid">
//         {products.map((product) => (
//           <div
//             className="card mb-3"
//             key={product.id}
//             style={{
//               width: "270px",
//               height: "210px",
//               boxShadow: "0 4px 8px rgba(0,0,0,0.1)",
//               borderRadius: "10px",
//               overflow: "hidden",

//               display: "flex",
//               flexDirection: "column",
//               justifyContent: "flex-start",
//               alignItems: "stretch",
//             }}
//           >
//             <div
//               className="card-body"
//               style={{
//                 flexGrow: 1,
//                 display: "flex",
//                 flexDirection: "column",
//                 justifyContent: "space-between",
//                 padding: "10px",
//               }}
//             >
//               <div>
//                 <h5
//                   className="card-title"
//                   style={{ margin: "0 0 10px 0", fontSize: "1.2rem" }}
//                 >
//                   {product.name.toUpperCase()}
//                 </h5>
//                 <i
//                   className="card-brand"
//                   style={{ fontStyle: "italic", fontSize: "0.8rem" }}
//                 >
//                   {"by " + product.brand}
//                 </i>
//               </div>
//               <hr className="hr-line" style={{ margin: "10px 0" }} />
//               <div className="home-cart-price">
//                 <h5
//                   className="card-text"
//                   style={{
//                     fontWeight: "600",
//                     fontSize: "1.1rem",
//                     marginBottom: "5px",
//                   }}
//                 >
//                   <i className="bi bi-currency-rupee"></i>
//                   {product.price}
//                 </h5>
//               </div>
//               <button
//                 className="btn-hover color-9"
//                 style={{ margin: "10px 25px 0px " }}
//               >
//                 Add To Cart
//               </button>
//             </div>
//           </div>
//         ))}
//       </div>
//     </>
//   );
// };

// export default Home;

import React, { useEffect, useState } from 'react';
import logo from '../assets/trimtime-logo.png';
import '../styles/Home.css';

const Home = () => {
  const [isLoaded, setIsLoaded] = useState(false);

  useEffect(() => {
    setIsLoaded(true);
  }, []);

  return (
    <section className="hero-section">
      <div className="hero-container">
        <div className="hero-content">
          {/* Animated Logo */}
          <div className={`logo-container ${isLoaded ? 'animate-in' : ''}`}>
            <img 
              src={logo} 
              alt="TrimTime Logo" 
              className="hero-logo"
            />
          </div>

          {/* Animated Title */}
          <div className={`title-container ${isLoaded ? 'animate-in' : ''}`}>
            <h1 className="hero-title">
              <span className="trim-text">Trim</span>
              <span className="and-symbol">&</span>
              <span className="time-text">Time</span>
            </h1>
          </div>

          {/* Subtitle */}
          <p className={`hero-subtitle ${isLoaded ? 'animate-in' : ''}`}>
            Book your perfect cut in seconds
          </p>

          {/* CTA Buttons */}
          <div className={`cta-buttons ${isLoaded ? 'animate-in' : ''}`}>
            <button className="btn btn-primary cta-btn">
              Book Now
            </button>
            <button className="btn btn-outline-primary cta-btn">
              Find Barbershops
            </button>
          </div>
        </div>

        {/* Floating Elements */}
        <div className="floating-elements">
          <div className="floating-scissors">✂️</div>
          <div className="floating-comb">🪮</div>
          <div className="floating-razor">🪒</div>
        </div>
      </div>
    </section>
  );
};

export default Home;
