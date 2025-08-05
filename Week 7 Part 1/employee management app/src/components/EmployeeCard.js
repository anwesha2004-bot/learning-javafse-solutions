import React, { useContext } from 'react';
import ThemeContext from '../ThemeContext';

function EmployeeCard({ employee }) {
  const theme = useContext(ThemeContext);

  const buttonStyle = {
    backgroundColor: theme === 'light' ? '#f0f0f0' : '#333',
    color: theme === 'light' ? '#000' : '#fff',
    padding: '8px 12px',
    border: 'none',
    borderRadius: '5px',
    marginTop: '8px',
    cursor: 'pointer'
  };

  return (
    <div style={{ marginBottom: '10px' }}>
      <p><strong>{employee.name}</strong> - {employee.role}</p>
      <button style={buttonStyle}>View Profile</button>
    </div>
  );
}

export default EmployeeCard;
