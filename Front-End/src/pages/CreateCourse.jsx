import React, { useState, useEffect } from 'react';
import './CreateCourse.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function CreateCourse() {
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
        day: '',
        room: '',
        building: '',
        specialisationName: '',
        prerequisiteName: '',
        preDescription: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const token = JSON.parse(localStorage.getItem('jwtToken'));

        const res = await axios.post('http://localhost:8080/create-course',

        formData,
            {headers: {
            'Authorization': `Bearer ${token}`
        }},
        );
        if(res.status === 200) {
            console.log('Form Submitted', formData);
        }
    }; 


    const [prerequisiteOptions, setPrerequisiteOptions] = useState([]);
    const [specialisationOptions, setSpecialisationOptions] = useState([]);
    useEffect(() => {
        const token = JSON.parse(localStorage.getItem('jwtToken'));

        const fetchSpecialisation = async () => {
            
            try{
                const res = await axios.get('http://localhost:8080/specialisation-names', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                setSpecialisationOptions(res.data);
            } catch(e){
                console.log(e);
            }
        }

        const fetchPrecourse = async () => {
            try{
                const res = await axios.get('http://localhost:8080/course-names', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                setPrerequisiteOptions(res.data);
            } catch(e){
                console.log(e);
            }
        }

        fetchSpecialisation();
        fetchPrecourse();
    }, [])


    return (
        <div className="create-course-container">
            <form onSubmit={handleSubmit} className="create-course-form">
                <h2 className="create-course-header">Create Course</h2>

                {/* Course Code */}
                <div className="create-course-row">
                    <label htmlFor="courseCode" className="create-course-label">Course Code</label>
                    <input
                        type="text"
                        id="courseCode"
                        name="courseCode"
                        placeholder="Enter Course Code"
                        value={formData.courseCode}
                        onChange={handleChange}
                        className="create-course-input"
                        required
                    />
                </div>

                {/* Name */}
                <div className="create-course-row">
                    <label htmlFor="name" className="create-course-label">Name</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        placeholder="Enter Course Name"
                        value={formData.name}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Description */}
                <div className="create-course-row">
                    <label htmlFor="description" className="create-course-label">Description</label>
                    <input
                        type="text"
                        id="description"
                        name="description"
                        placeholder="Enter Course Description"
                        value={formData.description}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Year */}
                <div className="create-course-row">
                    <label htmlFor="year" className="create-course-label">Year</label>
                    <input
                        type="number"
                        id="year"
                        name="year"
                        placeholder="Enter Year"
                        value={formData.year}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Term */}
                <div className="create-course-row">
                    <label htmlFor="term" className="create-course-label">Term</label>
                    <input
                        type="number"
                        id="term"
                        name="term"
                        placeholder="Enter Term"
                        value={formData.term}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Faculty */}
                <div className="create-course-row">
                    <label htmlFor="faculty" className="create-course-label">Faculty</label>
                    <input
                        type="text"
                        id="faculty"
                        name="faculty"
                        placeholder="Enter Faculty Name"
                        value={formData.faculty}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Credits */}
                <div className="create-course-row">
                    <label htmlFor="credits" className="create-course-label">Credits</label>
                    <input
                        type="number"
                        id="credits"
                        name="credits"
                        placeholder="Enter Credits"
                        value={formData.credits}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Capacity */}
                <div className="create-course-row">
                    <label htmlFor="capacity" className="create-course-label">Capacity</label>
                    <input
                        type="number"
                        id="capacity"
                        name="capacity"
                        placeholder="Enter Course Capacity"
                        value={formData.capacity}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Time */}
                <div className="create-course-row">
                    <label htmlFor="time" className="create-course-label">Time</label>
                    <input
                        type="date"
                        id="time"
                        name="time"
                        value={formData.time}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Day */}
                <div className="create-course-row">
                    <label htmlFor="day" className="create-course-label">Day</label>
                    <input
                        type="text"
                        id="day"
                        name="day"
                        placeholder="Enter Day"
                        value={formData.day}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Room */}
                <div className="create-course-row">
                    <label htmlFor="room" className="create-course-label">Room</label>
                    <input
                        type="text"
                        id="room"
                        name="room"
                        placeholder="Enter Room Number"
                        value={formData.room}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Building */}
                <div className="create-course-row">
                    <label htmlFor="building" className="create-course-label">Building</label>
                    <input
                        type="text"
                        id="building"
                        name="building"
                        placeholder="Enter Building Name"
                        value={formData.building}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Specialisation Name Dropdown */}
                <div className="create-course-row">
                    <label htmlFor="specialisationName" className="create-course-label">Specialisation Name</label>
                    <select
                        id="specialisationName"
                        name="specialisationName"
                        value={formData.specialisationName}
                        onChange={handleChange}
                        className="create-course-select"
                    >
                        <option value="">Select Specialisation</option>
                        {specialisationOptions.map((option, index) => (
                            <option key={index} value={option}>
                                {option}
                            </option>
                        ))}
                    </select>
                </div>

                {/* Prerequisite Name Dropdown */}
                <div className="create-course-row">
                    <label htmlFor="prerequisiteName" className="create-course-label">Prerequisite Name</label>
                    <select
                        id="prerequisiteName"
                        name="prerequisiteName"
                        value={formData.prerequisiteName}
                        onChange={handleChange}
                        className="create-course-select"
                    >
                        <option value="">Select Prerequisite</option>
                        {prerequisiteOptions.map((option, index) => (
                            <option key={index} value={option}>
                                {option}
                            </option>
                        ))}
                    </select>
                </div>

                {/* Prerequisite Description */}
                <div className="create-course-row">
                    <label htmlFor="preDescription" className="create-course-label">Prerequisite Description</label>
                    <textarea
                        id="preDescription"
                        name="preDescription"
                        placeholder="Enter Prerequisite Description"
                        value={formData.preDescription}
                        onChange={handleChange}
                        className="create-course-input"
                    />
                </div>

                {/* Submit Button */}
                <button type="submit" className="create-course-btn">
                    Submit
                </button>
            </form>
        </div>
    );
}

export default CreateCourse;
