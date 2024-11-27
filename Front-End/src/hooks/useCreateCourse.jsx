import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';


const useCreateCourse = () => {
    const [formData, setFormData] = useState({
        courseCode: '',
        name: '',
        description: '',
        year: '',
        term: '',
        faculty: '',
        credits: '',
        capacity: '',
        time: '',
        day: [],
        room: '',
        building: '',
        specialisationName: '',
        prerequisiteName: [],
        preDescription: ''
    });
    const [prerequisiteOptions, setPrerequisiteOptions] = useState([]);
    const [specialisationOptions, setSpecialisationOptions] = useState([]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value
        }));
    };

    const handlePrerequisiteChange = (selectedCourses) => {
        setFormData((prevData) => ({
            ...prevData,
            prerequisiteName: selectedCourses,
        }));
    };

    const handleSpecialisationChange = (selectedSpecialisation) => {
        setFormData((prevData) => ({
            ...prevData,
            specialisationName: selectedSpecialisation,
        }));
    };

    const handleDays = (selectedDays) => {
        setFormData((prevData) => ({
            ...prevData,
            day: selectedDays,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const token = JSON.parse(localStorage.getItem('jwtToken'));

        const res = await axios.post('http://localhost:8080/create-course',

            formData,
            {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            },
        );
        if (res.status === 200) {
            console.log('Form Submitted', formData);
            alert('Form submitted succesfully!');
            // console.log(formData);
            window.location.reload();
        }
        else {
            console.log(formData);
        }
    };

    return {formData, prerequisiteOptions, setPrerequisiteOptions, specialisationOptions, setSpecialisationOptions, handleChange,   handleSpecialisationChange, handlePrerequisiteChange, handleDays, handleSubmit}
}
export default useCreateCourse;