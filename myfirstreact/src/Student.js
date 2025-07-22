import React from 'react';

function Student(props) {
  return (
    <div style={{ border: '1px solid gray', padding: '10px', margin: '10px' }}>
      <h2>{props.name}</h2>
      <p>Age: {props.age}</p>
      <p>Course: {props.course}</p>
    </div>
  );
}

export default Student;
