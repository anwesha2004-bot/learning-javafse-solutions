import React from 'react';

const BlogDetails = ({ blogs }) => {
  return (
    <div>
      <h2>📝 Blog Details</h2>
      {blogs.length === 0 ? (
        <p>No blogs found.</p>
      ) : (
        <ul>
          {blogs.map((blog, index) => (
            <li key={index}>
              <strong>{blog.title}</strong> - {blog.topic}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default BlogDetails;
