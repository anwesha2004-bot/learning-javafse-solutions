import React, { useState } from 'react';

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!employeeName || !complaint) {
      alert("Please fill in all fields.");
      return;
    }

    const referenceNumber = "REF" + Math.floor(1000 + Math.random() * 9000);
    alert(`Complaint submitted successfully!\nReference Number: ${referenceNumber}`);

    // Reset form
    setEmployeeName('');
    setComplaint('');
  };

  return (
    <div style={{ padding: '20px', maxWidth: '500px', margin: 'auto' }}>
      <h2>Complaint Registration Form</h2>
      <form onSubmit={handleSubmit}>
        <label>Employee Name:</label><br />
        <input
          type="text"
          value={employeeName}
          onChange={(e) => setEmployeeName(e.target.value)}
          placeholder="Enter your name"
          style={{ width: '100%', padding: '8px', margin: '10px 0' }}
        />
        <br />
        <label>Complaint:</label><br />
        <textarea
          value={complaint}
          onChange={(e) => setComplaint(e.target.value)}
          placeholder="Describe your complaint"
          rows="4"
          style={{ width: '100%', padding: '8px', margin: '10px 0' }}
        />
        <br />
        <button type="submit" style={{ padding: '10px 20px' }}>
          Submit Complaint
        </button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
