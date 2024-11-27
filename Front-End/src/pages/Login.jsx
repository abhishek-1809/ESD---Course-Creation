import React, { useState } from 'react';
import './Login.css';
import useLogin from '../hooks/useLogin';

function Login() {
  
  const {email, setEmail, password, setPassword, handleSubmit} = useLogin();

  return (
    <div className="login-container">
      <div className="login-form-container">
        <form onSubmit={handleSubmit}>
          <h4 className="login-header">Login</h4>

          <div className="mb-3">
            <label htmlFor="email" className="form-label">Email Address</label>
            <input
              type="email"
              className="form-control"
              id="email"
              placeholder="Enter your email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>

          <div className="mb-3">
            <label htmlFor="password" className="form-label">Password</label>
            <input
              type="password"
              className="form-control"
              id="password"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>

          <button type="submit" className="login-btn">
            Login
          </button>
        </form>
      </div>
    </div>
  );
}

export default Login;