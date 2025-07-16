import { useState } from "react";
import axios from "axios";


const Login = () => {
  const [name, setName] = useState("");
  const [password, setPassword] = useState("");
 

  async function handleLogin(event) {
    event.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:3001/api/auth/login", 
        {
          name, 
          password,
        }
      );
      const token = response.data; 
      localStorage.setItem("token", token); 
      alert(token);
      alert("Login Successful");
    } catch (e) {
      console.log(e);
      console.error("Login error:", e.response?.data || e.message);

      
    }
  }

  return (
    <div>
      <h2>Login</h2>
      <div>
        <form onSubmit={handleLogin}>
          <label htmlFor="name">User Name</label>
          <input
            id="name"
            name="name"
            value={name}
            type="text"
            onChange={(e) => setName(e.target.value)}
          />
          <br /> <br />
          <label htmlFor="password">Password</label>
          <input
            id="password"
            name="password"
            value={password}
            type="password"
            onChange={(e) => setPassword(e.target.value)}
          />
          <br />
          <br />
          <button type="submit">Login</button>
        </form>
      </div>
    </div>
  );
};

export default Login;