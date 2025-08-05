import React from 'react';

function App() {
  // JSX Heading
  const heading = <h1 style={{ textAlign: 'center' }}>Office Space Rental Portal</h1>;

  // Office image URL
  const imgUrl = "https://images.unsplash.com/photo-1560448204-e02f11c3d0e2";

  // Office list (Array of objects)
  const offices = [
    { name: "TechHub", rent: 45000, address: "Kolkata, Sector V" },
    { name: "WorkNest", rent: 70000, address: "Bangalore, Indiranagar" },
    { name: "StartupSpace", rent: 60000, address: "Hyderabad, Hitech City" },
    { name: "SmartDesk", rent: 55000, address: "Mumbai, Powai" },
    { name: "CoWorkZone", rent: 75000, address: "Pune, Hinjawadi" }
  ];

  return (
    <div>
      {heading}

      {/* JSX Image with attribute */}
      <img 
        src={imgUrl} 
        alt="Office Space" 
        width="60%" 
        style={{ display: 'block', margin: 'auto', borderRadius: '10px' }} 
      />

      <h2 style={{ textAlign: 'center', marginTop: '30px' }}>Available Spaces</h2>

      <ul style={{ listStyle: 'none', padding: 0 }}>
        {offices.map((office, index) => (
          <li key={index} style={{ 
            margin: '15px auto', 
            padding: '15px', 
            border: '1px solid #ccc', 
            width: '60%', 
            borderRadius: '10px', 
            boxShadow: '2px 2px 8px rgba(0,0,0,0.1)' 
          }}>
            <h3>{office.name}</h3>
            <p>
              <strong>Address:</strong> {office.address}
            </p>
            <p style={{ 
              color: office.rent > 60000 ? 'green' : 'red',
              fontWeight: 'bold'
            }}>
              Rent: ₹{office.rent}
            </p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
