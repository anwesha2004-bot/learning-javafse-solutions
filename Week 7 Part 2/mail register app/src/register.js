import React, { useState } from 'react';

function Register() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: ''
  });

  const [errors, setErrors] = useState({});

  const validate = () => {
    const newErrors = {};

    if (formData.name.trim().length < 5) {
      newErrors.name = 'Name must be at least 5 characters long.';
    }

    if (!formData.email.includes('@') || !formData.email.includes('.')) {
      newErrors.email = 'Email must contain "@" and "."';
    }

    if (formData.password.length < 8) {
      newErrors.password = 'Password must be at least 8 characters long.';
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      alert(`Registration Successful!\nReference No: REF${Math.floor(Math.random() * 10000)}`);
      setFormData({ name: '', email: '', password: '' });
      setErrors({});
    }
  };

  return (
    <div style={{ maxWidth: '400px', margin: 'auto', padding: '20px' }}>
      <h2>Mail Registration Form</h2>
      <form onSubmit={handleSubmit}>
        <label>Name:</label><br />
        <input
          type="text"
          name="name"
          value={formData.name}
          onChange={handleChange}
          placeholder="Enter your name"
        />
        {errors.name && <p style={{ color: 'red' }}>{errors.name}</p>}

        <br />
        <label>Email:</label><br />
        <input
          type="text"
          name="email"
          value={formData.email}
          onChange={handleChange}
          placeholder="Enter your email"
        />
        {errors.email && <p style={{ color: 'red' }}>{errors.email}</p>}

        <br />
        <label>Password:</label><br />
        <input
          type="password"
          name="password"
          value={formData.password}
          onChange={handleChange}
          placeholder="Enter your password"
        />
        {errors.password && <p style={{ color: 'red' }}>{errors.password}</p>}

        <br /><br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;
