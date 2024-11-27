import React, { useState, useEffect } from 'react';
import './CreateCourse.css';

import axios from 'axios';
import useCreateCourse from '../hooks/useCreateCourse';
import { useNavigate } from 'react-router-dom';
import {
    Select
} from 'antd';

const { Option } = Select;

function CreateCourse() {

    const { formData, prerequisiteOptions, setPrerequisiteOptions, specialisationOptions, setSpecialisationOptions, handleChange, handleSpecialisationChange, handlePrerequisiteChange, handleDays, handleSubmit } = useCreateCourse();

    useEffect(() => {
        const token = JSON.parse(localStorage.getItem('jwtToken'));

        const fetchSpecialisation = async () => {

            try {
                const res = await axios.get('http://localhost:8080/specialisation-names', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                setSpecialisationOptions(res.data);
            } catch (e) {
                console.log(e);
            }
        }

        const fetchPrecourse = async () => {
            try {
                const res = await axios.get('http://localhost:8080/course-names', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                setPrerequisiteOptions(res.data);
            } catch (e) {
                console.log(e);
            }
        }

        fetchSpecialisation();
        fetchPrecourse();
    }, []);

    return (
        <div className="create-course-container">
            <form onSubmit={handleSubmit} className="create-course-form">
                <h2 className="create-course-header">Create Course</h2>


                <div className="create-course-row1">
                    <div className='create-corese-ind'>
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

                    <div>
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
                </div>


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

                <div className="create-course-row1">
                    <div className="create-corese-ind">
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

                    <div>
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
                </div>

                <div className="create-course-row1">
                    <div className="create-corese-ind">
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

                    <div>
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
                </div>


                <div className="create-course-row1">
                    <div className="create-corese-ind">
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



                    <div className="create-course-row">
                        <label htmlFor="time" className="create-course-label">Select Time</label>
                        <input type="time"
                            id="time"
                            name="time"
                            placeholder="Enter Course time"
                            value={formData.time}
                            onChange={handleChange}
                            className="create-course-input"
                        />
                    </div>
                </div>


                <div className="create-course-row">
                    <label htmlFor="day" className="create-course-label">Day</label>
                    <Select
                        mode="multiple"
                        placeholder="Select Days"
                        id="day"
                        name="day"
                        value={formData.day}
                        onChange={handleDays}
                        className="create-course-select"
                    >

                        <Option value="Monday">Monday</Option>
                        <Option value="Tuesday">Tuesday</Option>
                        <Option value="Wednesday">Wednesday</Option>
                        <Option value="Thursday">Thursday</Option>
                        <Option value="Friday">Friday</Option>
                        <Option value="Saturday">Saturday</Option>
                        <Option value="Sunday">Sunday</Option>

                    </Select>
                </div>


                <div className="create-course-row1">
                    <div className="create-corese-ind">
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


                    <div>
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
                </div>


                <div className="create-course-row">
                    <label htmlFor="specialisationName" className="create-course-label">Specialisation Name</label>
            
                   <Select
                        placeholder="Select Specialisation"
                        id="specialisationName"
                        name="specialisationName"
                        value={formData.specialisationName}
                        onChange={handleSpecialisationChange}
                        className="create-course-select1"
                    >
                        {specialisationOptions.map((op, index) => (
                            <Option key={index} value={op}>{op}</Option>
                        ))}
                    </Select>

                </div>


                <div className="create-course-row">
                    <label htmlFor="prerequisiteName" className="create-course-label">Prerequisite Name</label>
                    <Select
                        mode="multiple"
                        placeholder="Select Prerequisite"
                        id="prerequisiteName"
                        name="prerequisiteName"
                        value={formData.prerequisiteName}
                        onChange={handlePrerequisiteChange}
                        className="create-course-select"
                    >
                        {prerequisiteOptions.map((op, index) => (
                            <Option key={index} value={op}>{op}</Option>
                        ))}
                    </Select>
                </div>


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


                <button type="submit" className="create-course-btn">
                    Submit
                </button>
            </form>
        </div>
    );
}

export default CreateCourse;