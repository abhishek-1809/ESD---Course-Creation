
// import React, { useState } from 'react';

// function Login() {
//     // State to manage form fields
//     const [email, setEmail] = useState('');
//     const [password, setPassword] = useState('');

//     // Handle form submission
//     const handleSubmit = (e) => {
//         e.preventDefault();

//         if (!email || !password) {
//             alert('Please fill in both email and password.');
//             return;
//         }

//         // Simulate login (you can replace this with an actual API call)
//         if (email === 'user@example.com' && password === 'password123') {
//             alert('Login successful!');
//             // Redirect to dashboard or another page
//         } else {
//             alert('Invalid email or password.');
//         }
//     };

//     return (
//         <div className="min-vh-100 d-flex justify-content-center align-items-center">
//             <div className="container">
//                 <form onSubmit={handleSubmit} className="p-4 shadow-lg rounded bg-white" style={{ textAlign: 'left', minWidth: '450px' }}>
//                     <h4 className="mb-4 text-center text-dark fw-semibold">Login</h4>

//                     <div className="mb-3">
//                         <label htmlFor="email" className="form-label text-muted" style={{ fontSize: '1.4rem', fontWeight: '600', color: '#555' }}>Email Address</label>
//                         <input
//                             type="email"
//                             className="form-control"
//                             id="email"
//                             placeholder="Enter your email"
//                             value={email}
//                             onChange={(e) => setEmail(e.target.value)}
//                         />
//                     </div>

//                     <div className="mb-3" style={{ marginTop: '3vh' }}>
//                         <label htmlFor="password" className="form-label text-muted" style={{ fontSize: '1.4rem', fontWeight: '600', color: '#555' }}>Password</label>
//                         <input
//                             type="password"
//                             className="form-control"
//                             id="password"
//                             placeholder="Enter your password"
//                             value={password}
//                             onChange={(e) => setPassword(e.target.value)}
//                         />
//                     </div>

//                     <button
//                         type="submit"
//                         className="btn btn-primary w-100 mb-3 fw-semibold" style={{ marginTop: '3vh' }}
//                     >
//                         Login
//                     </button>
//                 </form>
//             </div>
//         </div>
//     );
// }

// export default Login;
import React, { useState } from 'react';
import './Login.css';  // Import the external CSS file
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Login() {
  // State to manage form fields
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const navigate = useNavigate();

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!email || !password) {
      alert('Please fill in both email and password.');
      return;
    }

    const res = await axios.post('http://localhost:8080/login', {
        email,
        password
    });

    localStorage.setItem("jwtToken", JSON.stringify(res.data));
    
    navigate("/create-course");

    // // Simulate login (you can replace this with an actual API call)
    // if (email === 'user@example.com' && password === 'password123') {
    //   alert('Login successful!');
    //   // Redirect to dashboard or another page
    // } else {
    //   alert('Invalid email or password.');
    // }
  };

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
