import React from 'react';

const CourseDetails = ({ courses }) => {
  return (
    <div>
      <h2>🎓 Course Details</h2>
      {courses.length > 0 && (
        <ul>
          {courses.map((course, index) => (
            <li key={index}>
              {course.name} - {course.duration}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default CourseDetails;
