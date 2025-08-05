import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainerList';
import TrainerDetails from './TrainerDetails';
import TrainersData from './TrainerMock';

function App() {
  console.log("App is rendering...");

  return (
    <Router>
      <div>
        <nav style={{ textAlign: 'center', margin: '20px' }}>
          <Link to="/" style={{ marginRight: '20px' }}>Home</Link>
          <Link to="/trainers">Trainers</Link>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainers={TrainersData} />} />
          <Route path="/trainers/:id" element={<TrainerDetails trainers={TrainersData} />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
