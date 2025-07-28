import React from 'react';
import { useParams, Link } from 'react-router-dom';

function TrainerDetails({ trainers }) {
  const { id } = useParams();
  const trainer = trainers.find(t => t.id === parseInt(id));

  if (!trainer) {
    return (
      <div>
        <p>Trainer not found!</p>
        <Link to="/trainers">Back to Trainers List</Link>
      </div>
    );
  }

  return (
    <div style={{ padding: '20px' }}>
      <h2>{trainer.name}</h2>
      <p><strong>Specialty:</strong> {trainer.specialty}</p>
      <p><strong>Experience:</strong> {trainer.experience} years</p>
      <Link to="/trainers">⬅ Back to Trainers List</Link>
    </div>
  );
}

export default TrainerDetails;
