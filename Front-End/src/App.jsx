import Login from "./pages/Login.jsx";
import CreateCourse from "./pages/CreateCourse.jsx";
import './App.css';

import {
  createBrowserRouter,
  RouterProvider
} from "react-router-dom";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Login />,
  },

  {
    path: "/create-course",
    element: <CreateCourse />,
  }
]);

function App() {
  return (
    <div className="App">
      <RouterProvider router={router} />
    </div>
  );
}

export default App;
