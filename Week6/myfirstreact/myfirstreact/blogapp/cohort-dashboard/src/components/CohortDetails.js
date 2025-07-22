// src/components/CohortDetails.js
import React from 'react';

const CohortDetails = ({ cohort }) => {
  if (!cohort) return null; // Prevents error if cohort is undefined

  return (
    <div style={styles.card}>
      <h2>{cohort.name}</h2>
      <p><strong>Start Date:</strong> {cohort.startDate}</p>
      <p><strong>End Date:</strong> {cohort.endDate}</p>
      <p><strong>Status:</strong> {cohort.status}</p>
    </div>
  );
};

const styles = {
  card: {
    border: '1px solid #ccc',
    padding: '15px',
    marginBottom: '10px',
    borderRadius: '8px',
    backgroundColor: '#f9f9f9',
  }
};

export default CohortDetails;
