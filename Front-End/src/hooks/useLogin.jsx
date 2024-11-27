import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const useLogin = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const navigate = useNavigate();

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
    };

    return {email, setEmail, password, setPassword, handleSubmit};
}

export default useLogin;