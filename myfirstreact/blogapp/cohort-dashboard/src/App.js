// src/App.js
import React from 'react';
import CohortDetails from './components/CohortDetails';

function App() {
  const cohorts = [
    {
      name: 'Alpha Cohort',
      startDate: '2023-01-01',
      endDate: '2023-06-30',
      status: 'Completed',
    },
    {
      name: 'Beta Cohort',
      startDate: '2023-07-01',
      endDate: '2023-12-31',
      status: 'Ongoing',
    },
    {
      name: 'Gamma Cohort',
      startDate: '2024-01-01',
      endDate: '2024-06-30',
      status: 'Upcoming',
    },
  ];

  return (
    <div style={{ padding: '20px' }}>
      <h1>Cohort Information</h1>
      {cohorts.map((cohort, index) => (
        <CohortDetails key={index} cohort={cohort} />
      ))}
    </div>
  );
}

export default App;
