import React from 'react';
import { Link } from 'react-router-dom';

function TrainersList({ trainers }) {
  return (
    <div style={{ padding: '20px' }}>
      <h2>Trainer List</h2>
      {trainers.map(trainer => (
        <div key={trainer.id} style={{ marginBottom: '10px' }}>
          <Link to={`/trainers/${trainer.id}`}>
            {trainer.name} - {trainer.specialty}
          </Link>
        </div>
      ))}
    </div>
  );
}

export default TrainersList;
