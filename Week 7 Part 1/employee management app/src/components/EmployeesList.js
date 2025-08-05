import React from 'react';
import EmployeeCard from './EmployeeCard';

const employees = [
  { id: 1, name: 'Dhoni', role: 'Captain' },
  { id: 2, name: 'Kohli', role: 'Batsman' },
  { id: 3, name: 'Bumrah', role: 'Bowler' }
];

function EmployeesList() {
  return (
    <div>
      <h2>Employees</h2>
      {employees.map(emp => (
        <EmployeeCard key={emp.id} employee={emp} />
      ))}
    </div>
  );
}

export default EmployeesList;
